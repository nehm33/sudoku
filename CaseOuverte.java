import java.util.ArrayList;
import java.util.List;

public class CaseOuverte extends Case implements Comparable<CaseOuverte> {

	private List<Integer> candidats; 
	private ArrayList<Case> voisins;
	private ArrayList<Case> voisinsLigne;
	private ArrayList<Case> voisinsColonne;
	private ArrayList<Case> voisinsBloc;

	public CaseOuverte(int x, int y, Grille g) {
		super(x, y, g);
		candidats = new ArrayList<Integer>();
		this.initCandidats();
		this.voisins = new ArrayList<Case>();
		this.voisinsLigne = new ArrayList<Case>();
		this.voisinsColonne = new ArrayList<Case>();
		this.voisinsBloc = new ArrayList<Case>();
	}
	
	public ArrayList<Case> getVoisins() {
		return voisins;
	}
	
	public List<Integer> getCandidats() {
		return candidats;
	}

	public boolean appartient(int d) {
		return candidats.contains(d);
	}
	
	public boolean isOuverte() {
		return true;
	}
	
	public void supprimeCandidat(int cand) {
		candidats.remove((Object)cand);
	}
	
	public void supprimeCandidatVoisin(int cand) {
		for (Case c : this.voisins) {
			if (c.isOuverte()) {
				((CaseOuverte) c).supprimeCandidat(cand);
			}
		}
	}

	public void setVoisin() {
		int x = this.x;
		int y = this.y;
		// Parcours de la ligne
		for (int j = 1; j < 9; j++) {
			voisins.add(this.grille.getGrille()[x][(y+j)%9]);
			voisinsLigne.add(this.grille.getGrille()[x][(y+j)%9]);
		}
		//Parcours de la colonne
		for (int i = 1; i < 9; i++) {
			voisins.add(this.grille.getGrille()[(x+i)%9][y]); 
			voisinsColonne.add(this.grille.getGrille()[(x+i)%9][y]);
		}
		//Parcours du bloc
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != 0 || j != 0) {
					if (i != 0 && j != 0) {
						voisins.add(this.grille.getGrille()[x/3*3 + (x%3+i)%3][y/3*3 + (y%3+j)%3]);
					}
					voisinsBloc.add(this.grille.getGrille()[x/3*3 + (x%3+i)%3][y/3*3 + (y%3+j)%3]);
				}
			}
		}
	}
	
	public int getCandidatUnique() {
		if (this.haveCandidatUnique()) {
			for (int cand : this.candidats) {
				if (this.candidatUnique(cand)) {
					return cand;
				}
			}
		}
		return -1;
	}
	
	public String affiche() {
		String str = " {";
		for (int i : this.candidats) {
			str += " "+i;
		}
		str += "}";
		if (y == 0) {
			str = "|"+str; 
		}
		if (y%3 == 2) {
			str += " |";
		}
		if (y == 8) {
			str += "\n";
		}
		return str;
	}
	
	@Override
	public int compareTo(CaseOuverte arg0) {
		int comp = this.candidats.size()-arg0.candidats.size();
		if (comp == 0) {
			return this.hashCode() - arg0.hashCode();
		}
		return comp;
	}
	
	private void initCandidats() {
		for (int i=1; i<10; i++) {
			candidats.add(i);
		}
	}
	
	private boolean candidatUnique(int d) {
		// S'il y a un seul candidat
		if (this.candidats.size() == 1 && this.appartient(d)) {
			return true;
		}
		else {
			// Verifie que x n'est pas candidat sur une ligne, une colonne ou un bloc
			return candidatUniqueEnsemble(this.voisinsLigne, d) || 
									candidatUniqueEnsemble(this.voisinsColonne, d) || 
											candidatUniqueEnsemble(this.voisinsBloc, d);
		}
	}
	
	private boolean candidatUniqueEnsemble(List<Case> l, int d) {
		for (Case c : l) {
			if (c.isOuverte() && ((CaseOuverte)c).appartient(d)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean haveCandidatUnique() {
		for (int cand : this.candidats) {
			if (this.candidatUnique(cand)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
