package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Dialog;

public class AboutActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new Dialog();
	}

}
