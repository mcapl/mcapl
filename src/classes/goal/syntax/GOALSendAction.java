package goal.syntax;

import ail.syntax.Action;
import ail.syntax.SendAction;

public class GOALSendAction extends SendAction {
	public static final int SEND = 0;
	public static final int SENDONCE = 1;
	
	int type = SEND;
	
	public GOALSendAction(Action a, int ilf, int type) {
		super(a, ilf);
		this.type = type;
	}
}
