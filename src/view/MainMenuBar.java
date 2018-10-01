package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controller.AboutActionListener;
import controller.ExitActionListener;
import controller.LoadFileActionListener;
import controller.RollDiceActionListener;
import controller.SaveFileActionListener;
import model.GameEngineImpl;
import model.interfaces.GameEngine;

public class MainMenuBar extends JMenuBar{

	private static final long serialVersionUID = 1783930343661379497L;
	public JMenuBar menuBar = new JMenuBar();
	public JMenu fileMenu = new JMenu("File");
	public JMenuItem saveGame = new JMenuItem("Save Game");
	public JMenuItem loadGame = new JMenuItem("Load Game");
	public JMenuItem about = new JMenuItem("About");
	public JMenuItem exit = new JMenuItem("Exit");
	public JMenu gameMenu = new JMenu("Game");
	public JMenuItem roll = new JMenuItem("Roll");

	public MainMenuBar(GameEngineImpl ge, DicePanel dp, StatusBar sb) {
		add(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(gameMenu);
		fileMenu.add(saveGame);
		fileMenu.add(loadGame);
		fileMenu.add(about);
		fileMenu.add(exit);
		gameMenu.add(roll);
		setVisible(true);
		saveGame.addActionListener(new SaveFileActionListener(ge));
		loadGame.addActionListener(new LoadFileActionListener(dp,ge));
		about.addActionListener(new AboutActionListener());
		exit.addActionListener(new ExitActionListener());
		roll.addActionListener(new RollDiceActionListener(ge,dp,sb));
		
	}
}
