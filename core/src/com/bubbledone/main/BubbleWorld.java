package com.bubbledone.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.bubbledone.interfaces.Circular;
import com.bubbledone.screens.BubbleScreen;
import com.bubbledone.ui.BubbleInfoPopup;
import com.bubbledone.ui.CreateButton;

public class BubbleWorld {
	Attractor attractor;
	List<TaskBubble> bubbles;
	CreateButton createBtn;
	BubbleInfoPopup bubblePopup;
	
	private SpriteBatch batch;
	private BitmapFont font;
	private Vector2 dimensions;
	private BubbleScreen parent;
	
	private Texture background;
	
	public BubbleWorld(float width, float height, BubbleScreen parent) {
		bubblePopup = new BubbleInfoPopup();
		//bubblePopup.display();
		this.parent = parent;
		dimensions = new Vector2(width, height);
		attractor = new Attractor(10,10, width/2 - 10, height/2);
		bubbles = new CopyOnWriteArrayList<TaskBubble>();
		//createBtn = new CreateButton(Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 100, true);
		//System.out.println(Gdx.graphics.getWidth() + " : " + Gdx.graphics.getHeight());
		createBtn = new CreateButton(getWidth(), getHeight(), 15, true);
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2014);
		c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 24);
		Task t = new Task("Clean clothes", c);
		Task t2 = new Task("Shave", c);
		Task t3 = new Task("Call mom", c);
		Task t4 = new Task("Get job", c);
		t.setNotes("Ran out of underwear,\nneed to do laundry");
		t2.setNotes("Beard has gotten out\nof hand, I look\nhomeless");
		t3.setNotes("Need to remind my mom\nthat I am still alive");
		t4.setNotes("Should probably start\nlooking for a job");
		bubbles.add(new TaskBubble(t,10,10,10));
		bubbles.add(new TaskBubble(t2,100,100,10));
		bubbles.add(new TaskBubble(t3,100,180,30));
		bubbles.add(new TaskBubble(t4,100,150,10));
		
		font = new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), true);
        font.setColor(Color.WHITE);
        font.setScale(0.25f);
        batch = new SpriteBatch();

        background = new Texture(Gdx.files.internal("background.jpg"));
	}
	
	public Texture getBackground() {
		return background;
	}
	
	public synchronized void addTaskBubble(TaskBubble bubble) {
		this.bubbles.add(bubble);
	}
	
	private Vector2 collide(Circular a, Circular b){
		Vector2 diff = a.getPosition().cpy().sub(b.getPosition());
		float radius = diff.len();
		float distance = radius - a.getRadius() - b.getRadius();
		if(distance > 0) return new Vector2(0,0);
		float force_mag = (float) Math.exp(-2.0*distance);
		return diff.scl(force_mag/radius);
	}
	
	public synchronized void update(float delta) {
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
	
	public synchronized List<TaskBubble> getBubbles() {
		return bubbles;
	}
	
	public BitmapFont getFont() {
		return font;
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
	
	public CreateButton getCreateButton() {
		return createBtn;
	}
	
	public BubbleInfoPopup getBubbleInfoPopup() {
		return bubblePopup;
	}
	
	public float getWidth() {
		return dimensions.x;
	}
	public float getHeight() {
		return dimensions.y;
	}

	public void newBubble() {
		parent.setTaskScreen();
		
	}
}