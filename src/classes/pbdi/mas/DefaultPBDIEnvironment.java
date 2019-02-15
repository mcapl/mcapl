package pbdi.mas;

import java.util.Set;

import ail.mas.DefaultEnvironment;
import ajpf.util.VerifySet;
import pbdi.syntax.PythonCalculation;

public class DefaultPBDIEnvironment extends DefaultEnvironment implements PBDIEnv {
	
	Set<PythonCalculation> calcs = new VerifySet<PythonCalculation>();

	@Override
	public Set<PythonCalculation> getCalculations(String agname, boolean update) {
		// TODO Auto-generated method stub
		return calcs;
	}

}
