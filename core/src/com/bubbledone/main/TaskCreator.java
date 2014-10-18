/**
 * 
 */
package com.bubbledone.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class TaskCreator implements Screen {
	
	private String[] bubbleProperties = new String[3];
	private int i = 0;
	private String[] prompts = {
		"Task",
		"Time to Completion (minutes)",
		"Due date"
	};
	private BubbleDone parent;

	public TaskCreator(BubbleDone parent) {
		this.parent = parent;
		Gdx.input.getTextInput(new TextInput(TaskCreator.this), "New Task", prompts[i]);
	}

	public void next(String text){
		bubbleProperties[i++] = text;
		if(i >= 3){
			parent.setBubbleScreen();
			return;
		}
		Gdx.input.getTextInput(new TextInput(TaskCreator.this), "New Task", prompts[i]);
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
	
}
