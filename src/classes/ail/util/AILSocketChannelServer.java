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

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ajpf.util.AJPFLogger;

/**
 * Socket Server class for use with AIL Systems.
 * @author louiseadennis
 *
 */
public class AILSocketChannelServer extends AILSocketChannel {
	ServerSocketChannel service;
	
	/**
	 * Constructor - uses project default socket number.
	 *
	 */
	public AILSocketChannelServer() {
		this(6253);
	}
	
	/**
	 * Constructor that takes a port number as input.
	 * @param portnumber
	 */
	public AILSocketChannelServer(int portnumber) {
		try {
			service = ServerSocketChannel.open();
			service.socket().bind(new InetSocketAddress(portnumber));
			initialise(service.accept());
		} catch  (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
		}	
		
	}
	
	
	public void close() {
		try {
			super.close();
			service.close();
		} catch  (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
		}	
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