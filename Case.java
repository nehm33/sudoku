

public abstract class Case {
	
	protected int x;
	protected int y;
	protected int val;
	protected Grille grille;
	

	public Case(int x, int y, Grille g) {
		this.x = x;
		this.y = y;
		this.val = 0;
		this.grille = g;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public int getVal() {
		return val;
	}
	
	public boolean isFermee() {
		return false;
	}
	
	public boolean isOuverte() {
		return false;
	}

	@Override
	public String toString() {
		String str = "";
		if (y == 0) {
			str += "|"; 
		}
		str += " "+val;
		if (y%3 == 2) {
			str += " |";
		}
		if (y == 8) {
			str += "\n";
		}
		return str;
	}
	
	

}
