package com.kryp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private FingerMaster fingergame;
	private WorldRenderer worldRenderer;
	World world;
	CountingBlockRenderer countingblockrenderer;
	SpriteBatch batch;
	private Texture img;
	private Texture bg;
	private Texture imgPlayer1Pressed;
	private Texture imgPlayer1Down;
	private Texture imgPlayer2Pressed;
	private Texture imgPlayer2Down;
	BitmapFont font_time = new BitmapFont();
	public int count_delta = 0;
	
	public WorldRenderer(FingerMaster fingergame, World world) {
        this.fingergame = fingergame;
        batch = fingergame.batch;
        this.world = world;
        img = new Texture("default.PNG");
        imgPlayer1Pressed = new Texture("Player1Pressed.PNG");
        imgPlayer1Down = new Texture("Player1Down.PNG");
        imgPlayer2Pressed = new Texture("Player2Pressed.PNG");
        imgPlayer2Down = new Texture("Player2Down.PNG");
        countingblockrenderer = new CountingBlockRenderer(fingergame.batch,world.getBlock());
        font_time = new BitmapFont(Gdx.files.internal("font_time.fnt"),Gdx.files.internal("font_time.png"),false);
    }

	public void render(float delta) {
    	Gdx.gl.glClearColor(247/255f, 255/255f, 131/255f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        
        if (world.player1down) {
        	batch.draw(imgPlayer1Down, 0, 0, fingergame.WIDTH, fingergame.HEIGHT);
        }
        else if (world.player2down) {
        	batch.draw(imgPlayer2Down, 0, 0, fingergame.WIDTH, fingergame.HEIGHT);
        }
        else if (world.player1press) {
        	batch.draw(imgPlayer1Pressed, 0, 0, fingergame.WIDTH, fingergame.HEIGHT);
        }
        else if (world.player2press) {
        	batch.draw(imgPlayer2Pressed, 0, 0, fingergame.WIDTH, fingergame.HEIGHT);
        }
        else {
        	batch.draw(img, 0, 0, fingergame.WIDTH, fingergame.HEIGHT);
        }
        if (world.player1down || world.player2down) {
        	countingblockrenderer.render(delta);
        	font_time.draw(batch, Integer.toString((int)count_delta/100), FingerMaster.WIDTH/2, FingerMaster.HEIGHT-10);
        }
        batch.end();
    }
}