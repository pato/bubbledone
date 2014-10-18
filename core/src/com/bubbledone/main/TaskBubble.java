package com.bubbledone.main;

import com.badlogic.gdx.math.Vector2;

/*
 * Bubble class for task
 */

public class TaskBubble {
	private Task task;
	private int width, height;
	private Vector2 position, velocity, acceleration;

	public TaskBubble(Task task, int width, int height, float x, float y) {
		this.task = task;
		this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
	}
	
	public void update(float x, float y, float x_vel, float y_vel, float x_acc, float y_acc) {
		position.set(x, y);
		velocity.set(x_vel, y_vel);
		acceleration.set(x_acc, y_acc);
	}
}
