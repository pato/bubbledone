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
		System.out.println("touch touch down");
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		System.out.println("tap");
		long time = System.nanoTime();
		if (last_tap == 0) return false;
		else if (time - last_tap <= 100000) {
			System.out.println("Double tap");
		}
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		System.out.println("LONG TAP");
		Vector3 coords = cam.unproject(new Vector3(x, y, 0));

		// if you pressed the create button
		CreateButton btn = world.getCreateButton();
		if (new Circle(btn.getX(), btn.getY(), btn.getRadius()).contains(new Vector2(coords.x, coords.y))) {
			world.newBubble();
		}

		// or if you pressed on a new bubble
		TaskBubble task = null;
		if (last == null) {
			for (TaskBubble t : world.getBubbles()) {
				if (new Circle(t.getPosition(), t.getRadius()).contains(new Vector2(coords.x, coords.y))) {
					task = t;
				}
			}
		}

		if (task == null) {
			System.out.println("no match found");
			return false;
		}
		
		
		
		last = task;
		return true;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
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
