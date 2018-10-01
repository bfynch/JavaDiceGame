package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngineImpl;
import model.SimplePlayer;
import view.DicePanel;
import view.StatusBar;
import view.ToolBar;

public class BetActionListener implements ActionListener{

	private GameEngineImpl ge;
	private ToolBar tb;
	private DicePanel dp;
	private StatusBar sb;
	
	public BetActionListener(GameEngineImpl ge, DicePanel dp, ToolBar tb, StatusBar sb) {
		this.ge=ge;
		this.dp=dp;
		this.tb=tb;
		this.sb=sb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int bet = Integer.parseInt(tb.betField.getText());
		SimplePlayer player = dp.list.getSelectedValue();
		
		//shows confirmation for the bet in the status bar and clears the warning message
		if(ge.placeBet(player,bet))
		{
			sb.statusLabel.setText(player.getPlayerName()+" bet "+player.getBet()+" points");
			sb.warningLabel.setText("");
			
		}
		//shows a warning message if the player tries to bet more than their points
		else
		{
			sb.warningLabel.setText("Invalid bet - try again");
		}
		dp.list.updateUI();
	}

}

