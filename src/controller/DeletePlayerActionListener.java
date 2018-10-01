package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngineImpl;
import model.SimplePlayer;
import view.DicePanel;

public class DeletePlayerActionListener implements ActionListener{

	public DeletePlayerActionListener(GameEngineImpl ge, DicePanel dp) {
		this.ge=ge;
		this.dp=dp;
	}
	
	private GameEngineImpl ge;
	private DicePanel dp;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//gets the selected player from the model and deletes them from the game
		SimplePlayer player = dp.list.getSelectedValue();
		ge.removePlayer(player);
		dp.model.removeElement(player);
		dp.list.updateUI();
	}

}