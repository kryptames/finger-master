package com.kryp.game;

import java.util.Random;

public class CountingBlock {
	Random r = new Random();
	public static final int HEIGHT = 250;
	public static final int WIDTH = 250;
	public int number;
	public int x;
	public int y;
	public CountingBlock() {
	}
	public void randomNumber() {
		number = (r.nextInt(30) + 20);
	}
	public void pressed() {
		number -=1;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
