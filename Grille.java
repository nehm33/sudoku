import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;

public class Grille {
	
	private Case[][] grille;
	private List<CaseOuverte> casesOuvertes;
	private TreeSet<CaseOuverte> casesOuvertesTriees;
	
	public Grille() {
		this.grille = new Case[9][9];
		this.casesOuvertes = new ArrayList<CaseOuverte>();
		this.init();
	}
	
	public Case[][] getGrille() {
		return grille;
	}
	
	public Case getElt(int i, int j) {
		return this.grille[i][j];
	}
	
	public void resoudre() {
		for (CaseOuverte c : this.casesOuvertes) {
			c.setVoisin();
		}
		this.initCandidats();
		int candUnique, x, y;
		CaseOuverte c = this.rechercheCaseUnique();
		while (c != null) {
			candUnique = c.getCandidatUnique();
			x = c.getX();
			y = c.getY();
			c.supprimeCandidatVoisin(candUnique);
			this.casesOuvertes.remove(c);
			this.grille[x][y] = new CaseFermee(x, y, candUnique, this);
			c = this.rechercheCaseUnique();
		}
		if (!this.isComplete()) {
			this.completer();
		}
	}
	
	public void completer() {
		casesOuvertesTriees = new TreeSet<CaseOuverte>(this.casesOuvertes);
		Grille g = new Grille(this);
		CaseOuverte c = casesOuvertesTriees.pollFirst();
		if (c.getCandidats().size() != 0) {
			ListIterator<Integer> iter = c.getCandidats().listIterator();
			int cand;
			boolean solutionTrouvee = false;
			while (iter.hasNext() && !solutionTrouvee) {
				cand = iter.next();
				g = new Grille(this);
				g.initCaseFermee(c.getX(), c.getY(), cand);
				g.resoudre();
				if (g.isComplete()) {
					this.grille = g.grille;
					this.casesOuvertes = g.casesOuvertes;
					solutionTrouvee = true;
				}
			}
		}
	}
	
	public void initCaseFermee(int i, int j, int k) {
		if (this.grille[i][j].isOuverte()) {
			this.casesOuvertes.remove(this.grille[i][j]);
		}
		this.grille[i][j] = new CaseFermee(i, j, k, this);
	}
	
	public void ouvrirCaseFermee(int i, int j) {
		this.grille[i][j] = new CaseOuverte(i, j, this);
		this.casesOuvertes.add((CaseOuverte) this.grille[i][j]);
	}
	
	@Override
	public String toString() {
		String str = "-------------------------\n";
		for (int i = 0; i < 3; i++) {
			for (int j = i*3; j < (i+1)*3; j++) {
				for (Case c: grille[j]) {
					str += c.toString();
				}
			}
			if (i != 2) {
				str += "|-------|-------|-------|\n";
			}
		}
		str += "-------------------------\n";
		return str;
	}
	
	public boolean isComplete() {
		return this.casesOuvertes.isEmpty();
	}
	
	public String affiche() {
		String str = "-------------------------\n";
		for (int i = 0; i < 3; i++) {
			for (int j = i*3; j < (i+1)*3; j++) {
				for (Case c: grille[j]) {
					str += c.affiche();
				}
			}
			if (i != 2) {
				str += "|-------|-------|-------|\n";
			}
		}
		str += "-------------------------\n";
		return str;
	}
	
	public void paint(Graphics g, PanneauGrille panGrille) {
		int longueur = panGrille.getWidth();
		int largeur = panGrille.getHeight();
		// Trace des cases
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.grille[i][j].paint(g, panGrille);
			}
		}
		// Traces des blocs
		Graphics2D g2D = (Graphics2D) g.create();
		Stroke stroke2 = new BasicStroke(6f);
		g2D.setStroke(stroke2);
		for (int i = 1; i < 3; i++) {
			g2D.drawLine(i*longueur/3, 0, i*longueur/3, largeur);
			g2D.drawLine(0, i*largeur/3, longueur, i*largeur/3);
		}
		g2D.drawLine(longueur-1, 0, longueur-1, largeur);
		g2D.drawLine(0, largeur-1, longueur, largeur-1);
		g2D.drawLine(1, 0, 1, largeur);
		g2D.drawLine(0, 1, longueur, 1);
	}
	
	private Grille(Grille g) {
		this.grille = new Case[9][9];
		this.casesOuvertes = new ArrayList<CaseOuverte>();
		copier(g);
	}

	private void init() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.grille[i][j] = new CaseOuverte(i, j, this);
				casesOuvertes.add((CaseOuverte) this.grille[i][j]);
			}
		}
	}
	
	private void copier(Grille g) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.grille[i][j] = new CaseOuverte(i, j, this);
				casesOuvertes.add((CaseOuverte) this.grille[i][j]);
				if (g.grille[i][j].isFermee()) {
					this.initCaseFermee(i, j, g.grille[i][j].getVal());
				}
			}
		}
	}
	
	private void initCandidats() {
		for (CaseOuverte c : this.casesOuvertes) {
			this.initCandidatsCase(c);
		}
	}

	private void initCandidatsCase(CaseOuverte c) {
		for (Case cas : c.getVoisins()) {
			if (cas.isFermee()) {
				c.supprimeCandidat(cas.getVal());
			}
		}
		
	}
	
	private CaseOuverte rechercheCaseUnique() {
		int candUnique;
		for (CaseOuverte c : this.casesOuvertes) {
			candUnique = c.getCandidatUnique();
			if (candUnique != -1) {
				return c;
			}
		}
		return null;
	}

}
