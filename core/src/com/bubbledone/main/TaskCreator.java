/**
 * 
 */
package com.bubbledone.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class TaskCreator implements Screen {
	
	private String[] bubbleProperties = new String[4];
	private int i = 0;
	private String[] prompts = {
		"Task",
		"Time to Completion (minutes)",
		"Due date (MM/DD/YY)",
		"Due time (HH:MM)"
	};
	private BubbleDone parent;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YY HH:mm", Locale.US);

	public TaskCreator(BubbleDone parent) {
		this.parent = parent;
		
		Gdx.input.getTextInput(new TextInput(TaskCreator.this), "New Task", prompts[i]);
	}

	public void next(String text){
		bubbleProperties[i++] = text;
		if(i >= 4){
			Calendar cal = Calendar.getInstance();
			System.err.println("making task");
			try {
				cal.setTime(sdf.parse(bubbleProperties[2] + " " + bubbleProperties[3]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TaskBubble t = new TaskBubble(new Task(bubbleProperties[0], cal, Long.parseLong(bubbleProperties[1])), 0, 100, 0);
			parent.addBubble(t);
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
