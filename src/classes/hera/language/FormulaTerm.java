package hera.language;

public class FormulaTerm extends Term {
	Formula f;
	
	public FormulaTerm(Formula f) {
		super(null, null);
		this.f = f;
	}
	
	public Formula getFormula() {
		return f;
	}
}
