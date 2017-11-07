package pbdi.mas;

import java.util.Set;

import ail.mas.AILEnv;
import pbdi.syntax.PythonCalculation;

public interface PBDIEnv extends AILEnv {
	Set<PythonCalculation> getCalculations(String agName, boolean update);

}
