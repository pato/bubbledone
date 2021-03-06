package com.bubbledone.ui;

import com.badlogic.gdx.math.Vector2;

public class CreateButton {
	private float radius;
	private boolean visible;
	private Vector2 position;
	
	public CreateButton(float x, float y, float radius, boolean visible) {
		this.position = new Vector2(x - radius - radius * 0.2f, y - radius - radius * 0.2f);
		this.radius = radius;
		this.visible = visible;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public float getX() {
		return position.x;
	}
	public float getY() {
		return position.y;
	}
	public void display() {
		visible = true;
	}
	public void hide() {
		visible = false;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public float getRadius() {
		return radius;
	}
}
