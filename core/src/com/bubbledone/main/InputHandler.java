package com.bubbledone.main;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.bubbledone.ui.CreateButton;

public class InputHandler implements InputProcessor {
	private TaskBubble last = null;
	private BubbleWorld world;
	private OrthographicCamera cam;
	private GestureDetector detector;
	private TouchHandler handler;
	
	public InputHandler(BubbleWorld world, OrthographicCamera cam) {
		this.world = world;
		this.cam = cam;
		handler = new TouchHandler();
		detector = new GestureDetector(handler);
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Vector3 coords = cam.unproject(new Vector3(screenX, screenY, 0));
		
		// if you pressed the create button
		CreateButton btn = world.getCreateButton();
		if (new Circle(btn.getX(), btn.getY(), btn.getRadius()).contains(new Vector2(coords.x, coords.y))) {
			world.newBubble();
		}
		
		// or if you pressed on a new bubble
		TaskBubble task = null;
		if (last != null) return true;
		else {
			for (TaskBubble t : world.getBubbles()) {
				if (new Circle(t.getPosition(), t.getRadius()).contains(new Vector2(coords.x, coords.y))) {
					task = t;
				}
			}
		}
		
		if (task == null) return false;
		
		last = task;
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		last = null;
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		Vector3 coords = cam.unproject(new Vector3(screenX, screenY, 0));
		if (last == null) return false;
		last.update((int) coords.x, (int) coords.y, 0, 0, last.getRadius());
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
