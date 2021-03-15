package ail.syntax;

import gov.nasa.jpf.annotation.FilterField;
import org.checkerframework.checker.units.qual.Time;

import java.time.Duration;

public class DurativeAction extends Action {

    public final static int durativeAction = 5;

    public int duration;

    public int threshold;

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

    @FilterField
    byte actionstate = 0;


    /**
     * Create an action from an existing action and a duration.
     *
     * @param a The action.
     * @param d The duration of the action.
     */
    public DurativeAction(Action a, int d, int t) {
        super(a);
        // duration = Duration.ofSeconds(d);
        duration = d;
        threshold = t;
        actiontype = 5;
        actionstate = 0;
    }

    public byte getActionState(){
        return actionstate;
    }

    public int getDuration(DurativeAction a){
        return a.duration;
    }

    public int getThreshold(DurativeAction a){
        return a.threshold;
    }

    public void setState(byte s){
        actionstate = s;
    }



}

