package com.bubbledone.interfaces;

import com.badlogic.gdx.math.Vector2;

public abstract class Circular {
	private Vector2 position;
	private float radius;
	
	public void setPosition(float x, float y) {
		this.position = new Vector2(x,y);
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public Vector2 getPosition() {
		return position;
	}
	public float getX(){
		return position.x;
	}
	public float getY(){
		return position.y;
	}
	
	public void setRadius(float radius) {
		this.radius = radius;
	}
	public float getRadius() {
		return radius;
	}
	
}
