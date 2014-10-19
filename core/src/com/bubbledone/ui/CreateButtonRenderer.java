package com.bubbledone.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bubbledone.main.BubbleWorld;

public class CreateButtonRenderer {
	public static void render(BubbleWorld world, CreateButton button, OrthographicCamera cam, ShapeRenderer shapeRenderer) {
		shapeRenderer.begin(ShapeType.Filled);
		
		// draw shadow
        shapeRenderer.setColor(139 / 255.0f, 195 / 255.0f, 74 / 255.0f, 1);//8bc34a
        shapeRenderer.ellipse(button.getX() + 0.6f, button.getY() + 1, button.getRadius(), button.getRadius(), 1000);
		
        // draw circle
		shapeRenderer.setColor(178 / 255.0f, 255 / 255.0f, 89 / 255.0f, 1);
        shapeRenderer.ellipse(button.getX(), button.getY(), button.getRadius(), button.getRadius(), 1000);
        
        // draw plus sign
        shapeRenderer.setColor(51 / 255.0f, 105 / 255.0f, 30 / 255.0f, 1);
        float width = button.getRadius() * 0.05f;
        float widthOffset = button.getRadius() / 2f - width / 2f;
        float height = button.getRadius() * 0.4f;
        float heightOffset = (button.getRadius() * 0.6f) / 2f;
        shapeRenderer.rect(button.getX() + widthOffset, button.getY() + heightOffset, width, height);
        shapeRenderer.rect(button.getX() + heightOffset, button.getY() + widthOffset, height, width);
        
		shapeRenderer.end();
	}
}
