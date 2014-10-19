package com.bubbledone.interfaces;
import java.util.Calendar;

import com.bubbledone.main.TaskCreator;

public interface GetDate {
	public Calendar getDate(TaskCreator taskCreator);
	public long getEstimatedDuration(TaskCreator taskCreator);
	public long getDueTime(TaskCreator taskCreator);
}