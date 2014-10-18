package com.bubbledone.main;

import com.badlogic.gdx.Game;
import com.bubbledone.screens.BubbleScreen;

public class BubbleDone extends Game {

	@Override
	public void create() {
		setScreen(new BubbleScreen());
	}
}
