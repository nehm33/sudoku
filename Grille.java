import java.util.ArrayList;
import java.util.List;

public class Grille {
	
	private Case[][] grille;
	private List<CaseOuverte> casesOuvertes;
	
	public Grille() {
		this.grille = new Case[9][9];
		this.casesOuvertes = new ArrayList<CaseOuverte>();
		this.init();
	}
	
	public Case[][] getGrille() {
		return grille;
	}
	
	public void resoudre() {
		for (CaseOuverte c : this.casesOuvertes) {
			c.setVoisin();
		}
		this.initCandidats();
		int candUnique, x, y;
		CaseOuverte c = this.rechercheCaseUnique();
		System.out.println(this.affiche());
		while (c != null) {
			candUnique = c.getCandidatUnique();
			x = c.getX();
			y = c.getY();
			c.supprimeCandidatVoisin(candUnique);
			this.casesOuvertes.remove(c);
			this.grille[x][y] = new CaseFermee(x, y, candUnique, this);
			System.out.println(this.affiche());
			c = this.rechercheCaseUnique();
		}
	}
	
	public void initCaseFermee(int i, int j, int k) {
		this.casesOuvertes.remove(this.grille[i][j]);
		this.grille[i][j] = new CaseFermee(i, j ,k, this);
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

	private void init() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.grille[i][j] = new CaseOuverte(i, j, this);
				casesOuvertes.add((CaseOuverte) this.grille[i][j]);
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
