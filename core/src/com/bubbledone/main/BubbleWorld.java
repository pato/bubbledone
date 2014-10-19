package com.bubbledone.main;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

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
		bubbles.add(new TaskBubble(t,100,150,10));
	}
	
	public void update(float delta) {
		List<TaskBubble> new_bubbles = new ArrayList<TaskBubble>();
		for(int affectee_i=0; affectee_i<bubbles.size(); affectee_i++){
			TaskBubble affectee = bubbles.get(affectee_i);
			for(int affector_i=0; affector_i<bubbles.size(); affector_i++){
				if(affector_i == affectee_i) continue; // Things don't affect themselves
				TaskBubble affector = bubbles.get(affector_i);
				double dx = affectee.getPosition().x - affector.getPosition().x;
				double dy = affectee.getPosition().y - affector.getPosition().y;
				double radius = Math.sqrt(dx*dx + dy*dy);
				double distance = radius - affector.getRadius() - affectee.getRadius();
				double force_mag = Math.exp(-20.0*distance);
				double force_x = (dx/radius) * 
			}
		}
    }
	
	public Attractor getAttractor() {
		return attractor;
	}
	
	public List<TaskBubble> getBubbles() {
		return bubbles;
	}
}