

public class CaseFermee extends Case {

	public CaseFermee(int x, int y, int val, Grille g) {
		super(x, y, g);
		this.val = val;
	}	
	
	public boolean isFermee() {
		return true;
	}

}
