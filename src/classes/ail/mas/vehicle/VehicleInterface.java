package ail.mas.vehicle;

import ail.mas.AILEnv;
import ail.syntax.Message;
import ail.syntax.Predicate;

public interface VehicleInterface extends AILEnv {
	public void setEnv(VehicleEnv v);
	
	public String getName();
	
	public void addMessage(String agName, Message msg);
	
	public void addPercept(Predicate p);
	
	public boolean removePercept(Predicate p);
	
	public void clearPercepts();
}
