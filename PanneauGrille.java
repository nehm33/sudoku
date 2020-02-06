import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class PanneauGrille extends Panneau implements MouseMotionListener, MouseListener {

	private Grille grille;
	private Case caseOn;
	private Case caseClicked;
	private static Font font = new Font("Courier", Font.BOLD, 20);

	public PanneauGrille(Grille grille) {
		super();
		this.grille = grille;
		this.caseOn = null;
		this.caseClicked = null;
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		grille.paint(g, this);
		
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
	

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		this.caseClicked = grille.getElt(x*9/(this.getWidth()), y*9/(this.getHeight()));	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	public Case getCaseOn() {
		return caseOn;
	}

	public Case getCaseClicked() {
		return caseClicked;
	}

	public Font getFont() {
		return font;
	}
	
	public void initCase (int val) {
		if (val == 0) {
			this.grille.ouvrirCaseFermee(caseClicked.getX(), caseClicked.getY());
		} else {
			this.grille.initCaseFermee(caseClicked.getX(), caseClicked.getY(), val);
		}
	}

	public void resetGrille() {
		this.grille = new Grille();
	}

	public Grille getGrille() {
		return grille;
	}
	
	
}
