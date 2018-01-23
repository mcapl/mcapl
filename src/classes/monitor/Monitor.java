// ----------------------------------------------------------------------------
// Copyright (C) 2018 Angelo Ferrando, Louise A. Dennis, Davide Ancona, Michael Fisher and Viviana Mascardi
//
// This file is part of the Runtime Verification for MCAPL (RVMCAPL) Library.
// 
// The RVMCAPL Library is free software; you can redistribute it and/or
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
// ----------------------------------------------------------------------------

package monitor;

import org.jpl7.Query;

public class Monitor {

  public Monitor(String texpFileName){
	  JPLUtils.init(texpFileName);
  }

  public void initialize(String logFile, String protocolName){
    if(logFile == null || protocolName == null){
      throw new IllegalArgumentException("logFile and protocolName must not be null");
    }
    try{
      JPLUtils.createAndCheck("initialize('" + logFile + "', " + protocolName + ")");
    } catch(PrologException e){
      throw new IllegalArgumentException("Initialization failed. The logfile or the protocol name are not valid");
    }
  }

  public boolean check(String event){
    Query query = new Query("type_check_aux(" + event + ")");
    boolean res = query.hasSolution();
    query.close();
    return res;
  }

}
