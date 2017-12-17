package com.kryp.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Player {
	public static int count = 0;
	Random random = new Random();
	public int state_time;
	private int x;
	private int y;
	private int score;
	
	public Player(int x, int y) {
		this.state_time = 0;
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getScore() {
		return score;
	}
	public void plusScore() {
		score++;
	}
	public void clearScore() {
		score = 0;
	}
}
