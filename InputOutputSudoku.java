import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputOutputSudoku {
	private Grille g;
	private String nomFichier;
	private FileReader ois;
    private boolean readSuccess;
    private boolean isResolved = false;
	
	public InputOutputSudoku(String nomFichier) {
		this.nomFichier = nomFichier;
		g = new Grille();
		try {
			ois = new FileReader(new File(nomFichier));
			this.lireFichier();
			readSuccess = true;
			ois.close();
		} catch (FileNotFoundException e) {
			readSuccess = false;
			e.printStackTrace();
		} catch (IOException e) {
			readSuccess = false;
			e.printStackTrace();
		}
	}

	public String getNomFichier() {
		return nomFichier;
	}

	@Override
	public String toString() {
		return "************** Grille : "+this.nomFichier +" **************\n" + g;
	}
	
	public void resoudreGrille() {
		if (readSuccess) {
			g.resoudre();
			isResolved = g.isComplete();
		}
	}
	
	public boolean isResolved() {
		return isResolved;
	}

	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}

	public void affichePossibilites() {
		System.out.println("************** Grille : "+this.nomFichier +" **************\n" + g.affiche());
	}
	
	private void lireFichier() {
		try {
			char c;
			int i, j, k;
			c = (char) ois.read();
			String str = "";
			while ( c != (char) -1) {
				str += c;
				i = Integer.parseInt(str);
				str = "";
				ois.read(); // lecture de l'espace
				c = (char) ois.read();
				str += c;
				j = Integer.parseInt(str);
				str = "";
				ois.read(); // lecture de l'espace
				c = (char) ois.read();
				str += c;
				k = Integer.parseInt(str);
				str = "";
				g.initCaseFermee(i, j, k);
				c = (char) ois.read(); // sauter \r ou \n
				if (c == '\r') {
					c = (char) ois.read(); // ligne suivante : sauter \n si il y a \r
				}
				c = (char) ois.read(); // ligne suivante
			}
		} catch (FileNotFoundException e) {
			this.readSuccess = false;
			e.printStackTrace();
		} catch (IOException e) {
			this.readSuccess = false;
			e.printStackTrace();
		}
	}
}
