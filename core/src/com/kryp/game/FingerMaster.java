package com.kryp.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FingerMaster extends Game {
	SpriteBatch batch;
	public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
	 
    @Override
    public void create () {
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));
    }
 
    @Override
    public void render () {
        super.render();
    }
 
    @Override
    public void dispose () {
        batch.dispose();
    }
}
