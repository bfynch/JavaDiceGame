package model;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackImpl implements GameEngineCallback
{
	private Logger logger = Logger.getLogger("assignment1");
	
	public GameEngineCallbackImpl()
	{
		// FINE shows rolling output, INFO only shows result
		logger.setLevel(Level.FINE);
		Logger.getGlobal().getParent().getHandlers()[0].setLevel(Level.FINE);
	}

	public void houseResult(DicePair result, GameEngine gameEngine) {
		
		logger.log(Level.FINE, " House: *RESULT* Dice 1: "+result.getDice1()+", Dice 2: "+result.getDice2()+ " .. Total: "+(result.getDice1()+result.getDice2()));
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine)
	{
		logger.log(Level.FINE, player.getPlayerName() + ": ROLLING Dice 1: " + dicePair.getDice1() + ", Dice 2: " + dicePair.getDice2() +  " .. Total: " +(dicePair.getDice1()+dicePair.getDice2()));		
	}

	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine)
	{
		logger.log(Level.FINE, "House: ROLLING Dice 1: " + dicePair.getDice1() + ", Dice 2: " + dicePair.getDice2() + " .. Total: "+(dicePair.getDice1()+dicePair.getDice2()));
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine)
	{
		logger.log(Level.INFO, player.getPlayerName() + ": *RESULT* Dice 1: "+result.getDice1()+" Dice 2: " +result.getDice2()+" .. Total: "+(result.getDice1()+result.getDice2())+"\n" +
		 gameEngine.getAllPlayers());
	
	}

}
