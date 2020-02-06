import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class Button extends JButton {

	public Button(Fenetre f) {
		super();
		this.addActionListener(f);
	}
	
	public Button(String arg0, Fenetre f) {
		super(arg0);
		this.addActionListener(f);
	}
}
