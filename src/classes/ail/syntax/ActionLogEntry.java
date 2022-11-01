package ail.syntax;

import gov.nasa.jpf.annotation.FilterField;

import java.util.*;

/**
 * Special class for action log entries to be used in an action log.
 *
 * @author pws
 */
public final class ActionLogEntry extends Object {

    @FilterField
    public final static byte actionPending = 0;
    @FilterField
    public final static byte actionSucceeded = 1;
    @FilterField
    public final static byte actionFailed = 2;
    @FilterField
    public final static byte actionSucceededwithFailure = 3;
    @FilterField
    public final static byte actionTimedout = 4;
    @FilterField
    public final static byte actionActive = 5;
    @FilterField
    public final static byte actionAbort = 6;

    Action action;
    //BeliefBase prebeliefs;
    //BeliefBase postbeliefs;
    Set<Literal> newbeliefs;
    byte actionoutcome;

    /**
     * Constructor.
     *  @param a Durative Action
     * @param preb Beliefs held before action execution
     * @param postb Beliefs held after action execution
     * @param o The action's outcome, as set in HandleActionwProblem
     */
    //public ActionLogEntry(DurativeAction a, BeliefBase preb, BeliefBase postb, byte o) {
    public ActionLogEntry(Capability a, ArrayList preb, ArrayList postb, byte o) {
        newbeliefs = getComplement(preb, postb);
        action = a;
        actionoutcome = o;
    }

    public ActionLogEntry(DurativeAction a, Set<Literal> c, byte o){
        newbeliefs = c;
        action = a;
        actionoutcome = o;
    }

    /**
     * Get the action's resultant beliefs.
     *
     * @return the new beliefs held as a result of an action.
     */
    public Set<Literal> getBeliefs() {
        return newbeliefs;
    }

    public Set<Literal> getComplement(ArrayList preb, ArrayList postb) {
        Set<Literal> complement = new TreeSet<>();
        ArrayList<Literal> prebeliefs = preb;
        ArrayList<Literal> postbeliefs = postb;
        //System.out.print(prebeliefs);
        //System.out.print(postbeliefs);
        for (Literal l : postbeliefs) {
            //System.out.print("Scanning Literals in postbeliefs");
            if (!prebeliefs.contains(l)) {
                //System.out.print("Literal is not in prebelief");
                complement.add(l);
            }
        }
        return complement;

    }

    public Action getAction(){
        return action;
    }


    public byte getActionOutcome() {
        return actionoutcome;
    }

    public String getActionOutcomeToString(){
        if (actionoutcome == actionSucceeded){ return "Succeeded"; }
        if (actionoutcome == actionSucceededwithFailure){ return "Succeeded with Partial Failure"; }
        if (actionoutcome == actionFailed){ return "Failed"; }
        if (actionoutcome == actionAbort){ return "Aborted"; }
        if (actionoutcome == actionPending){ return "Pending"; }
        if (actionoutcome == actionTimedout){ return "Timed Out"; }
        if (actionoutcome == actionActive){ return "Active"; }
        return "Pending";
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        String beliefs = "";
        //21-10-21 find a way to translate byte back to text!
        for (Literal l: getBeliefs()){
            beliefs = beliefs + "," + l.toString();
        }
        s.append(action.toString() + " | " + beliefs + " | " + getActionOutcomeToString() + "\n");
        return s.toString();
    }

}
