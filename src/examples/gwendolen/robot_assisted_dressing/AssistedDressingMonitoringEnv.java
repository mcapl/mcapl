package gwendolen.robot_assisted_dressing;

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ajpf.util.choice.Choice;

public class AssistedDressingMonitoringEnv extends DefaultEnvironment {


    private static final double P_MONITOR_DRESSING_IN_PROGRESS = 0.80;
    private static final double P_MONITOR_UNDETECTED_ESCALATION = 0.05;
    private static final double P_MONITOR_DETECTED_ESCALATION = 0.15;

    private static final double P_SELECT_REQUEST_HRI = 0.40;
    private static final double P_SELECT_AUTONOMOUS_RESOLUTION = 0.45;
    private static final double P_SELECT_ABORT = 0.15;

    private static final double P_HRI_ABORT = 0.10;
    private static final double P_HRI_RESUME_DRESSING = 0.90;

    private static final double P_AUTO_ABORT = 0.10;
    private static final double P_AUTO_RETRY = 0.35;
    private static final double P_AUTO_RESUME_DRESSING = 0.55;

    private static final int MAX_DRESSING_PROGRESS = 3;
    private static final int MAX_AUTONOMOUS_ATTEMPTS = 3;

    private Choice<Integer> monitorChoice;
    private Choice<Integer> mitigationChoice;
    private Choice<Integer> hriChoice;
    private Choice<Integer> autonomousRecoveryChoice;

    private int dressingProgress = 0;
    private int autonomousAttempts = 0;
    private boolean terminal = false;

    @Override
    public void setMAS(MAS mas) {
        super.setMAS(mas);

        monitorChoice = new Choice<Integer>(mas.getController());
        monitorChoice.addChoice(P_MONITOR_DRESSING_IN_PROGRESS, 0);
        monitorChoice.addChoice(P_MONITOR_UNDETECTED_ESCALATION, 1);
        monitorChoice.addChoice(P_MONITOR_DETECTED_ESCALATION, 2);

        mitigationChoice = new Choice<Integer>(mas.getController());
        mitigationChoice.addChoice(P_SELECT_REQUEST_HRI, 0);
        mitigationChoice.addChoice(P_SELECT_AUTONOMOUS_RESOLUTION, 1);
        mitigationChoice.addChoice(P_SELECT_ABORT, 2);

        hriChoice = new Choice<Integer>(mas.getController());
        hriChoice.addChoice(P_HRI_ABORT, 0);
        hriChoice.addChoice(P_HRI_RESUME_DRESSING, 1);

        autonomousRecoveryChoice = new Choice<Integer>(mas.getController());
        autonomousRecoveryChoice.addChoice(P_AUTO_ABORT, 0);
        autonomousRecoveryChoice.addChoice(P_AUTO_RETRY, 1);
        autonomousRecoveryChoice.addChoice(P_AUTO_RESUME_DRESSING, 2);

        System.out.println("[ENV] AssistedDressingMonitoringEnv initialised.");
        System.out.println("[ENV] RAD operation is abstracted as monitor outcomes.");
        System.out.println("[ENV] Maximum dressing progress ticks: " + MAX_DRESSING_PROGRESS);
        printMonitorDistribution();
        printMitigationDistribution();
        printHRIDistribution();
        printAutonomousRecoveryDistribution();
    }

    @Override
    public Unifier executeAction(String agName, Action action) throws AILexception {
        String actionName = action.getFunctor();

        System.out.println();
        System.out.println("[ENV] --------------------------------------------------");
        System.out.println("[ENV] Agent " + agName + " executes action: " + actionName);

        if (actionName.equals("observe_dressing")) {
            executeObserveDressing(agName);
        } else if (actionName.equals("select_mitigation_strategy")) {
            executeSelectMitigationStrategy(agName);
        } else if (actionName.equals("user_assistance")) {
            executeUserAssistance(agName);
        } else if (actionName.equals("autonomous_recovery_attempt")) {
            executeAutonomousRecoveryAttempt(agName);
        } else if (actionName.equals("move_home")) {
            executeMoveHome(agName);
        } else {
            System.out.println("[ENV] No environment effect defined for action: " + actionName);
        }

        System.out.println("[ENV] Finished action: " + actionName);
        System.out.println("[ENV] --------------------------------------------------");

        return super.executeAction(agName, action);
    }

    private void executeObserveDressing(String agName) {
        if (terminal) {
            System.out.println("[ENV] Terminal state already reached. No new monitoring percept generated.");
            return;
        }

        clearTransientRADPercepts(agName);
        printMonitorDistribution();
        int outcome = monitorChoice.get_choice();

        dressingProgress = Math.min(dressingProgress + 1, MAX_DRESSING_PROGRESS);
        System.out.println("[ENV] Dressing progress tick: " + dressingProgress + " / " + MAX_DRESSING_PROGRESS);

        switch (outcome) {
            case 0:
                System.out.println("[ENV] observe_dressing sampled outcome 1.");

                if (dressingProgress >= MAX_DRESSING_PROGRESS) {
                    System.out.println("[ENV] Effect: +completed.");
                    terminal = true;
                    addPercept(agName, new Predicate("completed"));
                } else {
                    System.out.println("[ENV] Effect: +dressing_in_progress and progress++.");
                    addPercept(agName, new Predicate("dressing_in_progress"));
                }
                break;

            case 1:
                System.out.println("[ENV] observe_dressing sampled outcome 2.");
                System.out.println("[ENV] Effect: +undetected_escalation and progress++.");
                addPercept(agName, new Predicate("undetected_escalation"));
                break;

            case 2:
                System.out.println("[ENV] observe_dressing sampled outcome 3.");
                System.out.println("[ENV] Effect: +detected_escalation and progress++.");
                addPercept(agName, new Predicate("detected_escalation"));
                break;

            default:
                throw new IllegalStateException("Unexpected monitor outcome: " + outcome);
        }
    }

    private void executeSelectMitigationStrategy(String agName) {
        if (terminal) {
            System.out.println("[ENV] Terminal state already reached. Mitigation ignored.");
            return;
        }

        clearTransientRADPercepts(agName);

        printMitigationDistribution();
        int outcome = mitigationChoice.get_choice();

        switch (outcome) {
            case 0:
                System.out.println("[ENV] select_mitigation_strategy sampled outcome 1.");
                System.out.println("[ENV] Effect: +request_hri.");
                addPercept(agName, new Predicate("request_hri"));
                break;

            case 1:
                System.out.println("[ENV] select_mitigation_strategy sampled outcome 2.");
                System.out.println("[ENV] Effect: +autonomous_resolution.");
                addPercept(agName, new Predicate("autonomous_resolution"));
                break;

            case 2:
                System.out.println("[ENV] select_mitigation_strategy sampled outcome 3.");
                System.out.println("[ENV] Effect: +aborted.");
                terminal = true;
                addPercept(agName, new Predicate("aborted"));
                break;

            default:
                throw new IllegalStateException("Unexpected mitigation outcome: " + outcome);
        }
    }

    private void executeUserAssistance(String agName) {
        if (terminal) {
            System.out.println("[ENV] Terminal state already reached. HRI ignored.");
            return;
        }

        clearTransientRADPercepts(agName);
        printHRIDistribution();
        int outcome = hriChoice.get_choice();

        switch (outcome) {
            case 0:
                System.out.println("[ENV] user_assistance sampled outcome 1.");
                System.out.println("[ENV] Effect: +aborted.");
                terminal = true;
                addPercept(agName, new Predicate("aborted"));
                break;

            case 1:
                System.out.println("[ENV] user_assistance sampled outcome 2.");
                removePercept(agName, new Predicate("detected_escalation"));
                resetAutonomousAttempts();

                if (dressingProgress >= MAX_DRESSING_PROGRESS) {
                    System.out.println("[ENV] Effect: -detected_escalation, +completed.");
                    terminal = true;
                    addPercept(agName, new Predicate("completed"));
                } else {
                    System.out.println("[ENV] Effect: -detected_escalation, +dressing_in_progress.");
                    addPercept(agName, new Predicate("dressing_in_progress"));
                }
                break;

            default:
                throw new IllegalStateException("Unexpected HRI outcome: " + outcome);
        }
    }

    private void executeAutonomousRecoveryAttempt(String agName) {
        if (terminal) {
            System.out.println("[ENV] Terminal state already reached. Autonomous recovery ignored.");
            return;
        }

        autonomousAttempts++;

        System.out.println("[ENV] autonomous_recovery_attempt number: "
                + autonomousAttempts + " / " + MAX_AUTONOMOUS_ATTEMPTS);

        removePercept(agName, new Predicate("autonomous_resolution"));

        if (autonomousAttempts > MAX_AUTONOMOUS_ATTEMPTS) {
            System.out.println("[ENV] Maximum autonomous recovery attempts exceeded.");
            System.out.println("[ENV] Forced effect: +aborted.");
            terminal = true;
            addPercept(agName, new Predicate("aborted"));
            return;
        }

        printAutonomousRecoveryDistribution();
        int outcome = autonomousRecoveryChoice.get_choice();

        switch (outcome) {
            case 0:
                System.out.println("[ENV] autonomous_recovery_attempt sampled outcome 1.");
                System.out.println("[ENV] Effect: +aborted.");
                terminal = true;
                addPercept(agName, new Predicate("aborted"));
                break;

            case 1:
                System.out.println("[ENV] autonomous_recovery_attempt sampled outcome 2.");
                System.out.println("[ENV] Effect: +autonomous_resolution i.e. retry");
                addPercept(agName, new Predicate("autonomous_resolution"));
                break;

            case 2:
                System.out.println("[ENV] autonomous_recovery_attempt sampled outcome 3.");
                removePercept(agName, new Predicate("detected_escalation"));
                resetAutonomousAttempts();

                if (dressingProgress >= MAX_DRESSING_PROGRESS) {
                    System.out.println("[ENV] Effect: -detected_escalation, +completed.");
                    terminal = true;
                    addPercept(agName, new Predicate("completed"));
                } else {
                    System.out.println("[ENV] Effect: -detected_escalation, +dressing_in_progress.");
                    addPercept(agName, new Predicate("dressing_in_progress"));
                }
                break;

            default:
                throw new IllegalStateException("Unexpected autonomous recovery outcome: " + outcome);
        }
    }





    private void executeMoveHome(String agName) {
        clearTransientRADPercepts(agName);
        System.out.println("[ENV] move_home is deterministic.");
        System.out.println("[ENV] Effect: +at_home.");
        addPercept(agName, new Predicate("at_home"));
    }

    private void clearTransientRADPercepts(String agName) {
        removePercept(agName, new Predicate("dressing_in_progress"));
        removePercept(agName, new Predicate("undetected_escalation"));
        removePercept(agName, new Predicate("detected_escalation"));
        removePercept(agName, new Predicate("request_hri"));
        removePercept(agName, new Predicate("autonomous_resolution"));
    }

    private void printMonitorDistribution() {
        System.out.println("[ENV] Distribution for observe_dressing:");
        System.out.println("[ENV]   p=" + P_MONITOR_DRESSING_IN_PROGRESS + " -> +dressing_in_progress and progress++");
        System.out.println("[ENV]   p=" + P_MONITOR_UNDETECTED_ESCALATION + " -> +undetected_escalation and progress++");
        System.out.println("[ENV]   p=" + P_MONITOR_DETECTED_ESCALATION + " -> +detected_escalation and progress++");
    }

    private void printMitigationDistribution() {
        System.out.println("[ENV] Distribution for select_mitigation_strategy:");
        System.out.println("[ENV]   p=" + P_SELECT_REQUEST_HRI + " -> +request_hri");
        System.out.println("[ENV]   p=" + P_SELECT_AUTONOMOUS_RESOLUTION + " -> +autonomous_resolution");
        System.out.println("[ENV]   p=" + P_SELECT_ABORT + " -> +aborted");
    }

    private void printHRIDistribution() {
        System.out.println("[ENV] Distribution for user_assistance:");
        System.out.println("[ENV]   p=" + P_HRI_ABORT + " -> +aborted");
        System.out.println("[ENV]   p=" + P_HRI_RESUME_DRESSING + " -> -detected_escalation, +dressing_in_progress");
    }

    private void printAutonomousRecoveryDistribution() {
        System.out.println("[ENV] Distribution for autonomous_recovery_attempt:");
        System.out.println("[ENV]   p=" + P_AUTO_ABORT + " -> +aborted");
        System.out.println("[ENV]   p=" + P_AUTO_RETRY + " -> +autonomous_resolution");
        System.out.println("[ENV]   p=" + P_AUTO_RESUME_DRESSING + " -> -detected_escalation, +dressing_in_progress");
    }

    private void resetAutonomousAttempts() {
        autonomousAttempts = 0;
        System.out.println("[ENV] Autonomous recovery attempt counter reset to 0.");
    }
}
