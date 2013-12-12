package ail.syntax;

import java.util.List;


public class GMessage implements Unifiable, GuardAtom {
	
	public GMessage(byte sentOrReceived, Message msg) {};

	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void standardise_apart(Unifiable t, Unifier u) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getVarNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void renameVar(String oldname, String newname) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean match(Unifiable t, Unifier u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGround() {
		// TODO Auto-generated method stub
		return false;
	}

}
