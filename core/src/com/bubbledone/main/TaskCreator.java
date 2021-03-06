/**
 * 
 */
package com.bubbledone.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bubbledone.interfaces.GetDate;
import com.bubbledone.screens.BubbleScreen;

public class TaskCreator implements Screen {

	int timeToComplete, dueTime;
	Calendar dueDate;
	String task;

	private String[] bubbleProperties = new String[4];
	private int i = 0;
	private String[] prompts = { "Task", "Time to Completion (minutes)",
			"Due date (MM/DD/YY)", "Due time (HH:MM)" };
	protected BubbleDone parent;
	SimpleDateFormat sdfNums = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
	SimpleDateFormat sdfLetters = new SimpleDateFormat("MMM dd, yyyy HH:mm",
			Locale.US);
	GetDate getDate;
	static int index = 0;
	int[][] positions = {
			{ (int) (BubbleScreen.world.getWidth() - 50),
					(int) (BubbleScreen.world.getHeight() - 50) },
			{ 50, (int) (BubbleScreen.world.getHeight() - 50) },
			{ (int) (BubbleScreen.world.getWidth() - 50), 50 }, { 50, 50 } };

	public TaskCreator(BubbleDone parent, GetDate getDate) {
		this.getDate = getDate;
		this.parent = parent;
		dueDate = new GregorianCalendar();

		Gdx.input.getTextInput(new TextInput(TaskCreator.this), prompts[i],
				"My task");
	}

	public void next(Calendar cal) {
		this.dueDate = cal;
		System.err.println("Got a calendar");
		i++;
		getDate.getDueTime(TaskCreator.this);
	}

	public void next(long time) {
		if (i == 1) {
			i++;
			timeToComplete = (int) time;
			System.err.println("Step 2 finished");
			getDate.getDate(TaskCreator.this);
		} else if (i == 3) {
			System.err.println("Finishing this junk");
			dueDate.set(Calendar.HOUR_OF_DAY, (int) (time / 60));
			dueDate.set(Calendar.MINUTE, (int) (time % 60));
			TaskBubble t = new TaskBubble(new Task(task, dueDate,
					timeToComplete), positions[index][0], positions[index][1], 0);
			index++;
			index %= 4;
			parent.addBubble(t);
			parent.setBubbleScreen();
		}
	}

	public void next(String text) {
		if (i == 0) {
			i++;
			System.err.println("Step 1 finished");
			task = text;
			getDate.getEstimatedDuration(TaskCreator.this);
		} else if (i == 1) {
			if (!text.trim().matches("\\d+")) {
				getDate.getEstimatedDuration(TaskCreator.this);
			} else {
				next(Long.parseLong(text.trim()));
			}
		} else if (i == 2) {
			if (!text.trim().matches("\\d{1,2}/\\d{1,2}/\\d{2,4}")) {
				getDate.getDate(TaskCreator.this);
			} else {
				try {
					dueDate.setTime(sdfNums.parse(text));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				next(dueDate);
			}
		} else if (i == 3) {
			// assert number
			if (!text.trim().matches("\\d{1,2}:\\d{1,2}")) {
				getDate.getDueTime(TaskCreator.this);
			} else {
				String[] arr = text.trim().split(":");
				long hour = Long.parseLong(arr[0]);
				long minute = Long.parseLong(arr[1]);
				next(hour * 60 + minute);
			}
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
