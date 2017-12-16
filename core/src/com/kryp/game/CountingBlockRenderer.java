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
	private Texture img;
	
	public CountingBlockRenderer(SpriteBatch batch, CountingBlock countingblock) {
		this.batch = batch;
		this.countingblock = countingblock;
		img = new Texture("block.PNG");
		font = new BitmapFont(Gdx.files.internal("font.fnt"),Gdx.files.internal("font.png"),false);
		
	}
	public void render(float delta) {
        batch.draw(img, countingblock.getX()-125, countingblock.getY()-125, CountingBlock.WIDTH, CountingBlock.HEIGHT);
        font.draw(batch, Integer.toString(countingblock.number), countingblock.getX()-50, countingblock.getY()+25);
        
    }
}
