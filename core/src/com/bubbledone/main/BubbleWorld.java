package com.bubbledone.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BubbleWorld {
	Attractor attractor;
	List<TaskBubble> bubbles;
	private SpriteBatch batch;
	private BitmapFont font;
	
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
		
		font = new BitmapFont(true);
        font.setColor(Color.WHITE);
        font.setScale(0.4f);
        batch = new SpriteBatch();
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
	
	public BitmapFont getFont() {
		return font;
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
}