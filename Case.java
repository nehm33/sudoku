import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		if (val != other.val)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public String affiche() {
		return this.toString();
	}
	
	public void paint(Graphics g, PanneauGrille panGrille) {
		int longueur = panGrille.getWidth();
		int largeur = panGrille.getHeight();
		g.setColor(Color.BLUE);
		g.setFont(panGrille.getFont());
		if (this == panGrille.getCaseClicked()) {
			g.fillRect(x*longueur/9, y*largeur/9, longueur/9, largeur/9);
			
		} else if (this == panGrille.getCaseOn()) {
			try {
				g.drawImage(ImageIO.read(new File("jaune.png")), x*longueur/9, y*largeur/9, longueur/9, largeur/9, panGrille);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			g.setColor(Color.BLACK);
			g.drawRect(x*longueur/9, y*largeur/9, longueur/9, largeur/9);
		}
		g.setColor(Color.BLACK);
		if (this.isFermee()) {
			g.drawString(""+this.val, x*longueur/9 + longueur/18 - 3, y*largeur/9 + largeur/18 +7);
		}
	}
}
