package ail.syntax;

import java.util.List;

public interface PredicateTerm extends LogicalFormula {
	public boolean isVar();
	
	public PredicateIndicator getPredicateIndicator();
	
	public String getFunctor();
	
	public int getTermsSize();
	
}
