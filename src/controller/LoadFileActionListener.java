package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.DicePanel;
import view.LoadFileChooser;

public class LoadFileActionListener implements ActionListener{

	private DicePanel dp;
	private GameEngineImpl ge;
	
	public LoadFileActionListener(DicePanel dp, GameEngineImpl ge) {
		this.dp=dp;
		this.ge=ge;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		try {
			new LoadFileChooser(dp,ge);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
