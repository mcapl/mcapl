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
 * Class for a Hera Boolean formula
 * @author louisedennis
 *
 */
public class BooleanFormula extends Formula {
	boolean b = false;
	
	public BooleanFormula(boolean b) {
		super(null, null);
		this.b = b;
	}
	
	/**
	 * Return the value (T/F) represented by the formula.
	 * @return
	 */
	public boolean getBoolean() {
		return b;
	}
	
	/*
	 * (non-Javadoc)
	 * @see hera.language.Formula#hashCode()
	 */
	@Override public int hashCode() {
		if (b) return 1;
		return 0;
	}
	
	/*
	 * (non-Javadoc)
	 * @see hera.language.Formula#toString()
	 */
	@Override public String toString() {
		if (b) return "True";
		return "False";
	}


}
