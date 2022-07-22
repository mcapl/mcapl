package gwendolen.failuredetection;

import ail.semantics.AILAgent;
import ail.syntax.*;
import gwendolen.GwendolenPlanBuilder;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlanReplacementQuickTests {

    @Test
    public void AddPlanToLibrary() {
        AILAgent ag = new AILAgent();
        try {
            List<Plan> plans = new GwendolenPlanBuilder().parsePlanFile("/Users/peterstringer/IdeaProjects/mcapl/src/examples/gwendolen/failuredetection/intentionsuspension/TestPlan1.gwen");
            ag.getPL().addAll(plans);
            Assert.assertTrue(ag.getPL().getPlans() != null);
        } catch (Exception e) {
            System.err.println(e);
            Assert.assertFalse(true);
        }
    }

    @Test
    public void DeletePlanFromLibrary() {
        AILAgent ag = new AILAgent();
        try {
            // Create 2 different plans (that represent BEFORE and AFTER failure)
            //String filenamebefore = MCAPLcontroller.getFilename("/examples/gwendolen/failuredetection/intentionsuspension/TestPlan1.gwen");
            //String filenameafter = MCAPLcontroller.getFilename("/examples/gwendolen/failuredetection/intentionsuspension/TestPlan2.gwen");
            List<Plan> planbefore = new GwendolenPlanBuilder().parsePlanFile("/Users/peterstringer/IdeaProjects/mcapl/src/examples/gwendolen/failuredetection/intentionsuspension/TestPlan1.gwen");
            List<Plan> planafter = new GwendolenPlanBuilder().parsePlanFile("/Users/peterstringer/IdeaProjects/mcapl/src/examples/gwendolen/failuredetection/intentionsuspension/TestPlan2.gwen");

            // Create Capability for 'failed' action
            //predicate
            Predicate moveto1 = new Predicate("move_to");
            moveto1.addTerm(new NumberTermImpl(1));
            //beliefs
            Literal at0 = new Literal("at");
            at0.addTerm(new NumberTermImpl(0));
            Literal at1 = new Literal("at");
            at1.addTerm(new NumberTermImpl(1));
            //capability
            Capability failedCap = new Capability(new GBelief(at0), moveto1, new GBelief(at1));


            // Simulate plan library before failure
            ag.getPL().addAll(planbefore);

            // Remove the plans containing failing action
            for (Iterator<Plan> it = ag.getPL().getPlansContainingCap(failedCap); it.hasNext(); ) {
                Plan p = it.next();
                ag.getPL().remove(p);
            }

            // "Learn" new action and "Reconfigure" new plan then add it to PL
            ag.getPL().addAll(planafter);

            // Check that there is a new plan in the Plan Library for the failed action.
            Assert.assertTrue((ag.getPL().getPlansContainingCap(failedCap)) != null);
            // Test that there is the correct number of plans left in the Plan Library
            Assert.assertTrue(ag.getPL().size() == 6);
        } catch (Exception e) {
            System.err.println(e);
            Assert.assertFalse(true);
        }
    }
    @Test
    public void DeletePlanforCapwithTerms() {
        AILAgent ag = new AILAgent();
        try {
            // Create 2 different plans (that represent BEFORE and AFTER failure)
            List<Plan> planbefore = new GwendolenPlanBuilder().parsePlanFile("/Users/peterstringer/IdeaProjects/mcapl/src/examples/gwendolen/failuredetection/intentionsuspension/TestPlan1.gwen");

            // Create Capability for 'failed' action
            //predicate
            Predicate moveto1 = new Predicate("move_to");
            moveto1.addTerm(new NumberTermImpl(1));
            //beliefs
            Literal at0 = new Literal("at");
            at0.addTerm(new NumberTermImpl(0));
            Literal at1 = new Literal("at");
            at1.addTerm(new NumberTermImpl(1));
            //capability
            Capability failedCap = new Capability(new GBelief(at0), moveto1, new GBelief(at1));

            // Create Capability for 'other' action
            //predicate
            Predicate moveto2 = new Predicate("move_to");
            moveto2.addTerm(new NumberTermImpl(2));
            //beliefs
            Literal at2 = new Literal("at");
            at2.addTerm(new NumberTermImpl(2));
            //capability
            Capability otherCap = new Capability(new GBelief(at1), moveto2, new GBelief(at2));

            // Simulate plan library before failure
            ag.getPL().addAll(planbefore);

            Iterator<Plan> failedPlansIterator = ag.getPL().getPlansContainingCap(failedCap);
            Iterator<Plan> otherPlansIterator = ag.getPL().getPlansContainingCap(otherCap);
            ArrayList failedPlans = new ArrayList<>();
            ArrayList otherPlans = new ArrayList<>();

            while (failedPlansIterator.hasNext()){
            failedPlans.add(failedPlansIterator.next());
            }
            while (otherPlansIterator.hasNext()){
                otherPlans.add(otherPlansIterator.next());
            }
            // Check that the getPlansContainingCap method returns different results for caps with different terms
            Assert.assertTrue(!(failedPlansIterator.equals(otherPlansIterator)));
            Assert.assertNotSame(failedPlans, otherPlans);

        } catch (Exception e) {
            System.err.println(e);
            Assert.assertFalse(true);
        }
    }

}
