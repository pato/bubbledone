package com.bubbledone.main;

import java.util.Calendar;

/*
 * Bubble class for task
 */

public class TaskBubble {
	private Task task;
	
	public TaskBubble(Task task) {
		this.task = task;
	}
	
	public TaskBubble(String name, Calendar dueDate) {
		this.task = new Task(name, dueDate);
	}
	
	public void physics() {
		
	}
}
