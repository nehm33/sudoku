
import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private Grille grille;
	private PanneauFenetre pan;
	private static int longueur = 1000;
	private static int largeur = 600;

	public Fenetre() {
	  
	  // Initialisation de la grille
	  this.grille = new Grille();
	  
	  // Panneau de la fenetre
	  this.pan = new PanneauFenetre(this.grille);

	  // Parametre de la fenetre
	  this.setTitle("Ma première fenêtre Java");
	  this.setSize(longueur, largeur);
	  this.setLocationRelativeTo(null);
	  this.setResizable(false);
	  this.setContentPane(pan);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             

	  // Fenetre Visible
	  this.setVisible(true);
	  
	  go();

  }
  
  public void go() {
	  while(true) {
		  this.getContentPane().repaint();
	  }
  }

}