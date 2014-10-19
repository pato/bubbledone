package com.bubbledone.main;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.bubbledone.ui.BubbleInfoPopupRenderer;
import com.bubbledone.ui.CreateButton;

public class InputHandler implements InputProcessor {
	private TaskBubble last = null;
	private BubbleWorld world;
	private OrthographicCamera cam;

	private long last_tap = 0L;

	public InputHandler(BubbleWorld world, OrthographicCamera cam) {
		this.world = world;
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
		//		long time = System.nanoTime();
		//		if (last_tap == 0) {
		//			last_tap = time;
		//		} else {
		//			if (time - last_tap <= 2000000000) {
		//				System.out.println("double tap"); 
		//			}
		//			last_tap = 0;
		//		}

		Vector3 coords = cam.unproject(new Vector3(screenX, screenY, 0));

		if (world.getBubbleInfoPopup().isVisible()) {
			if (BubbleInfoPopupRenderer.deleteBtn.contains(new Vector2(coords.x, coords.y))) {
				System.out.println("deleting task");
				//world.getBubbleInfoPopup().getTaskBubble().fucking_delete();
				world.getBubbleInfoPopup().hide();
				world.getCreateButton().display();
			} else if (BubbleInfoPopupRenderer.doneBtn.contains(new Vector2(coords.x, coords.y))) {
				System.out.println("marking task done");
				world.getBubbleInfoPopup().hide();
				world.getCreateButton().display();
			}
		}

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
