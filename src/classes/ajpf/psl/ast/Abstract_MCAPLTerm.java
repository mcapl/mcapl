// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.psl.ast;

import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.MJIEnv;
import ajpf.MCAPLcontroller;
import ajpf.MCAPLmas;
import ajpf.psl.MCAPLFormula;
import ajpf.psl.MCAPLTerm;
import ajpf.psl.MCAPLProperty;

/**
 * Common interface for all kind of Terms
 */
public interface Abstract_MCAPLTerm extends Cloneable {

	public int createInJPF(VM vm);
	
	public MCAPLTerm toMCAPL();
	
	public int newJPFObject(MJIEnv env);
	
	public Abstract_MCAPLTerm clone();
	

	/*public boolean isVar();

    public boolean isLiteral();
    
    public boolean isList();

    public boolean isString();

    public boolean isInternalAction();

    public boolean isArithExpr();

    public boolean isNumeric();

    public boolean isPred();

    public boolean isGround();

    public boolean isStructure();

    public boolean isAtom();

    public boolean hasVar(Term t);

    public Object clone();

    public boolean equals(Object o); */
    
    /** 
     *  Applies variables's values in an unifier to the variables in the term.
     *  Returns true if some variable was applied.  
     */
    /* public boolean apply(Unifier u);
    
    public int hashCode();
    
    public Term strip_varterm(); */
    
   /*  public void renameVar(String oldname, String newname); */
     
}
