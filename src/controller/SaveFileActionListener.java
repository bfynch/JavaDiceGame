package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngineImpl;
import view.SaveFileChooser;

public class SaveFileActionListener implements ActionListener{

	private GameEngineImpl ge;
	
	public SaveFileActionListener(GameEngineImpl ge) {
		this.ge=ge;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		new SaveFileChooser(ge);
		
	}

	
	
}
