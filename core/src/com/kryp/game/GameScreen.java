package com.kryp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	private FingerMaster fingergame;
	private WorldRenderer worldRenderer;
	World world;
	private Player player1;
	private Player player2;
	private int count = 0;
	private boolean stage_count1 = true;
	private boolean stage_count2 = true;
    public GameScreen(FingerMaster fingergame) {
        this.fingergame = fingergame;
        world = new World(fingergame);
        worldRenderer = new WorldRenderer(fingergame, world);
        player1 = new Player();
        player2 = new Player();
    }
    
    @Override
    public void render(float delta) {
    	if (!(world.player1down && world.player2down)) {
    		update(delta);
    	}
        worldRenderer.render(delta);
    }
    private void update(float delta) {
    	if (Gdx.input.isKeyPressed(Keys.A)) {
    		if (stage_count1) {
    			player1.state_time = count;
    			stage_count1 = false;
    		}
    		world.player1press = true;
        }
    	else if (!Gdx.input.isKeyPressed(Keys.L)) {
    		world.player1press = false;
    		stage_count1 = true;
        }
        if (Gdx.input.isKeyPressed(Keys.L)) {
        	if (stage_count2) {
    			player2.state_time = count;
    			stage_count2 = false;
    		}
        	world.player2press = true;
        }
        else if (!Gdx.input.isKeyPressed(Keys.A)) {
        	world.player2press = false;
        	stage_count2 = true;
        }
        if (world.player1press && world.player2press) {
    		if (player1.state_time < player2.state_time) {
    			world.player1down = true;
    		}
	    	else {
	    		world.player2down = true;
	    	}
    	}
    	else {
    		world.player1down = false;
    		world.player2down = false;
    	}
        count+=1;
        
        System.out.print(world.player1press);
        System.out.print(world.player2press);
        System.out.print(world.player1down);
        System.out.print(world.player2down);
        System.out.print(player1.state_time);
        System.out.print(player2.state_time);
        System.out.println();
    }
    
}
