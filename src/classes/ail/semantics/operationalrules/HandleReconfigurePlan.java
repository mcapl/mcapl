package ail.semantics.operationalrules;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.*;
import ajpf.util.AJPFLogger;
import gov.nasa.jpf.annotation.FilterField;
import gwendolen.GwendolenPlanBuilder;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import gwendolen.reconfigurability.Reconfigure;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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
        //System.out.print("Checking Preconditions for Reconfig" + "\n");
        if (!a.getLA().isEmpty()){
            //System.out.println(a.getLA().toString());
            return true;
        } else {
            //System.out.println(a.getLA().toString());
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
     */
    public void apply(AILAgent a) {
        Reconfigure reconfigure = new Reconfigure(a);
        //System.out.print("Performing Reconfig" + "\n");
        // declare all inputs
        File planfile = null;
        PlanLibrary planLibrary = a.getPL();
        DurativeAction dact = a.getLA().get(0);
        Iterator<Plan> oldplans = planLibrary.getPlansContainingCap(dact);
        String actionString = dact.toString();
        //System.out.println(actionString);

        // instantiate outputs
        //Plan newplan = new Plan();

        // call reconfigure method
        reconfigure.setInitialState(new Guard(dact.getPre()));
        reconfigure.setGoalState(new Guard(dact.getPost()));
        ArrayList<String> plans = reconfigure.reconfig(actionString);

        if (plans.isEmpty()) {
            System.out.println("ABORT!");
            System.exit(1);
        }


        ArrayList<Action> newactions = new ArrayList<Action>();
        try {
        for (String plan: plans) {
            //GwendolenLexer plan_lexer = new GwendolenLexer(new ANTLRFileStream(masstring));
            GwendolenLexer plan_lexer = new GwendolenLexer(new ANTLRStringStream(plan));
            //System.out.print("Plan Lexer done");
            CommonTokenStream plan_tokens = new CommonTokenStream(plan_lexer);
            //System.out.print("Plan tokens done");
            GwendolenParser plan_parser = new GwendolenParser(plan_tokens);
            //System.out.print("Plan parser done");
            Action action = (plan_parser.action()).toMCAPL();
            //System.out.print("plan parsed");
            newactions.add(action);
            //System.out.print("plan added to plan list");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.reverse(newactions);

        for (Plan p: a.getPL().getPlans()){
            //System.out.println(p);
            ArrayList<Deed> body = p.getBody();
            ArrayList<Deed> newbody = new ArrayList<Deed>();
            int n = 0;
            for (Deed d: body){
                //System.out.println(d);

                boolean replaced = false;
                if(d.isAction()){
                    Action act = (Action) d.getContent();
                    //System.out.println("a");
                    //if(act instanceof DurativeAction){
                        //System.out.println("b");

                        //DurativeAction da = (DurativeAction) act;
                        if (act.equals(a.getLA().get(0).getAction())) {
                            //System.out.println("c");

                            for (Action action: newactions) {
                                newbody.add(new Deed(action));
                                replaced = true;

                        }
                    }
                }
                if (! replaced) {
                    newbody.add(d);
                }
            }
            p.setBody(newbody);
            //System.out.println(p);
        }
        System.out.print(a.getPL().getPlans());
        // wait until plan file is ready
        /*while (planfile == null) {
                if (planfile == null) {
                    try {
                        planfile = new File("./src/classes/gwendolen/reconfigurability/problem.pddl_output");
                        AJPFLogger.info(getName(), "Sleeping agent until a new plan is ready.");
                        a.sleep();
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
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

         */

        // remove action from learned action list
        a.setLA(new ArrayList<DurativeAction>());
    }
}