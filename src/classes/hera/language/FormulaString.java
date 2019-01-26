// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package hera.language;

/**
 * A formula that contains a string.  Used to represent both constants and variables within Hera.
 * @author louisedennis
 *
 */
public class FormulaString extends Formula {
	String s = "";
	
	/**
	 * Constructor.
	 * @param s
	 */
	public FormulaString(String s) {
		super(null, null);
		this.s = s;
	}
	
	/**
	 * Gett for the string.
	 * @return
	 */
	public String getString() {
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see hera.language.Formula#hashCode()
	 */
	@Override public int hashCode() {
		return s.hashCode();
	}
	
	/*
	 * (non-Javadoc)
	 * @see hera.language.Formula#toString()
	 */
	@Override public String toString() {
		return "'" + s + "'";
	}
	
	/*
	 * (non-Javadoc)
	 * @see hera.language.Formula#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof FormulaString) {
			return s.equals(((FormulaString) o).getString());
		}
		return false;
	}

}
