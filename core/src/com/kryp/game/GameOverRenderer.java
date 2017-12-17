package com.kryp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverRenderer {
	private FingerMaster fingergame;
	GameOver gameover;
	private Texture imgGreen;
	private Texture imgRed;
	SpriteBatch batch;
	BitmapFont font = new BitmapFont();

	public GameOverRenderer(FingerMaster fingergame, GameOver gameover) {
        this.fingergame = fingergame;
        batch = fingergame.batch;
        this.gameover = gameover;
        imgGreen = new Texture("win_green.png");
        imgRed = new Texture("win_red.png");
        font = new BitmapFont(Gdx.files.internal("font_over.fnt"),Gdx.files.internal("font_over.png"),false);
    }
	
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Winner is ...", FingerMaster.WIDTH/2 - 150, FingerMaster.HEIGHT - 100);
        font.draw(batch, "Press SPACE to play again.", FingerMaster.WIDTH/2 - 300, 100);
        if (gameover.getWinner() == 1) {
        	batch.draw(imgGreen, fingergame.WIDTH/2 - 112, fingergame.HEIGHT/2 - 100, 225, 200);
        }
        else if (gameover.getWinner() == 2) {
        	batch.draw(imgRed, fingergame.WIDTH/2 - 112, fingergame.HEIGHT/2 - 100, 225, 200);
        }
        batch.end();
	}
}
