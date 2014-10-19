package com.bubbledone.main;

import com.badlogic.gdx.math.Vector2;
import com.bubbledone.interfaces.Circular;

public class Attractor extends Circular{
	private float mass;
	
	public Attractor(float mass, float radius, float x, float y) {
		this.mass = mass;
		setRadius(radius);
		setPosition(x,y);
	}
}