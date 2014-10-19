package com.bubbledone.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.bubbledone.main.BubbleWorld;
import com.bubbledone.screens.BubbleScreen;

public class BubbleInfoPopupRenderer {
	private static final float buttonPad = 5;
	private static final float buttonHeight = 15;
	private static final float buttonWidth = (BubbleScreen.world.getWidth() - 20) / 2 - (1.5f * buttonPad);
	public static final Rectangle deleteBtn = new Rectangle(10 + buttonPad, (BubbleScreen.world.getHeight() - 15) - buttonHeight, buttonWidth, buttonHeight);
	public static final Rectangle doneBtn = new Rectangle(10 + buttonPad * 2 + buttonWidth, (BubbleScreen.world.getHeight() - 15) - buttonHeight, buttonWidth, buttonHeight);
	
	public static void render(BubbleWorld world, BubbleInfoPopup popup, OrthographicCamera cam, ShapeRenderer shapeRenderer) {
		shapeRenderer.begin(ShapeType.Filled);
		
		// shadow
        shapeRenderer.setColor(61 / 255.0f, 90 / 255.0f, 254 / 255.0f, 1); //#3D5AFE
        shapeRenderer.rect(11, 11, world.getWidth() - 20, world.getHeight() - 20);
        
        // box
        shapeRenderer.setColor(83 / 255.0f, 109 / 255.0f, 254 / 255.0f, 1); //#536DFE 
        shapeRenderer.rect(10, 10, world.getWidth() - 20, world.getHeight() - 20);
        
//        // delete button shadow
//        shapeRenderer.setColor(221 / 255.0f, 44 / 255.0f, 0 / 255.0f, 1); //#dd2c00
//        shapeRenderer.rect(deleteBtn.x + 1, deleteBtn.y + 1, deleteBtn.width, deleteBtn.height);
//        
//        // delete button
//        shapeRenderer.setColor(255 / 255.0f, 61 / 255.0f, 0 / 255.0f, 1); //#ff3d00
//        shapeRenderer.rect(deleteBtn.x, deleteBtn.y, deleteBtn.width, deleteBtn.height);
        
        // cancel button shadow
        shapeRenderer.setColor(158 / 255.0f, 158 / 255.0f, 158 / 255.0f, 1); //#9e9e9e
        shapeRenderer.rect(deleteBtn.x + 1, deleteBtn.y + 1, deleteBtn.width, deleteBtn.height);
        
        // cancel button
        shapeRenderer.setColor(189 / 255.0f, 189 / 255.0f, 189 / 255.0f, 1); //#bdbdbd
        shapeRenderer.rect(deleteBtn.x, deleteBtn.y, deleteBtn.width, deleteBtn.height);
        
        // done button shadow
        shapeRenderer.setColor(18 / 255.0f, 199 / 255.0f, 0 / 255.0f, 1); //#14e715
        shapeRenderer.rect(doneBtn.x + 1, doneBtn.y + 1, doneBtn.width, doneBtn.height);
        
        // done button
        shapeRenderer.setColor(20 / 255.0f, 231 / 255.0f, 21 / 255.0f, 1); //#14e715
        shapeRenderer.rect(doneBtn.x, doneBtn.y, doneBtn.width, doneBtn.height);
        shapeRenderer.end();
        
        world.getBatch().begin();
        String text = "Cancel";
        world.getFont().draw(world.getBatch(), text, deleteBtn.x - world.getFont().getBounds(text).width / 2 + doneBtn.width / 2,
        		deleteBtn.y - world.getFont().getBounds(text).height / 2 + deleteBtn.height / 2);
        
        text = "Finish";
        world.getFont().draw(world.getBatch(), text, doneBtn.x - world.getFont().getBounds(text).width / 2 + doneBtn.width / 2,
        		doneBtn.y - world.getFont().getBounds(text).height / 2 + deleteBtn.height / 2);
        
        text = popup.getTaskBubble().getName();
        world.getFont().draw(world.getBatch(), text, world.getWidth() / 2 - world.getFont().getBounds(text).width / 2,
        		20);
        
        text = popup.getTaskBubble().getTask().getNotes();
        world.getFont().drawMultiLine(world.getBatch(), text, world.getWidth() / 2 - world.getFont().getMultiLineBounds(text).width / 2,
        		40);
        
        world.getBatch().end();
	}
}