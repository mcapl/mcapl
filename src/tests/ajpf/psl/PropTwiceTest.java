package ajpf.psl;

import java.util.Set;

import org.junit.Test;

import ajpf.product.Product;
import ajpf.psl.ast.Native_Proposition;
import ajpf.psl.ast.Property_AST;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.Types;
import junit.framework.Assert;

public class PropTwiceTest {
	
	@Test public void safeTest() {
		String propertystring = "( [] ( D(car0, perf(brake)) -> <> B(car0, safe) ) ) ->  (  B(car0, safe) -> [] (<> ( B(car0, safe))))";
		Property_AST prop_ast = new Property_AST();
		prop_ast.parse(propertystring);
		MCAPLProperty prop = prop_ast.toMCAPLNative();
		Set<Proposition> props = prop.getProps();
		
		// Mirror the set of atomic propositions mentioned in the property up in the JVM version of
		// the specification.
			int index = 0;

	    for (Proposition p: props) {
			if (p instanceof Native_Proposition) {
				Native_Proposition p1 = (Native_Proposition) p;
				index++;
			}
		}
	    
	    MCAPLProperty negprop = prop.negate();
	    Product product_automata = new Product(negprop, props, Product.AutomataType.DEFAULT_AUTOMATA, false);
	    
	    Assert.assertTrue(product_automata.getBuchi().getStates().size() == 8);
	}
}
