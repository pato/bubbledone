package com.bubbledone.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bubbledone.interfaces.GetDate;
import com.bubbledone.screens.BubbleScreen;

public class BubbleDone extends Game {
	
	protected BubbleScreen bubbles;
	private TaskCreator tasks;
	
	private GetDate getDate;
	
	public BubbleDone(GetDate getDate) {
		this.getDate = getDate;
	}
	
	public GetDate getDateImplementation() {
		return getDate;
	}

	@Override
	public void create() {
		bubbles = new BubbleScreen(BubbleDone.this);
		setBubbleScreen();
	}
	
	public void setBubbleScreen(){
		setScreen(bubbles);
		Gdx.input.setInputProcessor(new InputHandler(bubbles.world, bubbles.renderer.cam));
	}
	
	public void setTaskScreen(){
		setScreen(new TaskCreator(BubbleDone.this, getDate));
	}
	
	@Override
	public void dispose() {
		bubbles.dispose();
		//tasks.dispose();
	}
	
	public void addBubble(TaskBubble bub){
		bubbles.addTaskBubble(bub);
	}
}
