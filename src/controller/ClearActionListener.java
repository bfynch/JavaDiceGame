package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddPlayerPane;

public class ClearActionListener implements ActionListener {
	
	private AddPlayerPane ap;
	
	public ClearActionListener(AddPlayerPane ap) {	
	this.ap=ap;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	//clears all of the fields in the add player pane
		ap.enterPlayerName.setText("");
		ap.enterPlayerID.setText("");
		ap.enterPoints.setText("");
		ap.allPlayers.setText("");
	}

}
