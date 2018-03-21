package hera.language;

public class TermFormula extends Formula {
	Term t;
	
	public TermFormula(Term t) {
		super(null, null);
		this.t = t;
	}
	
	public Term getTerm() {
		return t;
	}

}
