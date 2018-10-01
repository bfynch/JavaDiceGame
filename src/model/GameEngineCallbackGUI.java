package model;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import view.DicePanel;

public class GameEngineCallbackGUI implements GameEngineCallback {
	
	public GameEngineCallbackGUI(DicePanel dp) {
		this.dp=dp;		
	}
	
	DicePanel dp;
	
	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		int d1 = dicePair.getDice1();
		dp.playerdie1.setIcon(dp.dice.get(d1));
		
		int d2 = dicePair.getDice2();
		dp.playerdie2.setIcon(dp.dice.get(d2));
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		int d1 = result.getDice1();
		dp.playerdie1.setIcon(dp.dice.get(d1));
		
		int d2 = result.getDice2();
		dp.playerdie2.setIcon(dp.dice.get(d2));	
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		int d1 = dicePair.getDice1();
		dp.housedie1.setIcon(dp.dice.get(d1));
		
		int d2 = dicePair.getDice2();
		dp.housedie2.setIcon(dp.dice.get(d2));	
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		int d1 = result.getDice1();
		dp.housedie1.setIcon(dp.dice.get(d1));
		
		int d2 = result.getDice2();
		dp.housedie2.setIcon(dp.dice.get(d2));
	}
	
}
