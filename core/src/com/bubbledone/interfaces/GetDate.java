package com.bubbledone.interfaces;
import java.util.Calendar;

import com.bubbledone.main.TaskCreator;

public interface GetDate {
	public void getDate(TaskCreator taskCreator);
	public void getEstimatedDuration(TaskCreator taskCreator);
	public void getDueTime(TaskCreator taskCreator);
}