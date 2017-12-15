package com.kryp.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Player {
	public static int count = 0;
	Random random = new Random();
	public int state_time;
	public Player() {
		this.state_time = 0;
	}
	private void getRandomInt() {
		count = random.nextInt(50) + 30;
	}
	
}
