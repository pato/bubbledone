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

public class TaskCreator implements Screen {

	int timeToComplete, dueTime;
	Calendar dueDate;
	String task;

	private String[] bubbleProperties = new String[4];
	private int i = 0;
	private String[] prompts = { "Task", "Time to Completion (minutes)",
			"Due date (MM/DD/YY)", "Due time (HH:MM)" };
	protected BubbleDone parent;
	SimpleDateFormat sdfNums = new SimpleDateFormat("MM/dd/yyyy HH:mm",
			Locale.US);
	SimpleDateFormat sdfLetters = new SimpleDateFormat("MMM dd, yyyy HH:mm",
			Locale.US);

	public TaskCreator(BubbleDone parent) {
		this.parent = parent;

		Gdx.input.getTextInput(new TextInput(TaskCreator.this), prompts[i],
				"My task");
	}

	public void next(Calendar cal) {
		this.dueDate = cal;
		i++;
		Gdx.input.getTextInput(new TextInput(TaskCreator.this), prompts[i],
				"12:00");
	}

	public void next(long time) {
		if (i == 1) {
			i++;
			timeToComplete = (int) time;
			Gdx.input.getTextInput(new TextInput(TaskCreator.this), prompts[i],
					"10/20/14");
		}
		if (i == 3) {
			dueDate.set(Calendar.HOUR_OF_DAY, (int) (time / 60));
			dueDate.set(Calendar.MINUTE, (int) (time % 60));
			TaskBubble t = new TaskBubble(new Task(bubbleProperties[0],
					dueDate, timeToComplete), 0, 100, 0);
			parent.addBubble(t);
			parent.setBubbleScreen();
		}
	}

	public void next(String text) {
		if(i == 0){
			i++;
			Gdx.input.getTextInput(new TextInput(TaskCreator.this), prompts[i],
					"30");
		}
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
