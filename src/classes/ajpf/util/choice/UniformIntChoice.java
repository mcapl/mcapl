package ajpf.util.choice;

public class UniformIntChoice extends Choice<Integer> {
	
	
	public int nextInt(int limit) {
		this.clearChoices();
		for (int i = 0; i < limit; i++) {
			addChoice(1/limit, i);
		}
		int i = get_choice();
		return i;
	}

}
