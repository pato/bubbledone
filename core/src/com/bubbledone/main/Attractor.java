package com.bubbledone.main;

import com.badlogic.gdx.math.Vector2;

public class Attractor {
	private float mass, radius;
	private Vector2 position;
	
	public Attractor(float mass, float radius, float x, float y) {
		this.mass = mass;
		this.radius = radius;
		this.position = new Vector2(x, y);
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
	
	public float getRadius() {
		return radius;
	}
}