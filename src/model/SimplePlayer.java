package model;

import java.io.Serializable;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player, Serializable{

	protected int bet;
	public String playerName;
	protected String playerID;
	protected int points;
	private DicePair rollResult;
	protected int playerscore;
	
	public SimplePlayer() {}
	
	public SimplePlayer(String playerName, String playerID, int points)
	{
		this.playerName=playerName;
		this.playerID=playerID;
		this.points=points;
	}
	
	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName=playerName;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points=points;
	}

	@Override
	public String getPlayerId() {
		return playerID;
	}

	@Override
	public boolean placeBet(int bet) {
		if (bet < points || bet == points)
		{
			this.bet=bet;
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getBet() {
		return bet;
	}

	@Override
	public DicePair getRollResult() {

		return rollResult;
	}

	@Override
	public void setRollResult(DicePair rollResult)
	{
		this.rollResult=rollResult;
	}

	@Override
	public String toString() {
		return "Player Name: " + playerName + "\nPlayer ID: " + playerID + "\nBet: " + bet + "\nPoints: "
				+ points + "\n";
	}

}
