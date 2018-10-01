package model;

import model.interfaces.DicePair;

public class DicePairImp implements DicePair {

	private int dice1;
	private int dice2;
	private int numfaces;
	
	public DicePairImp() {}
	
	public DicePairImp(int dice1, int dice2, int numFaces) {
		this.dice1=dice1;
		this.dice2=dice2;
	}
	
	
	@Override
	public int getDice1() {
		return dice1;
	}

	@Override
	public int getDice2() {
		return dice2;
	}

	@Override
	public int getNumFaces() {
		return numfaces;
	}

}
