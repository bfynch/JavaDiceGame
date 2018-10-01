package view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.BetActionListener;
import controller.DeletePlayerActionListener;
import controller.LoadFileActionListener;
import controller.RollDiceActionListener;
import controller.SaveFileActionListener;
import model.GameEngineImpl;
import model.interfaces.GameEngine;

public class ToolBar extends JPanel

{
	private static final long serialVersionUID = 1L;
	public ImageIcon saveicon = new ImageIcon(ToolBar.class.getResource("/saveicon.png"));
	public ImageIcon loadicon = new ImageIcon(ToolBar.class.getResource("/load.png"));
	public ImageIcon delIcon = new ImageIcon(ToolBar.class.getResource("/del.png"));
	public ImageIcon betIcon = new ImageIcon(ToolBar.class.getResource("/chip.png"));
	public ImageIcon rollIcon = new ImageIcon(ToolBar.class.getResource("/roll.png"));
	public JToolBar toolbar = new JToolBar();
	public JButton load = new JButton(loadicon);
	public JButton save = new JButton(saveicon);
	public JButton delete = new JButton(delIcon);
	public JButton roll = new JButton(rollIcon);
	public JButton bet = new JButton(betIcon);
	public JTextField betField = new JTextField("",7);
	
	public ToolBar(GameEngineImpl ge, DicePanel dp, StatusBar sb) {
		add(toolbar);
		toolbar.setLayout(new FlowLayout());
		toolbar.setAlignmentY(LEFT_ALIGNMENT);
		toolbar.add(save);
		save.setToolTipText("Save Game");
		toolbar.add(load);
		load.setToolTipText("Load Game");
		toolbar.add(delete);
		delete.setToolTipText("Delete selected player");
		toolbar.add(bet);
		bet.setToolTipText("Place bet for selected player");
		toolbar.add(betField);
		betField.setSize(50, 35);
		toolbar.add(roll);
		roll.setToolTipText("Roll the dice!");
		load.addActionListener(new LoadFileActionListener(dp,ge));
		save.addActionListener(new SaveFileActionListener(ge));
		delete.addActionListener(new DeletePlayerActionListener(ge,dp));
		bet.addActionListener(new BetActionListener(ge,dp,this,sb));
		roll.addActionListener(new RollDiceActionListener(ge,dp,sb));
		setVisible(true);
	
	}

}
