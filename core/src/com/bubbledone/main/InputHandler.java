package com.bubbledone.main;

import java.util.GregorianCalendar;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class InputHandler implements InputProcessor {
	private TaskBubble last = null;
	private List<TaskBubble> list;
	private OrthographicCamera cam;
	
	public InputHandler(List<TaskBubble> list, OrthographicCamera cam) {
		this.list = list;
		this.cam = cam;
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
		System.out.println("DRAG x: " + coords.x + " y: " + coords.y + " pointer: " + pointer);
		TaskBubble task = null;
		if (last != null) task = last;
		else {
			for (TaskBubble t : list) {
				System.out.println(t.getPosition().x + " " + t.getPosition().y + " " + t.getRadius());
				if (new Circle(t.getPosition(), t.getRadius()).contains(new Vector2(coords.x, coords.y))) {
					System.out.println("found something");
					task = t;
				}
			}
		}
		
		if (task == null) return false;
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		last = null;
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {		
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
