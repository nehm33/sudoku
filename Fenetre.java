import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	private Grille grille;
	private static int longueur = 1300;
	private static int largeur = 1000;

  public Fenetre(){
	  
	  // Panneau de la fenetre
	  JPanel pan = new JPanel();
	  
	  // Initialisation de la grille
	  this.grille = new Grille();
	  
	  // Panneau de la grille
	  PanneauGrille panGrille = new PanneauGrille(this.grille);
	  // Panneau des boutons
	  JPanel panButtonNumber = new JPanel();
	  JPanel panSouth = new JPanel();
	  // Panneau des boutons de fonctionnalites
	  JPanel panButtonFonctionnalite = new JPanel();
	  // Panneau vide
	  JPanel panVide= new JPanel();
	  panVide.add(new JLabel("        "));
	  
	  // Initialisation des layout
	  GridLayout gl = new GridLayout(0, 9, 10,10);
	  panButtonNumber.setLayout(gl);
	  gl = new GridLayout(2, 0, 10, 10);
	  panVide.setLayout(gl);
	  
	  // Ajout des boutons
	  for (int i = 1; i < 10; i++ ) {
		  panButtonNumber.add(new ButtonNumber(i));
	  }
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