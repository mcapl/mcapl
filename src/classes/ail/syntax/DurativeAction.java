package ail.syntax;

import gov.nasa.jpf.annotation.FilterField;
import org.checkerframework.checker.units.qual.Time;

import ail.semantics.AILAgent;

import java.time.Duration;
import java.util.Iterator;


/* We are going to abuse the Capability Class
 * Pre-conditions in Capability will be success criterion here
 * Post-conditions in Capability will be fail criterion here
 */
public class DurativeAction extends Capability {

    public final static int durativeAction = 5;

    public int duration;

    public int threshold;
    
    @FilterField
    public final static byte actionNotExecuting = 0;
    @FilterField
    public final static byte actionExecuting = 1;

    @FilterField
    byte actionstate = 0; 


    /**
     * Create an action from an existing action and a duration.
     *
     * @param a The action.
     * @param d The duration of the action.
     */
    public DurativeAction(Action a, int d, int t, GLogicalFormula pre, GLogicalFormula post) {
        super(pre, a, post);
        // duration = Duration.ofSeconds(d);
        duration = d;
        threshold = t;
        // actiontype = 5;
        actionstate = 0;
    }
    
    public DurativeAction(Capability c, int d, int t) {
        super(c.getPre(), (Action) c, c.getPost());
        // duration = Duration.ofSeconds(d);
        duration = d;
        threshold = t;
        // actiontype = 5;
        actionstate = 0;
    }

    
    @Override
    public DurativeAction clone() {
    	Capability c = super.clone();
    	DurativeAction a = new DurativeAction(c, duration, threshold);
    	a.actionstate = this.getActionState();
    	return a;
    	
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

    public Predicate getActionPredicate(){ return super.getAction().toPredicate(); }
    
    public GLogicalFormula getSuccess() {
    	return getPre();
    }
    
    public GLogicalFormula getFail() {
    	return getPost();
    }

    public void setState(byte s){
        actionstate = s;
    }

    public boolean isExecuting() {
    	return actionstate == actionExecuting;
    }
    
    public void notExecuting() {
    	actionstate = actionNotExecuting;
    }

    public void executing() {
    	actionstate = actionExecuting;
    }

    public boolean abort(AILAgent a) {
    	Literal timepassed = new Literal("timepassed");
    	timepassed.addTerm(new VarTerm("T"));
    	Iterator<Unifier> ui = a.believes(new Guard(new GBelief(timepassed)), new Unifier());
    	if (ui.hasNext()) {
    		timepassed.apply(ui.next());
    		NumberTerm seconds = (NumberTerm) timepassed.getTerm(0);
    		if (seconds.solve() > duration) {
    			return true;
    		}
    	} 
    	
    	return false;
    	
    }

}

