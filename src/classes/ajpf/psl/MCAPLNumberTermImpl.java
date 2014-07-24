// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ajpf.psl;

/** Immutable class that implements a term that represents a number */
public final class MCAPLNumberTermImpl extends MCAPLTermImpl implements MCAPLNumberTerm {

	private final double fValue;
	
	public MCAPLNumberTermImpl() {
		super();
		fValue = 0;
	}
	
	public MCAPLNumberTermImpl(String sn) {
		double t = 0;
		try {
			t = Double.parseDouble(sn);
		} catch (Exception e) {
			// logger.log(Level.SEVERE,"Error setting number term value from "+sn,e);
		}
		fValue = t;
	}
	
	public MCAPLNumberTermImpl(double vl) {
		fValue = vl;
	}
	
	public MCAPLNumberTermImpl(MCAPLNumberTermImpl t) {
		fValue = t.solve();
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLNumberTerm#solve()
	 */
	public double solve() {
		return fValue;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
    public boolean equals(Object o) {
        if (o == this) return true;

        if (o != null && o instanceof MCAPLNumberTerm) {
            MCAPLNumberTerm st = (MCAPLNumberTerm)o;
                 return solve() == st.solve();
		} 
		return false;
	}

    /*
     * 
     */
    public int compareTo(MCAPLNumberTerm st) {
    	if (solve() > st.solve()) return 1;
    	if (solve() < st.solve()) return -1;
    	return 0;
    }
    
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTermImpl#toString()
     */
	public String toString() {
			return String.valueOf(fValue);
	}
    
 
}
