package com.bubbledone.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.bubbledone.interfaces.Circular;

public class BubbleWorld {
	Attractor attractor;
	List<TaskBubble> bubbles;
	
	public BubbleWorld() {
		attractor = new Attractor(10, 10, 50, 50);
		bubbles = new ArrayList<TaskBubble>();
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2014);
		c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 24);
		Task t = new Task("Clean clothes", c);
		bubbles.add(new TaskBubble(t,10,10,10));
		bubbles.add(new TaskBubble(t,100,100,10));
		bubbles.add(new TaskBubble(t,100,180,30));
	}
	
	private Vector2 collide(Circular a, Circular b){
		Vector2 diff = a.getPosition().cpy().sub(b.getPosition());
		float radius = diff.len();
		float distance = radius - a.getRadius() - b.getRadius();
		if(distance > 0) return new Vector2(0,0);
		float force_mag = (float) Math.exp(-2.0*distance);
		return diff.scl(force_mag/radius);
	}
	
	public void update(float delta) {
		System.out.println(delta);
		List<Vector2> new_velocities = new ArrayList<Vector2>();
		List<Vector2> new_positions = new ArrayList<Vector2>();
		for(int affectee_i=0; affectee_i<bubbles.size(); affectee_i++){
			TaskBubble affectee = bubbles.get(affectee_i);
			Vector2 total_force = new Vector2(0,0);
			for(int affector_i=0; affector_i<bubbles.size(); affector_i++){
				if(affector_i == affectee_i) continue; // Things don't affect themselves
				TaskBubble affector = bubbles.get(affector_i);
				total_force = total_force.cpy().add(collide(affectee, affector));
			}
			total_force = total_force.cpy().add(collide(affectee, attractor));
			double mass = Math.pow(affectee.getRadius(), 3);
			double attractor_mass = Math.pow(attractor.getRadius(), 3);
			Vector2 difference = affectee.getPosition().cpy().sub(attractor.getPosition());
			double force_mag = -1 * mass * attractor_mass / Math.pow(difference.len(), 2);
			double grav_constant = 30;
			Vector2 gravity_force = difference.cpy().scl((float) (grav_constant*force_mag/difference.len()));
			total_force = total_force.cpy().add(gravity_force);
			Vector2 acceleration = total_force.cpy().scl((float) (1/mass));
			Vector2 velocity = affectee.getVelocity().cpy().add(acceleration.cpy().scl(delta));
			float drag = (float) 0.005;
			velocity.scl(1-drag);
			Vector2 position = affectee.getPosition().cpy().add(velocity.cpy().scl(delta));
			System.out.println("dp:" + velocity.cpy().scl(delta));
			new_velocities.add(velocity);
			new_positions.add(position);
		}
		for(int i=0; i<bubbles.size(); i++){
			bubbles.get(i).setPosition(new_positions.get(i));
			bubbles.get(i).setVelocity(new_velocities.get(i));
		}
    }
	
	public Attractor getAttractor() {
		return attractor;
	}
	
	public List<TaskBubble> getBubbles() {
		return bubbles;
	}
}