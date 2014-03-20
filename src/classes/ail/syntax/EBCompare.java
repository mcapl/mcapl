package ail.syntax;

public interface EBCompare<K extends Unifiable> extends Cloneable, Unifiable {

	/**
	 * Is this a variable?
	 * @return
	 */
	public boolean isVar();
	
	/**
	 * Predicate indicators are often used to index parts of the agent state, e.g. the belief base
	 * in order to speed up access and checking.  Guard Atoms should have a predicate indicator.
	 * @return
	 */
	public PredicateIndicator getPredicateIndicator();
	
    /*
     * (non-Javadoc)
     * @see ail.syntax.GLogicalFormula#clone()
     */
    public EBCompare<K> clone();

}
