package ail.mas.scheduling;

import java.util.List;

import ajpf.MCAPLJobber;
import ajpf.MCAPLScheduler;
import ajpf.util.VerifyList;

public class SingleAgentScheduler implements MCAPLScheduler {
	private MCAPLJobber agent;
	private boolean somethinghaschanged = true;
	private boolean isactive = true;

	@Override
	public void perceptChanged() {
		// TODO Auto-generated method stub

	}

	@Override
	public void perceptChanged(String agName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getListenerName() {
		// TODO Auto-generated method stub
		return "scheduler";
	}

	@Override
	public List<MCAPLJobber> getActiveJobbers() {
		List<MCAPLJobber> ags = new VerifyList<MCAPLJobber>();
		if (isactive) {
			ags.add(agent);
		}
		// TODO Auto-generated method stub
		return ags;
	}

	@Override
	public void notActive(String a) {
		isactive = false;
		// TODO Auto-generated method stub

	}

	@Override
	public void isActive(String a) {
		isactive = true;
		// TODO Auto-generated method stub

	}

	@Override
	public void addJobber(MCAPLJobber a) {
		agent = a;
		isactive = true;
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<String> getActiveJobberNames() {
		List<String> ags = new VerifyList<String>();
		if (isactive) {
			ags.add(agent.getName());
		}
		// TODO Auto-generated method stub
		return ags;
	}

	@Override
	public List<MCAPLJobber> getAvailableJobbers() {
		List<MCAPLJobber> ags = new VerifyList<MCAPLJobber>();
		if (somethinghaschanged) {
			ags.add(agent);
			somethinghaschanged = false;
		} 
		// TODO Auto-generated method stub
		return ags;
	}

	@Override
	public void removeJobber(String jobbername) {
		// TODO Auto-generated method stub
		// ? Not relevant for single agent
	}

	@Override
	public void doNotSchedule(String a) {
		// TODO Auto-generated method stub
		// ? Not relevant for single agent
		
	}

	@Override
	public void resumeScheduling(String a) {
		// TODO Auto-generated method stub
		// ? Not relevant for single agent
		
	}

}
