// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package eass.mas.nxt;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

import lejos.nxt.remote.RemoteMotor;
import lejos.nxt.remote.NXTCommand;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Abstraction of a LEGO NXT Brick running LeJOS
 * 
 * @author louiseadennis
 *
 */
public class NXTBrick  { 
	private String btname, btaddress;
	private NXTComm comm;
	private NXTInfo nxt;
	private DataInputStream in;
	private DataOutputStream out;
	private NXTCommand nxtcommand;
	
	private boolean connected = false;
	
	public RemoteMotor motorA;
	public RemoteMotor motorB;
	public RemoteMotor motorC;

	public EASSSensorPort Port1;
	public EASSSensorPort Port2;
	public EASSSensorPort Port3;
	public EASSSensorPort Port4;

	public static int APort = 0;
	public static int BPort = 1;
	public static int CPort = 2;
	
	public static int SPort1 = 0;
	public static int SPort2 = 1;
	public static int SPort3 = 2;
	public static int SPort4 = 3;

	/**
	 * Construct an abstraction of an NXT Brick
	 * 
	 */
	public NXTBrick(String name, String address) {
		// first we create an AIL Agent.
		btname = name;
		btaddress = address;
		try {
			System.out.println("Connecting to " + btname + "(" + btaddress + ")");
			openBluetooth();
			connected = true;
			System.out.println("Connected to " + btname + "(" + btaddress + ")");
			
		} catch (NXTCommException e) {
			System.out.println("Could not open Bluetooth connection to " + btname + "(" + btaddress + ")");
			connected = false;
		} 
		
		if (connected) {
			nxtcommand = new NXTCommand(comm);
			nxtcommand.setVerify(true);
		
			motorA = new RemoteMotor(nxtcommand, APort);
			motorB = new RemoteMotor(nxtcommand, BPort);
			motorC = new RemoteMotor(nxtcommand, CPort);
		
			Port1 = new EASSSensorPort(nxtcommand, SPort1);	
			Port2 = new EASSSensorPort(nxtcommand, SPort2);
			Port3 = new EASSSensorPort(nxtcommand, SPort3);	
			Port4 = new EASSSensorPort(nxtcommand, SPort4);
		}
		
	}
	
	/**
	 * Is this brick connected to a physical NXT Brick?
	 * @return
	 */
	public boolean isConnected() {
		return connected;
	}
	
	/**
	 * Get the motor associated with Port A.
	 * @return
	 */
	public RemoteMotor getMotorA() {
		return motorA;
	}
	
	/**
	 * Get the motor associated with Port B.
	 * @return
	 */
	public RemoteMotor getMotorB() {
		return motorB;
	}
	
	/**
	 * Get the motor associated with Port C.
	 * @return
	 */
	public RemoteMotor getMotorC() {
		return motorC;
	}

	/**
	 * Get sensor port 1.
	 * @return
	 */
	public EASSSensorPort getSensorPort1() {
		return Port1;
	}
	
	/**
	 * Get sensor port 2.
	 * @return
	 */
	public EASSSensorPort getSensorPort2() {
		return Port2;
	}
	
	/**
	 * Get sensor port 3.
	 * @return
	 */
	public EASSSensorPort getSensorPort3() {
		return Port3;
	}
	
	/**
	 * Get sensor port 4.
	 * @return
	 */
	public EASSSensorPort getSensorPort4() {
		return Port4;
	}
	
	/**
	 * Get sensor port i.
	 * @param i
	 * @return
	 */
	public EASSSensorPort getSensorPort(int i) {
		if (i == 1) {
			return Port1;
		}
		if (i == 2) {
			return Port2;
		}
		if (i == 3) {
			return Port3;
		}
		if (i == 4) {
			return Port4;
		}
		else return Port1;
	}

	
	
    /**
     * Stolen from LEGO-Jason-NXT by Andreas Schmidt Jensen
     * Opens BT communication to the NXT with Address and Name defined in the
     * UserParameters. Also sets up data streams for input and output.
     * 
     * @throws NXTCommException
     */
    private void openBluetooth() throws NXTCommException {
            comm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
            nxt = new NXTInfo(NXTCommFactory.BLUETOOTH, btname, btaddress);
            comm.open(nxt, NXTComm.PACKET);
            out = new DataOutputStream(comm.getOutputStream());
            in = new DataInputStream(comm.getInputStream());
    }

    /**
     * Close Bluetooth connection to actual brick.
     */
	public void close() {
		try {
			out.close();
			in.close();
			comm.close();
		} catch (Exception e) {
			System.out.println("Error closing comms");
		}
	}
	
	/**
	 * Get NXT command object used for sending messages to physical brick.
	 * @return
	 */
	public NXTCommand getNXTCommand() {
		return nxtcommand;
	}


}
