package com.kryp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverRenderer {
	private FingerMaster fingergame;
	GameOver gameover;
	private Texture img;
	SpriteBatch batch;

	public GameOverRenderer(FingerMaster fingergame, GameOver gameover) {
        this.fingergame = fingergame;
        SpriteBatch batch = fingergame.batch;
        this.gameover = gameover;
        img = new Texture("default.PNG");
    }
	
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.end();
	}
}
