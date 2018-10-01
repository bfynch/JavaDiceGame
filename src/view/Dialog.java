package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialog {
	
	public JFrame frame = new JFrame("a frame");
	public ImageIcon logo = new ImageIcon(Dialog.class.getResource("/rmit.png"));
	
	public Dialog() {
	JOptionPane.showMessageDialog(frame, "Designed and implemented by Benjamin Fynch, s3589828", null, 0, logo);
		}
	}

