// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Martin Mose Bentzen, Michael Fisher 
// 
// This file is part of Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen.smarthome;

import java.util.List;
import java.util.TreeMap;

import ail.mas.DefaultEnvironment;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ajpf.MCAPLJobber;
import ajpf.MCAPLScheduler;
import ajpf.PerceptListener;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifyList;

public class SmartHomeEnv extends DefaultEnvironment implements MCAPLJobber {
	static final String logname = "gwendolen.smarthome.SmartHomeEnv";
	int clock_time = 0;
	
	public SmartHomeEnv() {
		super();
		ClockScheduler scheduler = new ClockScheduler();
		this.setScheduler(scheduler);
		addPerceptListener(scheduler);
		
		getScheduler().addJobber(this);
		getScheduler().notActive(this.getName());
		
	}

	@Override
	public int compareTo(MCAPLJobber o) {
		return o.getName().compareTo(getName());
	}
	
	@Override
	public void init_after_adding_agents() {
		Literal newtime = new Literal("time");
		newtime.addTerm(new NumberTermImpl(clock_time));
		this.addPercept(newtime);		
	}

	@Override
	public void do_job() {
		Literal time = new Literal("time");
		time.addTerm(new NumberTermImpl(clock_time));
		this.removePercept(time);
		clock_time++;
		Literal newtime = new Literal("time");
		newtime.addTerm(new NumberTermImpl(clock_time));
		this.addPercept(newtime);
		System.err.println("TIME IS " + clock_time);
		scheduler.notActive(this.getName());
	}

	@Override
	public String getName() {
		return logname;
	}
	
	@Override
	public boolean done() {
		return false;
	}
	
	public class ClockScheduler implements MCAPLScheduler, PerceptListener {

		private TreeMap<String, MCAPLJobber> agnames = new TreeMap<String, MCAPLJobber>();
		/* We use VerifyLists to reduce the state space during verification */
		private VerifyList<String> activeAgents = new VerifyList<String>();
		private VerifyList<String> inactiveAgents = new VerifyList<String>();
		private VerifyList<String> donotSchedule = new VerifyList<String>();

		/* Flag that indicates a change in the  system somewhere indicating a new choice of 
		 * agent is wanted
		 */
		private boolean somethinghaschanged = true;
		
		@Override
		public void perceptChanged() {
			somethinghaschanged = true;
		}

		@Override
		public void perceptChanged(String agName) {
			somethinghaschanged = true;
		}

		@Override
		public String getListenerName() {
			return "scheduler";
		}

		@Override
		public List<MCAPLJobber> getActiveJobbers() {
			List<MCAPLJobber> ags = new VerifyList<MCAPLJobber>();
			for (int i = 0; i < activeAgents.size(); i++) {
				ags.add(agnames.get(activeAgents.get(i)));
			}
			
			
			return ags;
		}

		@Override
		public List<MCAPLJobber> getAvailableJobbers() {
			if (getActiveJobbers().isEmpty()) {
				isActive(SmartHomeEnv.this.getName());
			}
			List<MCAPLJobber> ags = new VerifyList<MCAPLJobber>();
			if (somethinghaschanged) {
				// Got a Concurrent Modification Error here in the Sticky Wheel example.
				try {
					for (String s: activeAgents) {
						ags.add(agnames.get(s));
					}
					
				} catch (Exception e) {
					AJPFLogger.warning(logname, e.getMessage());
				}
			}
			
			somethinghaschanged = false;
			return ags;
		}

		@Override
		public void notActive(String a) {
			if (activeAgents.contains(a)) {
				activeAgents.remove(a);
				if (!inactiveAgents.contains(a)) {
					inactiveAgents.put(a);
				}
			}
			somethinghaschanged = true;
		}

		@Override
		public void isActive(String a) {
			if (!activeAgents.contains(a) && !donotSchedule.contains(a)) {
				activeAgents.put(a);
			}
			somethinghaschanged = true;
		}

		@Override
		public void addJobber(MCAPLJobber a) {
			agnames.put(a.getName(), a);
			if (!donotSchedule.contains(a.getName())) {
				activeAgents.put(a.getName());
			}
		}

		@Override
		public List<String> getActiveJobberNames() {
			List<String> ags = new VerifyList<String>();
			for (int i = 0; i < activeAgents.size(); i++) {
				ags.add(activeAgents.get(i));
			}
			return ags;
		}

		@Override
		public void removeJobber(String jobberName) {
			agnames.remove(jobberName);
			activeAgents.remove(jobberName);
		}

		@Override
		public void doNotSchedule(String a) {
			donotSchedule.add(a);
			if (activeAgents.contains(a)) {
				activeAgents.remove(a);
			}
			somethinghaschanged = true;
		}

		@Override
		public void resumeScheduling(String a) {
			donotSchedule.remove(a);
			if (!inactiveAgents.contains(a)) {
				activeAgents.add(a);
			}
			somethinghaschanged = true;
		}
		
	}

}
