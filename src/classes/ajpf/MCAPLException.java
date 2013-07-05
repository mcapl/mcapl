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
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ajpf;

/**
 * MCAPL Exception class.  Currently this is essentially the same as Jason's
 * JasonException class by Rafael H. Bordini and Jomi F. Hubner et. al.
 * @author louiseadennis
 *
 */
public class MCAPLException extends java.lang.Exception {
    
	private static final long serialVersionUID = 1L;

	/**
     * Creates a new instance of <code>AILException</code> without detail message.
     */
    public MCAPLException() {
    }
    
    
    /**
     * Constructs an instance of <code>AILException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public MCAPLException(String msg) {
        super(msg);
    }

    /**
     * Constructs and instance of <code>AILException</code> with the specified 
     * message and cause.
     * 
     * @param msg the message.
     * @param cause the cause.
     */
    public MCAPLException(String msg, Exception cause) {
        super(msg);
        initCause(cause);
    }
    
}
