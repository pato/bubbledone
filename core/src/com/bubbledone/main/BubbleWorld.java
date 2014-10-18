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
		bubbles.add(new TaskBubble(t,10,10,10,10,10));
		bubbles.add(new TaskBubble(t,10,10,100,100,10));
	}
	
	public void update(float delta) {
		// physics stuff
    }
	
	public Attractor getAttractor() {
		return attractor;
	}
	
	public List<TaskBubble> getBubbles() {
		return bubbles;
	}
}