import javax.swing.JLabel;

public class PanneauVide extends PanneauGridLayout {

	public PanneauVide() {
		super(2, 0, 10, 10);
		this.add(new JLabel("        "));
	}

}
