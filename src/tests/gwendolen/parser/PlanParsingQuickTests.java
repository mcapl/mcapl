package gwendolen.parser;

import ail.syntax.Plan;
import ajpf.MCAPLcontroller;
import gwendolen.GwendolenPlanBuilder;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

public class PlanParsingQuickTests {

    @Test
    public void ParsePlanFromFile() {
        try {
            List<Plan> plans = new GwendolenPlanBuilder().parsePlanFile("/Users/peterstringer/IdeaProjects/mcapl/src/examples/gwendolen/failuredetection/intentionsuspension/TestPlan1.gwen");
            //System.out.println(plan.getBody().toString());
            Assert.assertNotNull(plans);
        } catch (Exception e) {
            System.err.println(e);
            Assert.assertTrue(false);
        }
    }



}
