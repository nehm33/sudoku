import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauFenetre extends Panneau {
	
	private PanneauGrille panGrille;

	public PanneauFenetre(Grille g) {
		super();
		// Panneau de la grille
		this.panGrille = new PanneauGrille(g);
		// Panneau des boutons de nombre
		Panneau panButtonNumber = new PanneauButtonNumber(0, 9, 10, 10);
		// Panneau des boutons de fonctionnalites
		JPanel panFonctionnalite = new JPanel();
		// Ajout des boutons
		panFonctionnalite.add(new JButton("Bonjour"));
		// Ajout des panneaux dans celui de la fenetre
		JPanel panSouth = new JPanel();
		this.setLayout(new BorderLayout());
		this.add(panGrille, BorderLayout.CENTER);
		panSouth.add(new PanneauVide(), BorderLayout.NORTH);
		panSouth.add(panButtonNumber, BorderLayout.SOUTH);
		this.add(panSouth, BorderLayout.SOUTH);
		this.add(panFonctionnalite, BorderLayout.EAST);
		this.add(new LabelTitle("Résolveur de sudoku"), BorderLayout.NORTH);
		this.add(new PanneauVide(), BorderLayout.WEST);
	}

}
