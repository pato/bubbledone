package com.bubbledone.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bubbledone.screens.BubbleScreen;

public class BubbleDone extends Game {
	
	private BubbleScreen bubbles;
	private TaskCreator tasks;

	@Override
	public void create() {
		bubbles = new BubbleScreen(BubbleDone.this);
		setBubbleScreen();
	}
	
	public void setBubbleScreen(){
		setScreen(bubbles);
	}
	
	public void setTaskScreen(){
		setScreen(new TaskCreator(BubbleDone.this));
	}
	
	@Override
	public void dispose() {
	}
}
