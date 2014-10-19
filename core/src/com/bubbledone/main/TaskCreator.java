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
	private String[] prompts = { "Task", "Time to Completion (minutes)",
			"Due date (MM/DD/YY)", "Due time (HH:MM)" };
	protected BubbleDone parent;
	SimpleDateFormat sdfNums = new SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.US);
	SimpleDateFormat sdfLetters = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.US);

	public TaskCreator(BubbleDone parent) {
		this.parent = parent;

		Gdx.input.getTextInput(new TextInput(TaskCreator.this), "New Task",
				prompts[i]);
	}

	public void next(String text) {
		if (i == 1) {
			if (!text.trim().matches("\\d+")) {
				Gdx.input.getTextInput(new TextInput(TaskCreator.this),
						"New Task", prompts[i]);
			}
		} else if (i == 2) {
			if (text.trim().matches("\\d{1,2}/\\d{1,2}/\\d{2,4}")) {
				
			} else if(text.trim().matches("\\w{3,4}\\s+\\d{1,2},\\s+\\d{2,4}")){
				
			} else {
				Gdx.input.getTextInput(new TextInput(TaskCreator.this),
						"New Task", prompts[i]);
			}
		} else if (i == 3) {
			if (!text.trim().matches("\\d{1,2}:\\d{2}")) {
				Gdx.input.getTextInput(new TextInput(TaskCreator.this),
						"New Task", prompts[i]);
			}
		}
		bubbleProperties[i++] = text;
		if (i >= 4) {
			Calendar cal = Calendar.getInstance();
			System.err.println("making task");
			try {
				if (bubbleProperties[2].trim().matches("\\d{1,2}/\\d{1,2}/\\d{2,4}")) {
					cal.setTime(sdfNums.parse(bubbleProperties[2] + " "
							+ bubbleProperties[3]));	
				} else if(bubbleProperties[2].trim().matches("\\w{3,4}\\s+\\d{1,2},\\s+\\d{2,4}")){
					cal.setTime(sdfLetters.parse(bubbleProperties[2] + " "
							+ bubbleProperties[3]));
				}
				TaskBubble t = new TaskBubble(new Task(bubbleProperties[0],
						cal, Long.parseLong(bubbleProperties[1])), 0, 100, 0);
				parent.addBubble(t);
				parent.setBubbleScreen();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return;
		}

		Gdx.input.getTextInput(new TextInput(TaskCreator.this), "New Task",
				prompts[i]);
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
