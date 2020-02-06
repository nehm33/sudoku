import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	private Grille grille;
	private static int longueur = 1000;
	private static int largeur = 600;

  public Fenetre(){
	  
	  // Panneau de la fenetre
	  JPanel pan = new JPanel();
	  
	  // Initialisation de la grille
	  this.grille = new Grille();
	  
	  // Panneau de la grille
	  Panneau panGrille = new PanneauGrille(this.grille);
	  // Panneau des boutons
	  Panneau panButtonNumber = new PanneauButtonNumber(0, 9, 10, 10);
	  JPanel panSouth = new JPanel();
	  // Panneau des boutons de fonctionnalites
	  JPanel panButtonFonctionnalite = new JPanel();
	  // Panneau vide
	  Panneau panVide= new PanneauVide();
	  
	  // Ajout des boutons
	  panButtonFonctionnalite.add(new JButton("Bonjour"));
	  
	  // Ajout des panneaux dans celui de la fenetre
	  pan.setLayout(new BorderLayout());
	  pan.add(panGrille, BorderLayout.CENTER);
	  panSouth.add(panVide, BorderLayout.NORTH);
	  panSouth.add(panButtonNumber, BorderLayout.SOUTH);
	  pan.add(panSouth, BorderLayout.SOUTH);
	  pan.add(panButtonFonctionnalite, BorderLayout.EAST);
	  pan.add(new LabelTitle("Résolveur de sudoku"), BorderLayout.NORTH);
	  pan.add(panVide, BorderLayout.WEST);

	  // Parametre de la fenetre
	  this.setTitle("Ma première fenêtre Java");
	  this.setSize(longueur, largeur);
	  this.setLocationRelativeTo(null);
	  this.setResizable(false);
	  this.setContentPane(pan);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             

	  // Fenetre Visible
	  this.setVisible(true);

  }

}