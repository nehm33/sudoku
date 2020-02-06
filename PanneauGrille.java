import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauGrille extends JPanel {

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
