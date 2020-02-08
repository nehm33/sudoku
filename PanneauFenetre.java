import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanneauFenetre extends Panneau {
	
	private PanneauGrille panGrille;
	private PanneauButtonNumber panButtonNumber;
	private Button resolve;
	private Button reset;

	public PanneauFenetre(Fenetre f) {
		super();
		// Mise en place des boutons
		this.resolve = new Button("Resoudre", f);
		this.reset = new Button("Recommencer", f);
		// Panneau de la grille
		this.panGrille = new PanneauGrille();
		// Panneau des boutons de nombre
		this.panButtonNumber = new PanneauButtonNumber(0, 10, 10, 10, f);
		// Panneau des boutons de fonctionnalites
		Panneau panFonctionnalite = new PanneauFonctionnalite(7, 0, 10, 30);
		// Ajout des boutons
		panFonctionnalite.add(this.resolve);
		panFonctionnalite.add(this.reset);
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

	public Button getResolve() {
		return resolve;
	}

	public Button getReset() {
		return reset;
	}
	

}
