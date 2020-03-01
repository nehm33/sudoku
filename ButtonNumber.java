import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class ButtonNumber extends Button implements MouseListener {
	
	private int value;
	private Image img;
	
	public ButtonNumber(int num, Fenetre f) {
		super(f);
		this.value = num;
		this.setText("" + value);
		this.img =null;
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img != null) {
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(Color.black);
		    g.drawString(this.getText(), this.getWidth() / 2 - (this.getWidth() /  2 /4), (this.getHeight() / 2) + 5);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			this.img = ImageIO.read(new File("orange.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.img = null;
	}
	
}
