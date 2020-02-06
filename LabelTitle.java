import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelTitle extends JLabel {

	public LabelTitle() {
		super();
	}

	public LabelTitle(String text) {
		super(text);
		//Définition d'une police d'écriture
		Font police = new Font("Tahoma", Font.BOLD, 30);
		//On l'applique au JLabel
		this.setFont(police);
		//Changement de la couleur du texte
		this.setForeground(Color.blue);
		//On modifie l'alignement du texte grâce aux attributs statiques
		//de la classe JLabel
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
	}
	
	

}
