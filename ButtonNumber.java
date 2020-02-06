import javax.swing.JButton;

public class ButtonNumber extends JButton {
	
	private int value;
	
	public ButtonNumber(int num) {
		super();
		this.value = num;
		this.setText("" + value);
	}

}
