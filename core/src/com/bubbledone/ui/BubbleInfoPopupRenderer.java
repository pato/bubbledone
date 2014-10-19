package com.bubbledone.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bubbledone.main.BubbleWorld;

public class BubbleInfoPopupRenderer {
	public static void render(BubbleWorld world, BubbleInfoPopup popup, OrthographicCamera cam, ShapeRenderer shapeRenderer) {
		shapeRenderer.begin(ShapeType.Filled);
		
		// shadow
        shapeRenderer.setColor(61 / 255.0f, 90 / 255.0f, 254 / 255.0f, 1); //#3D5AFE
        shapeRenderer.rect(11, 11, world.getWidth() - 20, world.getHeight() - 20);
        
        // box
        shapeRenderer.setColor(83 / 255.0f, 109 / 255.0f, 254 / 255.0f, 1); //#536DFE
        shapeRenderer.rect(10, 10, world.getWidth() - 20, world.getHeight() - 20);
        
        shapeRenderer.end();
	}
}