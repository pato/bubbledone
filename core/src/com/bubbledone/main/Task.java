package com.bubbledone.main;

import java.util.Calendar;

public class Task {
	private boolean isComplete;
	private float priority;
	private long estimatedTimeToCompletion; // minutes
	private Calendar dueDate;
	private String name;
	private String notes;

	public Task(String name, Calendar dueDate) {
		this.name = name;
		this.dueDate = dueDate;
		this.estimatedTimeToCompletion = 15;
		this.isComplete = false;
		this.priority = calcPriority(dueDate);
		this.notes = "";
	}
	
	private float calcPriority(Calendar dueDate2) {
		double time = Math.abs(dueDate2.getTimeInMillis() - Calendar.getInstance().getTimeInMillis());
		if(time > 1209600000){
			time = 1209600000;
		}
		System.err.println(time);
		float a = (float) Math.min(estimatedTimeToCompletion / time, 1.);
		a = (float) Math.max(a, 0.);
		a = (float) Math.pow(a, 0.075);
		float answer = (float) Math.pow((5 + 15.0 * a), 1);
		System.err.println(answer);
		return answer;
	}

	public Task(String name, Calendar dueDate, long timeNeeded) {
		this.name = name;
		this.dueDate = dueDate;
		this.estimatedTimeToCompletion = timeNeeded;
		this.isComplete = false;
		this.priority = calcPriority(dueDate);
		this.notes = "";
	}


	public long getEstimatedTimeToCompletion() {
		return estimatedTimeToCompletion;
	}

	public void setEstimatedTimeToCompletion(long estimatedTimeToCompletion) {
		this.estimatedTimeToCompletion = estimatedTimeToCompletion;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		if (!notes.equals(""))
			this.notes = notes;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.equals(""))
			this.name = name;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public float getPriority() {
		return priority;
	}

	public void setPriority(float priority) {
		this.priority = priority;
	}

	public void resetPriority() {
		this.setPriority(1.0f);
	}
}
