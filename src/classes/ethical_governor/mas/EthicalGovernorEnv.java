// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher and Alan Winfield
// 
// This file is part of Declarative Ethical Governor (DEG)
// 
// The DEG is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The DEG is distributed in the hope that it will be useful,
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

package ethical_governor.mas;

import ethical_governor.semantics.EthicalGovernor;

import ail.mas.AILEnv;
import ail.syntax.Action;
import ail.syntax.Predicate;

import java.util.ArrayList;

/**
 * An interface defining the environments needed by Ethical Governors.
 * @author louiseadennis
 *
 */
public interface EthicalGovernorEnv extends AILEnv {
	
	/**
	 * Add an ethical governor for some agent.
	 * @param name
	 * @param foragent
	 */
	public void addEthicalGovernor(String name, String foragent);
	
	/**
	 * Return the governor for some agent.
	 * @param agName
	 * @return
	 */
	public EthicalGovernor getGovernorFor(String agName);
	
	/**
	 * Model the outcomes if agent agName does act;
	 * @param act
	 * @param agName
	 * @return
	 */
	public ArrayList<Predicate> model(Action act, String agName);
}
