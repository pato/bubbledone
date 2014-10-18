package com.bubbledone.main;

import com.badlogic.gdx.math.Vector2;

public class Attractor {
	private float mass, radius, gravitational_constant;
	private Vector2 position;
	
	public Attractor(float mass, float radius, float gravitational_constant, float x, float y) {
		this.mass = mass;
		this.radius = radius;
		this.gravitational_constant = gravitational_constant;
		this.position = new Vector2(x, y);
	}
}