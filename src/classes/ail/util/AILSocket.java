// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, Michael Fisher, Nicholas K. Lincoln, Alexei
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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import ajpf.util.AJPFLogger;

public class AILSocket {
	/**
	 * The socket.
	 */
	Socket socket = null;
	/**
	 * A Reader for input.
	 */
	DataInputStream input = null;
	/**
	 * A reader for output.
	 */
	DataOutputStream output = null;
	/**
	 * An attempt at OS independance!!
	 */
	String linefeed = System.getProperty("line.separator");
	/**
	 * logname
	 */
	String logname = "ail.util.AILSocket";
	
	boolean socketclosed = false;
	
	/**
	 * Constructor. 
	 *
	 */
	public AILSocket() {}
	
	/**
	 * Separated out from the constructor to allow error handling in the constructors of subclasses.
	 * @param sock
	 */
	public void initialise(Socket sock) {
		try {
			socket = sock;
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		} catch (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
		}		
	}
	
	/**
	 * Checks the socket is correctly initialised.
	 * @return
	 */
	public boolean allok() {
		return (!socketclosed && socket !=null && input != null && output !=null);
	}
	
	/**
	 * Write a string to the socket.
	 * @param s
	 */
	public void write(String s) {
		if (!socket.isClosed() && socket.isConnected()) {
			try {
				output.write(s.getBytes());
				output.write(linefeed.getBytes());
				output.flush();
			} catch (Exception e) {
				AJPFLogger.warning(logname, e.getMessage() + " closing socket");
				close();
			}
		} else {
			System.err.println ("error");
		}
	}
		
	/**
	 * Write an integer to the socket.
	 * @param i
	 */
	public void writeInt(int i) {
		if (!socket.isClosed() && socket.isConnected()) {
			try {
				output.writeInt(i);
				output.flush();
			} catch (Exception e) {
				AJPFLogger.warning(logname, e.getMessage() + " closing socket");
				close();
			}
		} else {
			System.err.println ("error");
		}
	}

	/**
	 * Write a double to the socket.
	 * @param d
	 */
	public void writeDouble(double d) {
		if (!socket.isClosed() && socket.isConnected()) {
			try {
				output.writeDouble(d);
				output.flush();
			} catch (Exception e) {
				AJPFLogger.warning(logname, e.getMessage() + " closing socket");
				close();
			}
		} else {
			System.err.println ("error");
		}
	}

	/**
	 * Read a line from the socket.
	 * @return
	 */
	public String readLine() {
		try{
			return input.readUTF();
		} catch (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
			return "failed read";
		}
	}
	
	/**
	 * Read an int from the socket.
	 * @return
	 */
	public int readInt() {
		try{
			return input.readInt();
		} catch (IOException e) {
			AJPFLogger.warning(logname, "readInt:" + e.getMessage());
			return 0;
		}
	}

	/**
	 * Read a double from the socket.
	 * @return
	 */
	public double readDouble() {
		try{
			return input.readDouble();
		} catch (IOException e) {
			AJPFLogger.warning(logname, "readDouble:" + e.getMessage());
			return 0;
		}
	}

	/**
	 * Are there any bytes left on the socket.
	 * @return
	 * @throws IOException
	 */
	public boolean pendingInput() throws IOException {
		return (input.available() > 0);
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
			socketclosed = true;
		} catch (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
			socketclosed = true;
		}
	}
	
	/**
	 * Is this socket closed?
	 * @return
	 */
	public boolean isClosed() {
		if (socketclosed) {
			return true;
		}
		if (socket != null) {
			return socket.isClosed();
		} else {
			return false;
		}
	}
}
