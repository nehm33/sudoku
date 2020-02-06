
public class PanneauButtonNumber extends PanneauGridLayout {

	public PanneauButtonNumber(int lig, int col, int HGap, int VGap) {
		super(lig, col, HGap, VGap);
		for (int i = 1; i < 10; i++ ) {
			this.add(new ButtonNumber(i));
		}
	}

}
