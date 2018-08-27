package juno.smarthome;

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.mas.scheduling.RoundRobinScheduler;
import ail.syntax.Predicate;
import ajpf.MCAPLJobber;

public class GamesEnv extends DefaultEnvironment implements MCAPLJobber {
	final static String logname = "juno.smarthome.FireEnv";
	static int DAY = 0;
	static int EVENING = 1;
	static int NIGHT = 2;
	int time = DAY;
	static int CHILDREN_NOISY = 0;
	int noise = 0;
	
	public GamesEnv() {
		super();
		RoundRobinScheduler scheduler = new RoundRobinScheduler();
		this.setScheduler(scheduler);
		addPerceptListener(scheduler);
		
		getScheduler().addJobber(this);
	}

	@Override
	public int compareTo(MCAPLJobber o) {
		return o.getName().compareTo(getName());
	}

	@Override
	public void do_job() {
		if (time == DAY) {
			time = EVENING;
			removePercept(new Predicate("day"));
			addPercept(new Predicate("evening"));
			System.err.println("Evening");
			if (noise == 2) {
				System.err.println("Mum Wrapping Presents");
			}
		} else if (time == EVENING) {
			time = NIGHT;
			removePercept(new Predicate("evening"));
			removePercept(new Predicate("mum_working"));
			removePercept(new Predicate("mum_wrapping_presents"));
			addPercept(new Predicate("night"));		
			System.err.println("Night");
			noise++;
		} else {
			time = DAY;
			removePercept(new Predicate("night"));
			if (noise < 2) {
				addPercept(new Predicate("mum_working"));
			} else {
				addPercept(new Predicate("mum_wrapping_presents"));
			}
			addPercept(new Predicate("day"));
			System.err.println("Day");
			if (noise == 1) {
				CHILDREN_NOISY = 1;
				System.err.println("CHILDREN_NOISY!");
				addPercept(new Predicate("children_noisy"));
			}
		}
	}

	@Override
	public String getName() {
		return logname;
	}
	
	@Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		addPercept(new Predicate("day"));
		addPercept(new Predicate("mum_working"));
	}

}
