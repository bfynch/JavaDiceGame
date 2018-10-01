package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import javafx.scene.paint.Color;
import model.GameEngineCallbackGUI;
import model.GameEngineCallbackImpl;
import model.GameEngineImpl;
import model.interfaces.GameEngine;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JTabbedPane tabs = new JTabbedPane();
	
	public MainWindow(GameEngineImpl ge) {
		
		setSize(650,650);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StatusBar sb = new StatusBar();
		DicePanel dp = new DicePanel(ge);
		AddPlayerPane addpl = new AddPlayerPane(ge,dp);
		MainMenuBar mb = new MainMenuBar(ge,dp,sb);
		ToolBar toolbar = new ToolBar(ge,dp,sb);
		add(sb,BorderLayout.SOUTH);
		tabs.add("Start Game",dp);
		tabs.add("Add A New Player", addpl);
		add(toolbar,BorderLayout.NORTH);
		add(tabs);
		setJMenuBar(mb);
		ge.addGameEngineCallback(new GameEngineCallbackImpl());
		ge.addGameEngineCallback(new GameEngineCallbackGUI(dp));
		setVisible(true);
	}



	
}
