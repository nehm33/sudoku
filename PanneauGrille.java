import java.awt.Font;
import java.awt.Graphics;



public class PanneauGrille extends Panneau {

	private Grille grille;

	public PanneauGrille(Grille grille) {
		super();
		this.grille = grille;
	}

	public void paintComponent(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 20);
		grille.paint(g, this.getWidth(), this.getHeight(), font);
	}

}
