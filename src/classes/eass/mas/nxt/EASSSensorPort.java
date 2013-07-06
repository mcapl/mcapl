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
//----------------------------------------------------------------------------

package eass.mas.nxt;

import lejos.nxt.remote.NXTCommand;
import lejos.nxt.remote.NXTProtocol;
import lejos.nxt.LegacySensorPort;
import lejos.nxt.I2CPort;
import lejos.nxt.remote.InputValues;

import java.io.IOException;

/**
 * Port class. Contains 4 Port instances.<br>
 * Usage: Port.S4.readValue();
 * 
 * This version of the SensorPort class supports remote execution.
 * 
 * @author <a href="mailto:bbagnall@mts.net">Brian Bagnall</a>
 *
 */
public class EASSSensorPort implements NXTProtocol, LegacySensorPort, I2CPort  {	
	private NXTCommand nxtCommand;
	
	private int id;
	
	
	public EASSSensorPort(NXTCommand nxtcomm, int port) {
		id = port;
		nxtCommand = nxtcomm;
	}
	
	public int getId() {
		return id;
	}
	
	public void setTypeAndMode(int type, int mode) {
		try {
			nxtCommand.setInputMode(id, type, mode);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	public void setType(int type) {
		int mode = getMode();
		try {
			nxtCommand.setInputMode(id, type, mode);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	public void setMode(int mode) {
		int type = getType();
		try {
			nxtCommand.setInputMode(id, type, mode);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	public int getType() {
		InputValues vals;
		try {
			vals = nxtCommand.getInputValues(id);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return 0;
		}
		return vals.sensorType;
	}
	
	public int getMode() {
		InputValues vals;
		try {
			vals = nxtCommand.getInputValues(id);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return 0;
		}
		return vals.sensorMode;
	}
	
	/**
	 * Reads the boolean value of the sensor.
	 * @return Boolean value of sensor.
	 */
	public boolean readBooleanValue() {
		InputValues vals;
		try {
			vals = nxtCommand.getInputValues(id);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return false;
		}
		return (vals.rawADValue < 600);
	}
	
    /**
     * Reads the raw value of the sensor.
     * @return Raw sensor value. Range is device dependent.
     */
	public int readRawValue() {
		InputValues vals;
		try {
			vals = nxtCommand.getInputValues(id);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return 1023;
		}
		return vals.rawADValue;
	}
    
	/**
	 * Reads the normalized value of the sensor.
	 * @return Normalized value. 0 to 1023
	 */
	public int readNormalizedValue() {
		InputValues vals;
		try {
			vals = nxtCommand.getInputValues(id);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return 0;
		}
		return vals.normalizedADValue;
	}
	
	/**
	 * Returns scaled value, depending on mode of sensor. 
	 * e.g. BOOLEANMODE returns 0 or 1.
	 * e.g. PCTFULLSCALE returns 0 to 100.
	 * @return the value
	 * @see SensorPort#setTypeAndMode(int, int)
	 */
	public int readValue() {
		InputValues vals;
		try {
			vals = nxtCommand.getInputValues(id);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return 0;
		}
		return vals.scaledValue;
	}
	
	/**
	 * Activate an RCX Light Sensor
	 */
	public void activate() {
		setType(REFLECTION);
	}
	
	/**
	 * Passivate an RCX Light Sensor
	 */
	public void passivate() {
		setType(NO_SENSOR);
	}

    /**
     * Return a variable number of sensor values.
     * NOTE: Currently there is no way to return multiple results from a
     * remote sensor, so we return an error.
     * @param values An array in which to return the sensor values.
     * @return The number of values returned.
     */
    public int readValues(int[] values)
    {
        return -1;
    }

    /**
     * Return a variable number of raw sensor values
     * NOTE: Currently there is no way to return multiple results from a
     * remote sensor, so we return an error.
     * @param values An array in which to return the sensor values.
     * @return The number of values returned.
     */
    public int readRawValues(int[] values)
    {
        return -1;
    }

    public void enableColorSensor()
    {

    }

}