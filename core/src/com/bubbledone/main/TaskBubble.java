package com.bubbledone.main;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/*
 * Bubble class for task
 */

public class TaskBubble {
	private Task task;
	private int width, height;
	private Vector2 position, velocity;
	private float radius;
	
	private Circle circle;

	public TaskBubble(Task task, int width, int height, float x, float y, float radius) {
		this.task = task;
		this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        this.radius = radius;
        
        circle = new Circle(position, radius);
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public void update(float x, float y, float x_vel, float y_vel, float radius) {
		position.set(x, y);
		velocity.set(x_vel, y_vel);
		this.radius = radius;
	}
}
