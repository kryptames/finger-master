package com.kryp.game;

public class GameOver {
	private boolean stage = false;
	private int winner;
	private FingerMaster fingermaster;
	
	public GameOver(FingerMaster fingergame) {
		this.fingermaster = fingermaster;
	}
	
	public void changeStage(boolean stage_change) {
		stage = stage_change;
	}
	public boolean getStage() {
		return stage ;
	}
	public int winner(int win) {
		return winner = win;
	}
	public int getWinner() {
		return winner;
	}
	public void clearWinner() {
		winner = 0;
	}
}
