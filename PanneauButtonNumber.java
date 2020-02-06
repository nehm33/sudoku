import javax.swing.JButton;

public class PanneauButtonNumber extends PanneauGridLayout {
	
	private JButton[] boutons;

	public PanneauButtonNumber(int lig, int col, int HGap, int VGap, Fenetre f) {
		super(lig, col, HGap, VGap);
		boutons = new JButton[10];
		boutons[0] = new Button("efface", f);
		this.add(boutons[0]);
		for (int i = 1; i < 10; i++) {
			boutons[i] = new ButtonNumber(i, f);
			this.add(boutons[i]);
		}
	}
	
	public JButton getButton(int i) {
		return this.boutons[i];
	}

}
