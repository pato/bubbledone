package com.bubbledone.main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bubbledone.ui.CreateButton;

public class BubbleInfoPopupRenderer {
	public static void render(BubbleWorld world, BubbleInfoPopup popup, OrthographicCamera cam, ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(64 / 255.0f, 196 / 255.0f, 255 / 255.0f, 1);
        shapeRenderer.rect(10, 10, world.getWidth() - 20, world.getHeight() - 20);
        shapeRenderer.end();
	}
}
