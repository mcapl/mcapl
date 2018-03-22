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
	
	@Override public int hashCode() {
		return t.hashCode();
	}
	
	@Override public String toString() {
		return t.toString();
	}


}
