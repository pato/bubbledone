package com.bubbledone.main;

import java.util.Calendar;

public class Task {
	private boolean isComplete;
	private float priority;
	Calendar dueDate;
	String name;
	
	String notes;
	
	public Task(String name, Calendar dueDate) {
		this.name = name;
		this.dueDate = dueDate;
		isComplete = false;
		priority = 1.0f;
		notes = "";
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
