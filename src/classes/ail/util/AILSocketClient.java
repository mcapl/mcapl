// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, Michael Fisher, Nicholas K. Lincoln, Alexei
// Lisitsa and Sandor M. Veres
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.util;

import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

import ajpf.util.AJPFLogger;

/**
 * Socket Client implementation for AIL systems.
 * @author louiseadennis
 *
 */
public class AILSocketClient {
	/**
	 * The socket.
	 */
	Socket socket = null;
	/**
	 * A Reader for input.
	 */
	BufferedReader input = null;
	/**
	 * A reader for output.
	 */
	BufferedWriter output = null;
	/**
	 * An attempt at OS independance!!
	 */
	String linefeed = System.getProperty("line.separator");
	/**
	 * logname
	 */
	String logname = "ail.util.AILSocketClient";
	
	/**
	 * Constructor.  Sets a default Socket number for use by the project.
	 *
	 */
	public AILSocketClient() {
		try {
			socket = new Socket("localhost", 6253);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
		}
	}
	
	/**
	 * Constructor that takes a port number as input.
	 * @param portnumber
	 */
	public AILSocketClient(int portnumber) {
		try {
			socket = new Socket("localhost", portnumber);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
		}
	}

	/**
	 * Checks the socket is correctly initialised.
	 * @return
	 */
	public boolean allok() {
		return (socket !=null && input != null && output !=null);
	}
	
	/**
	 * Write to the socket.
	 * @param s
	 */
	public void write(String s) {
		if (!socket.isClosed() && socket.isConnected()) {
			try {
				output.write(s);
				output.write(linefeed);
				output.flush();
			} catch (Exception e) {
				AJPFLogger.warning(logname, e.getMessage());
			}
		} else {
			write ("error");
		}
	}
	
	/**
	 * Check the socket is ready for reading.
	 * @return
	 */
	public boolean ready() {
		boolean result;
		try {
			if (input != null) {
				result = input.ready();
			} else {
				return false;
			}
		} catch (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
			result = false;
		}
		return result;
	}
	
	
	/**
	 * Read a line from the socket.
	 * @return
	 */
	public String readLine() {
		try{
			return input.readLine();
		} catch (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
			return "failed read";
		}
	}
	
	/**
	 * Close the socket.
	 *
	 */
	public void close() {
		try {
			if (output != null) {
			output.close();
			}
			if (input != null) {
			input.close();
			}
			if (socket != null) {
			socket.close();
			}
		} catch (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
		}
	}
	
	/**
	 * Is this socket closed?
	 * @return
	 */
	public boolean isClosed() {
		if (socket != null) {
			return socket.isClosed();
		} else {
			return false;
		}
	}

}