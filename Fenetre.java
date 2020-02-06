
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Fenetre extends JFrame implements ActionListener {

	private Grille grille;
	private PanneauFenetre pan;
	private Button resolve = new Button("Resoudre", this);
	private Button reset = new Button("Recommencer", this);
	private static int longueur = 1000;
	private static int largeur = 600;

	public Fenetre() {
	  
	  // Initialisation de la grille
	  this.grille = new Grille();
	  
	  // Panneau de la fenetre
	  this.pan = new PanneauFenetre(this.grille, this);

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

  @Override
  public void actionPerformed(ActionEvent arg0) {
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(0)) {
		this.pan.getPanGrille().initCase(0);
	}
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(1)) {
		this.pan.getPanGrille().initCase(1);
	}
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(2)) {
		this.pan.getPanGrille().initCase(2);
	}
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(3)) {
		this.pan.getPanGrille().initCase(3);
	}
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(4)) {
		this.pan.getPanGrille().initCase(4);
	}
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(5)) {
		this.pan.getPanGrille().initCase(5);
	}
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(6)) {
		this.pan.getPanGrille().initCase(6);
	}
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(7)) {
		this.pan.getPanGrille().initCase(7);
	}
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(8)) {
		this.pan.getPanGrille().initCase(8);
	}
	if (arg0.getSource()==this.pan.getPanButtonNumber().getButton(9)) {
		this.pan.getPanGrille().initCase(9);
	}
	if (arg0.getSource()==this.resolve) {
		this.grille.resoudre();;
	}
	if (arg0.getSource()==this.reset) {
		this.pan.resetGrille();
		this.grille = this.pan.getPanGrille().getGrille();
	}
  }

  public Button getResolve() {
	  return resolve;
  }

  public Button getReset() {
	  return reset;
  }
  
  

}