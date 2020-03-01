import java.awt.GridLayout;

public abstract class PanneauGridLayout extends Panneau {

	public PanneauGridLayout(int lig, int col, int HGap, int VGap) {
		super();
		GridLayout gl = new GridLayout(lig, col, HGap, VGap);
		this.setLayout(gl);
	}

}
