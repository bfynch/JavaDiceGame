package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class StatusBar extends JPanel
{
	private static final long serialVersionUID = 1L;
	public JPanel sbar = new JPanel();
	public JLabel statusLabel = new JLabel(" ");
	public JLabel warningLabel = new JLabel("");
	
	public StatusBar() {
		setLayout(new GridLayout(1,3));
		add(warningLabel);
		add(statusLabel);
		warningLabel.setHorizontalAlignment(JLabel.CENTER);
		statusLabel.setHorizontalAlignment(JLabel.CENTER);
		statusLabel.setBorder(new LineBorder(Color.BLACK, 1));
		warningLabel.setBorder(new LineBorder(Color.BLACK, 1));
	}

}
