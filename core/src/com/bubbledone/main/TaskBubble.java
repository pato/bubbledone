package com.bubbledone.main;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.bubbledone.interfaces.Circular;

/*
 * Bubble class for task
 */

public class TaskBubble extends Circular {
	private Task task;
	private Vector2 velocity;
	
	public TaskBubble(Task task, float x, float y, float radius) {
		this.task = task;
        velocity = new Vector2(0, 0);
        setPosition(x,y);
        setRadius(radius);
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public void update(int x, int y, float x_vel, float y_vel, float radius) {
		setPosition(x,y);
		setRadius(radius);
		velocity.set(x_vel, y_vel);
	}
}
