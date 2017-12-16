package com.kryp.game;

public class World {
	private FingerMaster fingergame;
	public static boolean player1press = false;
	public static boolean player2press = false;
	public static boolean player1down = false;
	public static boolean player2down = false;
	private Player player1;
	private Player player2;
	private CountingBlock countingblock = new CountingBlock();
	
	World(FingerMaster fingermaster) {
        this.fingergame = fingergame;
        player1 = new Player(250,300);
        player2 = new Player(750,300);
    }
	public CountingBlock getBlock() {
		return countingblock;
	}
	public Player getPlayer1() {
		return player1;
	}
	public Player getPlayer2() {
		return player2;
	}
}
