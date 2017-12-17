package com.kryp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	private FingerMaster fingergame;
	World world;
	private WorldRenderer worldRenderer;
	GameOver gameover;
	private GameOverRenderer gameoverRenderer;
	
	private int count = 0;
	private int count_delta = 0;
	private int number;
	private boolean iskeypressed = false;
	private boolean stage_count1 = true;
	private boolean stage_count2 = true;
    public GameScreen(FingerMaster fingergame) {
        this.fingergame = fingergame;
        world = new World(fingergame);
        worldRenderer = new WorldRenderer(fingergame, world);
        gameover = new GameOver(fingergame);
        gameoverRenderer = new GameOverRenderer(fingergame, gameover);
        
    }
    
    @Override
    public void render(float delta) {
		if (gameover.getStage()) {
			gameoverRenderer.render(delta);
		}
		else {
			update(delta);
			worldRenderer.render(delta);
		}
    }
    private void update(float delta) {
    	if (!(world.player1down || world.player2down)) {
	    	if (Gdx.input.isKeyPressed(Keys.A)) {
	    		if (stage_count1) {
	    			world.getPlayer1().state_time = count;
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
	    			world.getPlayer2().state_time = count;
	    			stage_count2 = false;
	    		}
	        	world.player2press = true;
	        }
	        else if (!Gdx.input.isKeyPressed(Keys.A)) {
	        	world.player2press = false;
	        	stage_count2 = true;
	        }
	        if (world.player1press && world.player2press) {
	    		if (world.getPlayer1().state_time < world.getPlayer2().state_time) {
	    			world.player1down = true;
	    		}
		    	else {
		    		world.player2down = true;
		    	}
	    	}
	        count++;
    	}
    	else {
    		if (worldRenderer.count_delta == 0) {
    			world.getBlock().randomNumber();
    		}
    		if (worldRenderer.count_delta < 300) {
	    		if (world.player1down) {
	    			world.getBlock().x = world.getPlayer1().getX();
	    			world.getBlock().y = world.getPlayer1().getY();
		    		if (Gdx.input.isKeyPressed(Keys.A)) {
		    			if (!iskeypressed) {
		    				world.getBlock().pressed();
		    				iskeypressed = true;
		    			}
		    		}
		    		else {
		    			iskeypressed = false;
		    		}
	    		}
	    		else if (world.player2down) {
	    			world.getBlock().x = world.getPlayer2().getX();
	    			world.getBlock().y = world.getPlayer2().getY();
		    		if (Gdx.input.isKeyPressed(Keys.L)) {
		    			if (!iskeypressed) {
		    				world.getBlock().pressed();
		    				iskeypressed = true;
		    			}
		    		}
		    		else {
		    			iskeypressed = false;
		    		}
		    	}
	    		
	    		if (world.getBlock().number <= 0) {
	    			clearStage();
	    		}
    		}
    		else {
    			if (world.player1down) {
    				world.getPlayer2().plusScore();
    				world.winnerStage[world.round] = 2;
    			}
    			else if (world.player2down) {
    				world.getPlayer1().plusScore();
    				world.winnerStage[world.round] = 1;
    			}
    			
    			world.nextRound();
    			clearStage();
    		}
    		worldRenderer.count_delta++;
    	}
    	if (world.round == 4 || (world.round == 3 && (world.getPlayer1().getScore() > 1 || world.getPlayer2().getScore() > 1))) {
			gameover.changeStage(true);
			if (world.getPlayer1().getScore() > world.getPlayer2().getScore()) {
				gameover.winner(1);
			}
			else {
				gameover.winner(2);
			}
			clearStage();
			clearScore();
			world.round = 1;
		}
    	System.out.print(world.getPlayer1().getScore());
    	System.out.print(world.getPlayer2().getScore());
    	System.out.print(" ");
    	System.out.print(world.round);
    	System.out.println();
    	
    }
    
    public void clearStage() {
    	world.player1down = false;
		world.player2down = false;
		world.player1press = false;
		world.player2press = false;
		worldRenderer.count_delta = -1;
		count = 0;
    }
    public void clearScore() {
    	world.getPlayer1().clearScore();
    	world.getPlayer2().clearScore();
    }
}
