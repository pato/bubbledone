package com.bubbledone.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
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
		BubbleWorld world = bubbles.world;
		OrthographicCamera cam = bubbles.renderer.cam;
		
		TouchHandler touchHandler = new TouchHandler(world, cam);

		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(new GestureDetector(touchHandler));
		multiplexer.addProcessor(new InputHandler(world, cam));
		Gdx.input.setInputProcessor(multiplexer);
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
