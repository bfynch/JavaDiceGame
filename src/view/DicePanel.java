package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;

public class DicePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	public JPanel jp = new JPanel();
	public JLabel selectPlayer = new JLabel("Select a Player");
	public JButton roll = new JButton("Roll!");
	public DefaultListModel<SimplePlayer> model = new DefaultListModel<SimplePlayer>();
	public JList<SimplePlayer> list = new JList<SimplePlayer>(model);
	public JScrollPane pane = new JScrollPane(list);
	public JLabel playerdie1 = new JLabel();
	public JLabel playerdie2 = new JLabel();
	public JLabel housedie1 = new JLabel();
	public JLabel housedie2 = new JLabel();
	public JLabel playerLabel = new JLabel("Player");
	public JLabel houseLabel = new JLabel("House");
	public ImageIcon dice1 = new ImageIcon(DicePanel.class.getResource("/dice1.png"));
	public ImageIcon dice2 = new ImageIcon(DicePanel.class.getResource("/dice2.png"));
	public ImageIcon dice3 = new ImageIcon(DicePanel.class.getResource("/dice3.png"));
	public ImageIcon dice4 = new ImageIcon(DicePanel.class.getResource("/dice4.png"));
	public ImageIcon dice5 = new ImageIcon(DicePanel.class.getResource("/dice5.png"));
	public ImageIcon dice6 = new ImageIcon(DicePanel.class.getResource("/dice6.png"));
	public HashMap<Integer, ImageIcon> dice = new HashMap<Integer, ImageIcon>();
	
	public DicePanel(GameEngineImpl ge) {	
		
		dice.put(1,dice1);
		dice.put(2,dice2);
		dice.put(3,dice3);
		dice.put(4,dice4);
		dice.put(5,dice5);
		dice.put(6,dice6);
	    
	    setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();	    
	    
	    gbc.gridy = 0;
	    gbc.gridx = 1;
	    add(selectPlayer,gbc);
	   
	    gbc.gridy = 1;
	    gbc.gridx = 1;
	    add(pane,gbc);
	   	   
	    gbc.gridy=2;
	    gbc.gridx=0;
	    add(playerLabel,gbc);
	    
	    gbc.gridy=3;
	    gbc.gridx=0;
	    gbc.ipady=10;
	    add(playerdie1,gbc);
	    playerdie1.setIcon(dice6);
	    
	    gbc.gridy=4;
	    gbc.gridx=0;
	    add(playerdie2,gbc);
	    playerdie2.setIcon(dice6);

	    gbc.gridy=2;
	    gbc.gridx=2;
	    gbc.ipady=0;
	    add(houseLabel,gbc);
	    
	    gbc.gridy=3;
	    gbc.gridx=2;
	    add(housedie1,gbc);
	    housedie1.setIcon(dice1);
	    
	    gbc.gridy=4;
	    gbc.gridx=2;
	    add(housedie2,gbc);
	    housedie2.setIcon(dice1);
	    
		setVisible(true);
		add(jp);

	}

}
