package ail.syntax;

import ail.tracing.events.ModificationEvent;
import gov.nasa.jpf.annotation.FilterField;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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

    DurativeAction action;
    //BeliefBase prebeliefs;
    //BeliefBase postbeliefs;
    Set<Literal> newbeliefs;
    byte actionoutcome;

    /**
     * Constructor.
     *
     * @param a Durative Action
     * @param preb Beliefs held before action execution
     * @param postb Beliefs held after action execution
     * @param o The action's outcome, as set in HandleActionwProblem
     */
    //public ActionLogEntry(DurativeAction a, BeliefBase preb, BeliefBase postb, byte o) {
    public ActionLogEntry(DurativeAction a, BeliefBase preb, BeliefBase postb, byte o) {
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

    public Set<Literal> getComplement(BeliefBase preb, BeliefBase postb) {
        //iterate through prebeliefs against postbeliefs and create a list of the changes.
        Iterator<Literal> prebPercepts = preb.getPercepts();
        Set<Literal> complement = new TreeSet<>();
        while (prebPercepts.hasNext()) {
            Literal l = prebPercepts.next();
            if (postb.contains(l) == null) {
                complement.add(l);
            }
        }
        return complement;
    }

    public byte getActionOutcome() {
        return actionoutcome;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        //21-10-21 find a way to translate byte back to text!
        s.append(action.toString() + getBeliefs().toString() + getActionOutcome() + "\n");
        return s.toString();
    }

}
