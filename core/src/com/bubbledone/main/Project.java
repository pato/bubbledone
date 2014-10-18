package com.bubbledone.main;

import java.util.ArrayList;
import java.util.Calendar;

import com.badlogic.gdx.graphics.Color;

public class Project {
	private ArrayList<Task> tasks;
	private String name;
	private Color color;

	public Project(String name, Color color) {
		this.name = name;
		this.color = color;
		tasks = new ArrayList<Task>();
	}
	
	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	public boolean deleteTask(Task task) {
		boolean success = false;
		if (this.tasks.contains(task)) {
			success = tasks.remove(task);
		}
		
		return success;
	}
	
	public Task getTask(String name) {
		for (Task t : tasks) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		
		return null;
	}
	
	public Task getTask(Calendar dueDate) {
		for (Task t : tasks) {
			if (t.getDueDate().equals(dueDate)) {
				return t;
			}
		}
		
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
