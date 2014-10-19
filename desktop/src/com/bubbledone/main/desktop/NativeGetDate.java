package com.bubbledone.main.desktop;

import java.util.Calendar;

import com.badlogic.gdx.Gdx;
import com.bubbledone.interfaces.GetDate;
import com.bubbledone.main.TaskCreator;
import com.bubbledone.main.TextInput;

public class NativeGetDate implements GetDate{

	@Override
	public void getDate(TaskCreator taskCreator) {
		Gdx.input.getTextInput(new TextInput(taskCreator), "Due date",
				"10/20/14");
		
	}

	@Override
	public void getEstimatedDuration(TaskCreator taskCreator) {
		Gdx.input.getTextInput(new TextInput(taskCreator), "Estimated time needed",
				"30");
	}

	@Override
	public void getDueTime(TaskCreator taskCreator) {
		Gdx.input.getTextInput(new TextInput(taskCreator), "Due time",
				"12:00");
		
	}

}
