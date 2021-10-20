package ail.syntax;

import ail.tracing.events.ModificationEvent;
import gov.nasa.jpf.annotation.FilterField;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Special class for storing entries.  Each instance of a class
 * stores a number of literals with the same PredicateIndicator (i.e., the
 * same predicate name and arity).
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
    byte actionoutcome = 0;

    /**
     * Constructor.
     *
     * @param a
     * @param preb
     * @param postb
     * @param s
     */
    //public ActionLogEntry(DurativeAction a, BeliefBase preb, BeliefBase postb, byte o) {
    public ActionLogEntry(DurativeAction a, BeliefBase preb, BeliefBase postb, byte o) {

        //iterate through prebeliefs against postbeliefs and create a list of the changes.
        Iterator<Literal> prebPercepts = preb.getPercepts();
        Set<Literal> different = new TreeSet<Literal>();
        while (prebPercepts.hasNext()) {
            Literal l = prebPercepts.next();
            if (! (postb.contains(l) != null)) {
                different.add(l);
            }
        }

        newbeliefs = different;
        action = a;
        actionoutcome = o;
    }

    /**
     * Get the action's resultant beliefs.
     *
     * @return
     */
    public Set<Literal> getBeliefs() {
        return newbeliefs;
    }


    public byte getActionOutcome() {
        return actionoutcome;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(action.toString() + getBeliefs().toString() + "\n");
        return s.toString();
    }

}
