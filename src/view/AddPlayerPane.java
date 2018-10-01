package view;

import controller.ClearActionListener;
import controller.NewPlayerActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.GameEngineImpl;
import model.interfaces.GameEngine;

public class AddPlayerPane extends JPanel {

	private static final long serialVersionUID = 1L;
	public JPanel addPlayerTab = new JPanel();
	public JLabel playername = new JLabel("Player Name: ");
	public JLabel playerID = new JLabel("Player ID: ");
	public JLabel points = new JLabel("Points: ");
	public JTextField enterPlayerName = new JTextField(20);
	public JTextField enterPlayerID = new JTextField(20);
	public JTextField enterPoints = new JTextField(20);
	public JButton addbutton = new JButton("Add Player");
	public JButton clearbutton = new JButton("Clear");
	public JTextArea allPlayers = new JTextArea(5,20);

	public AddPlayerPane(GameEngineImpl ge, DicePanel dp) {

		setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();	    

	    gbc.gridy=1;
	    gbc.gridx=1;
		add(playername,gbc);
	   
		gbc.gridy=1;
		gbc.gridx=2;
		add(enterPlayerName,gbc);
	   
		gbc.gridy=2;
		gbc.gridx=1;
		add(playerID,gbc);
	   
		gbc.gridy=2;
		gbc.gridx=2;
		add(enterPlayerID,gbc);
		
		gbc.gridy=3;
		gbc.gridx=1;
	    add(points,gbc);
	    
	    gbc.gridy=3;
	    gbc.gridx=2;
	    add(enterPoints,gbc);
		
	    gbc.gridy=5;
	    gbc.gridx=1;
	    add(addbutton,gbc);
		
	    gbc.gridy=5;
	    gbc.gridx=2;
	    add(clearbutton,gbc);
		
	    gbc.gridy=7;
	    gbc.gridx=2;
	    add(allPlayers,gbc);

		clearbutton.addActionListener(new ClearActionListener(this));
		addbutton.addActionListener(new NewPlayerActionListener(ge,dp,this));
	}

}
