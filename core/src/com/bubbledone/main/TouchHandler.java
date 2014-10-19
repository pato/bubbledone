package com.bubbledone.main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.bubbledone.ui.CreateButton;

public class TouchHandler implements GestureListener {
	private BubbleWorld world;
	private OrthographicCamera cam;

	private long last_tap;
	private TaskBubble last;

	public TouchHandler(BubbleWorld world, OrthographicCamera cam) {
		this.world = world;
		this.cam = cam;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// double tap handler
		if (count < 2) return false;
		
		Vector3 coords = cam.unproject(new Vector3(x, y, 0));
		TaskBubble task = null;
		for (TaskBubble t : world.getBubbles()) {
			if (new Circle(t.getPosition(), t.getRadius()).contains(new Vector2(coords.x, coords.y))) {
				task = t;
			}
		}

		if (task == null) {
			System.out.println("no match found");
			return false;
		}
		
		
				
		return true;
	}

	@Override
	public boolean longPress(float x, float y) {
		// long press gets info
		System.out.println("LONG TAP");
		Vector3 coords = cam.unproject(new Vector3(x, y, 0));

		// if you pressed the create button
		CreateButton btn = world.getCreateButton();
		if (new Circle(btn.getX(), btn.getY(), btn.getRadius()).contains(new Vector2(coords.x, coords.y))) {
			world.newBubble();
		}

		// or if you pressed on a new bubble
		TaskBubble task = null;
		for (TaskBubble t : world.getBubbles()) {
			if (new Circle(t.getPosition(), t.getRadius()).contains(new Vector2(coords.x, coords.y))) {
				task = t;
			}
		}

		if (task == null) {
			System.out.println("no match found");
			return false;
		}
		
		world.getBubbleInfoPopup().setTaskBubble(task);
		world.getBubbleInfoPopup().display();
		world.getCreateButton().hide();
		
 		return true;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		System.out.println("fling");
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		System.out.println("pan");	
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

}
