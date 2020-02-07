import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanneauFenetre extends Panneau {
	
	private PanneauGrille panGrille;
	private PanneauButtonNumber panButtonNumber;

	public PanneauFenetre(Fenetre f) {
		super();
		// Panneau de la grille
		this.panGrille = new PanneauGrille();
		// Panneau des boutons de nombre
		this.panButtonNumber = new PanneauButtonNumber(0, 10, 10, 10, f);
		// Panneau des boutons de fonctionnalites
		Panneau panFonctionnalite = new PanneauFonctionnalite(2, 0, 10, 10);
		// Ajout des boutons
		panFonctionnalite.add(f.getResolve());
		panFonctionnalite.add(f.getReset());
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

	public PanneauGrille getPanGrille() {
		return panGrille;
	}

	public PanneauButtonNumber getPanButtonNumber() {
		return panButtonNumber;
	}
	
	public void resetGrille() {
		this.panGrille.resetGrille();
	}
	
	public void resoudre() {
		this.panGrille.resoudre();
	}

}
