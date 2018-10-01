package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngineImpl;
import model.SimplePlayer;
import view.AddPlayerPane;
import view.DicePanel;

public class NewPlayerActionListener implements ActionListener{
	
	private GameEngineImpl ge;
	private DicePanel dp;
	private AddPlayerPane ap;
	
	public NewPlayerActionListener(GameEngineImpl ge, DicePanel dp, AddPlayerPane ap) {
		this.ge=ge;
		this.dp=dp;
		this.ap=ap;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = ap.enterPlayerName.getText();
		String id = ap.enterPlayerID.getText();
		int points = Integer.parseInt(ap.enterPoints.getText());
		SimplePlayer sp = new SimplePlayer(name, id, points);
		ge.players.add(sp);
		ap.enterPlayerName.setText("");
		ap.enterPlayerID.setText("");
		ap.enterPoints.setText("");
		ap.allPlayers.setText(name + " added to the game!");
		dp.model.addElement(sp);

	}

}
