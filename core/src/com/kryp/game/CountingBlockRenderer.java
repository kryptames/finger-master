package com.kryp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CountingBlockRenderer {
	BitmapFont font = new BitmapFont();
	
	public CountingBlock countingblock;
	private SpriteBatch batch;
	private Texture imgRed;
	private Texture imgGreen;
	
	public CountingBlockRenderer(SpriteBatch batch, CountingBlock countingblock) {
		this.batch = batch;
		this.countingblock = countingblock;
		imgRed = new Texture("block_red.PNG");
		imgGreen = new Texture("block_green.png");
		font = new BitmapFont(Gdx.files.internal("font.fnt"),Gdx.files.internal("font.png"),false);
		
	}
	public void render(float delta) {
		if (countingblock.getX() > FingerMaster.WIDTH / 2) {
			batch.draw(imgRed, countingblock.getX()-125, countingblock.getY()-125, CountingBlock.WIDTH, CountingBlock.HEIGHT);
		}
		else {
			batch.draw(imgGreen, countingblock.getX()-125, countingblock.getY()-125, CountingBlock.WIDTH, CountingBlock.HEIGHT);
		}
        font.draw(batch, Integer.toString(countingblock.number), countingblock.getX()-70, countingblock.getY()+40);
        
    }
}
