import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


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
	
	public String affiche() {
		return this.toString();
	}
	
	public void paint(Graphics g, int longueur, int largeur, Font font, Case caseOn, Case caseClicked) {
		g.setColor(Color.BLUE);
		g.setFont(font);
		if (this == caseClicked) {
			g.fillRect(x*longueur/9, y*largeur/9, longueur/9, largeur/9);
		} else if (this == caseOn) {
			g.fillRect(x*longueur/9, y*largeur/9, longueur/9, largeur/9);
		} else {
			g.setColor(Color.BLACK);
			g.drawRect(x*longueur/9, y*largeur/9, longueur/9, largeur/9);
		}
		g.setColor(Color.BLACK);
		g.drawString(""+this.val, x*longueur/9 + longueur/18 - 3, y*largeur/9 + largeur/18 +7);
	}
}
