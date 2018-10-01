package model;

import java.util.ArrayList;
import java.util.Random;


import java.util.Collection;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine {
	DicePairImp dpr = new DicePairImp();
	public Collection<Player> players=new ArrayList<Player>();
	private Collection<GameEngineCallback> gamecb=new ArrayList<GameEngineCallback>();
	Random r = new Random();
	private int dice1;
	private int dice2;
	private int housescore;
	private int numfaces;
	public String winner;
	
	@Override
	public boolean placeBet(Player player, int bet) {
		if ( bet < player.getPoints() || bet == player.getPoints())
		{
			player.placeBet(bet);
			return true;
		}
		else {
		return false;}
	}
	//rolls 2 dice and gets a random number between 1 and 6
	public void diceRoll() {
		dice1=r.nextInt(6)+1;
		dice2=r.nextInt(6)+1;
	}
	
	//used in the rolling methods to simulate a dice rolling
	public void sleep(int i)
	{
		try {
		       Thread.sleep(i); 
		    } catch (Exception e) {
		       e.printStackTrace();
		    }
	}
	
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) 
	{		
		for(int i = initialDelay; i<finalDelay; i+=delayIncrement) {
			diceRoll();
			DicePairImp dpr = new DicePairImp(dice1, dice2, numfaces);
			for (GameEngineCallback gameEngineCallback : gamecb) {
				gameEngineCallback.intermediateResult(player, dpr, this);
			}
			sleep(i);
		}
		diceRoll();
		DicePairImp dpr = new DicePairImp(dice1, dice2, numfaces);
		player.setRollResult(dpr);
		for (GameEngineCallback gameEngineCallback : gamecb) {
			gameEngineCallback.result(player, dpr, this);}	
		}
	
	//iterates through the array to determine winners and settles bets
	public void getWinner()
	{
		int playerscore;
		for(Player player: players) {
			DicePairImp dpw = (DicePairImp) player.getRollResult();
			
			if(dpw!=null) {
				playerscore=dpw.getDice1()+dpw.getDice2();
				int bet=player.getBet();
				int points=player.getPoints();
	
			if (housescore > playerscore)
				{
				player.setPoints(points-bet);
				winner="House wins! " +bet+ " points removed from "+player.getPlayerName();
				}
		
			else if(housescore == playerscore) {
				winner="It's a draw!";
				}
			
			else {
				player.setPoints(points+bet);
				winner=player.getPlayerName()+" wins! "+bet+" points added.";
					}
				}
		 	}
		}
	
	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) 
	{		
		for(int i = initialDelay; i<finalDelay; i+=delayIncrement) {
			diceRoll();
			DicePairImp dpr = new DicePairImp(dice1, dice2, numfaces);
			for (GameEngineCallback gameEngineCallback : gamecb) {
				gameEngineCallback.intermediateHouseResult(dpr, this);
			}
			sleep(i);
		}
		diceRoll();
		DicePairImp dpr = new DicePairImp(dice1, dice2, numfaces);
		housescore=dpr.getDice1()+dpr.getDice2();
		getWinner();
		for (GameEngineCallback gameEngineCallback : gamecb) {
			gameEngineCallback.houseResult(dpr, this);}
		//getWinner();
		getAllPlayers();
		}
	
	@Override
	public void addPlayer(Player player) {
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for(Player player: players)
			{
			if(id==player.getPlayerId()) 
			{
				return player;
				}
			}
			return null;}
		
	@Override
	public boolean removePlayer(Player player) {
		if(players.contains(player)) {
		players.remove(player);
		return true;}
		else {
	 return false;}}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gamecb.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if(gamecb.contains(gameEngineCallback)) {
			gamecb.remove(gameEngineCallback);
			return true;}
			else {
		 return false;}}
	
	@Override
	 public Collection<Player> getAllPlayers() {
		  for(int i=0; i < players.size(); i++) 
		  System.out.println(((ArrayList<Player>) players).get(i));
		  return null;
		  }
	
	}
