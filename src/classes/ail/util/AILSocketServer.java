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

import java.net.ServerSocket;
import java.io.IOException;

import ajpf.util.AJPFLogger;

/**
 * Socket Server class for use with AIL Systems.
 * @author louiseadennis
 *
 */
public class AILSocketServer extends AILSocket {
	ServerSocket service;
	
	/**
	 * Constructor - uses project default socket number.
	 *
	 */
	public AILSocketServer(){
		super();
		try {
			service = new ServerSocket(6253);
			initialise(service.accept());
		} catch  (IOException e) {
			AJPFLogger.warning(logname, e.getMessage());
		}	
		
	}
	
	/**
	 * Constructor that takes a port number as input.
	 * @param portnumber
	 */
	public AILSocketServer(int portnumber) {
		super();
		try {
			service = new ServerSocket(portnumber);
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

}