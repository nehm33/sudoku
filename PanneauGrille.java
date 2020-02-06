import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;



public class PanneauGrille extends Panneau implements MouseMotionListener {

	private Grille grille;
	private Case caseOn;
	private Case caseClicked;

	public PanneauGrille(Grille grille) {
		super();
		this.grille = grille;
		this.caseOn = null;
		this.caseClicked = null;
		this.addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 20);
		grille.paint(g, this.getWidth(), this.getHeight(), font, caseOn, caseClicked);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		this.caseOn = grille.getElt(x*9/(this.getWidth()), y*9/(this.getHeight()));
	}
	

}
