package ail.semantics.operationalrules;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Action;
import ail.syntax.ApplicablePlan;
import ail.syntax.Plan;
import ail.syntax.PlanLibrary;
import ajpf.util.AJPFLogger;
import gov.nasa.jpf.annotation.FilterField;
import gwendolen.GwendolenPlanBuilder;
import gwendolen.reconfigurability.Reconfigure;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Generate all applicable plans for an agent.
 *
 * @author lad
 *
 */
public class HandleReconfigurePlan implements OSRule {
    @FilterField
    private static final String name = "Handle Reconfigure Plans";

    // This might be instantiated in some subclasses.
    protected Iterator<ApplicablePlan> iterator;

    protected Reconfigure reconfigure;

    /*
     * (non-Javadoc)
     * @see ail.semantics.operationalrules.OSRule#getName()
     */
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
     */
    public boolean checkPreconditions(AILAgent a) {
        System.out.print("Performing Check Preconditions");
        if (a.lastruleexecuted == "Learn") {
            return true;
        } else {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
     */
    public void apply(AILAgent a) {
        // declare all inputs
        File planfile = null;
        PlanLibrary planLibrary = a.getPL();
        Action lastaction = a.getEnv().lastAction();
        Iterator<Plan> oldplans = planLibrary.getPlansContainingCap(lastaction);
        String actionString = lastaction.toString();

        // instantiate outputs
        Plan newplan = new Plan();

        // call reconfigure method
        reconfigure.reconfig(actionString);

        // wait until plan file is ready
        while (!(planfile.exists())) {
            a.sleep();
            AJPFLogger.info(getName(), "Sleeping agent until a new plan is ready.");
        }
        // get the filepath
        String planfilename = planfile.getPath();
        // parse new plan from file
        List<Plan> newplans = null;
        try {
            newplans = new GwendolenPlanBuilder().parsePlanFile(planfilename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // add new plan
        planLibrary.addAll(newplans);
        // delete old plans
        while (oldplans.hasNext()) {
            planLibrary.remove(oldplans.next());
        }
        // delete new plan file

    }
}