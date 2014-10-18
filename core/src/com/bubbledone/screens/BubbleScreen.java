package com.bubbledone.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.bubbledone.main.BubbleDone;
import com.bubbledone.main.BubbleWorld;
import com.bubbledone.main.BubbleWorldRenderer;

public class BubbleScreen implements Screen {
	private BubbleWorld world;
	private BubbleWorldRenderer renderer;
	BubbleDone parent;
    
    public BubbleScreen(BubbleDone parent) {
    	this.parent = parent;
        Gdx.app.log("GameScreen", "Attached");
        world = new BubbleWorld();
        renderer = new BubbleWorldRenderer(world);
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");     
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");        
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");       
    }

    @Override
    public void dispose() {
        // Leave blank
    }

}