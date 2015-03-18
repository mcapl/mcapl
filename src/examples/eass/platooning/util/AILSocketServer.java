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

package eass.platooning.util;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ajpf.util.AJPFLogger;

/**
 * Socket Server class for use with AIL Systems.
 * @author louiseadennis
 *
 */
public class AILSocketServer {
	ServerSocketChannel service;
	/**
	 * The socket.
	 */
	SocketChannel socket = null;
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
	String logname = "ail.util.AILSocketServer";
	
	/**
	 * Constructur - uses project default socket number.
	 *
	 */
	public AILSocketServer() {
		this(6253);
	}
	
	/**
	 * Constructor that takes a port number as input.
	 * @param portnumber
	 */
	public AILSocketServer(int portnumber) {
		try {
			service = ServerSocketChannel.open();
			service.socket().bind(new InetSocketAddress(portnumber));
			socket = service.accept();
			input = new BufferedReader(new InputStreamReader(socket.socket().getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.socket().getOutputStream()));
		} catch (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
		}
	}

	/**
	 * Checks socket is OK.
	 * @return
	 */
	public boolean allok() {
		return (socket !=null && input != null && output !=null);
	}

	/**
	 * Write to the socekt.
	 * @param s
	 */
	public void write(String s) {
		try {
			output.write(s);
			output.write(linefeed);
			output.flush();
		} catch (IOException e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
	}
	
	public void write(ByteBuffer buf) {
		try {
			buf.rewind();
			while (buf.hasRemaining()) {
				socket.write(buf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Read from the socket.
	 * @return
	 */
	public String readLine() {
		try{
			return input.readLine();
		} catch (IOException e) {
			AJPFLogger.severe(logname, e.getMessage());
			return "failed read";
		}
	}
	
	public int read(ByteBuffer buf) {
		try {
			int len = socket.read(buf);
			buf.flip();
			return len;
		} catch (IOException e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
		return -1;
	}
	
	/**
	 * Check socket is ready.
	 * @return
	 */
	public boolean ready() {
		boolean result;
		try {
			if (input != null)
				result = input.ready();
			else
				result = false;
		} catch (IOException e) {
			System.err.println(e);
			result = false;
		}
		return result;
	}

	/**
	 * Close the socket.
	 *
	 */
	public void close() {
		try {
			if (output != null)
				output.close();
		} catch (IOException e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
		try {
			if (input != null)
				input.close();
		} catch (IOException e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
		try {
			if (socket != null)
				socket.close();
		} catch (IOException e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
		try {
			if (service != null)
				service.close();
		} catch (IOException e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
	}
	
	/**
	 * Finalise the socket.
	 */
	public void finalize() {
		AJPFLogger.info(logname, "finalizing");
		close();
	}
	
	/** 
	 * THis socket is closed.
	 * @return
	 */
	public boolean isClosed() {
		if (socket != null && service != null) {
			return (socket.socket().isClosed() || service.socket().isClosed());
		} else {
			return false;
		}
	}
}