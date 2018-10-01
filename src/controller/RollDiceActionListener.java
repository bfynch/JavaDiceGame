package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.DicePair;
import view.DicePanel;
import view.StatusBar;
import view.ToolBar;

public class RollDiceActionListener implements ActionListener{

	private GameEngineImpl ge;
	private DicePanel dp;
	private StatusBar sb;
	
	public RollDiceActionListener(GameEngineImpl ge, DicePanel dp, StatusBar sb) {
		this.ge=ge;
		this.dp=dp;
		this.sb=sb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) throws NullPointerException{
	
		final SimplePlayer player = dp.list.getSelectedValue();
	
		//shows a warning message if player tries to roll without a player selected 
		if(player==null) {
			sb.warningLabel.setText("Select a player before rolling");
			throw new NullPointerException("Select a player before rolling");
		}
		
		//shows a warning message if player tries to roll without setting a bet 
		if(player.getBet()==0) {
			sb.warningLabel.setText("Place bet before rolling");
		}
		else {
		new Thread() {
			@Override
			public void run() {
				//clears the warning label, rolls dice for player and house, resets player bet to 0 and updates and ui 
				sb.warningLabel.setText("");
				sb.statusLabel.setText("Rolling for "+player.getPlayerName());
				ge.rollPlayer(player, 1, 1000, 100);
				sb.statusLabel.setText("Rolling for house");
				ge.rollHouse(1, 1000, 100);
				player.placeBet(0);
				sb.statusLabel.setText(ge.winner);
				dp.list.updateUI();
				//erases player roll result to not interfere with getWinner method 
				player.setRollResult(null);
				}
			}.start();
			
			}
		}
	}


