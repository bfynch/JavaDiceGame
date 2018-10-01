package view;
import javax.swing.JFrame;
import model.GameEngineImpl;
import model.interfaces.GameEngine;

public class RunApp extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public RunApp() {
	}
	
	public static void main(String[] args) {
		GameEngineImpl ge = new GameEngineImpl();
		new MainWindow(ge);
	}
}
