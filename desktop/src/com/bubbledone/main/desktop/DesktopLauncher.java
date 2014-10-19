package com.bubbledone.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bubbledone.main.BubbleDone;
import com.bubbledone.screens.BubbleScreen;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "BubbleDone";
		config.width = BubbleScreen.width * 4;
		config.height = BubbleScreen.height * 4;
		new LwjglApplication(new BubbleDone(), config);
	}
}
