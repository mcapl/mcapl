// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, and  Michael Fisher 
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

package ajpf.util;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
 
/**
 * Stolen shamelessly from www.javalobby.org/java/formums/t18515.html
 * 
 * by R. J. Lorrimer
 * @author lad
 *
 */
public class AsOutputLogFormatter extends Formatter {
	 
	private static final String lineSep = System.getProperty("line.separator");

	/**
	 * A Custom format implementation that is designed for brevity.
	 */
	public String format(LogRecord record) {
		String loggerName = record.getLoggerName();
		if(loggerName == null) {
			loggerName = "root";
		}
		StringBuilder output = new StringBuilder()
		.append(record.getMessage()).append(' ')
		.append(lineSep);
		return output.toString();		
	}
}
