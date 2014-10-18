package com.bubbledone.main;

import com.badlogic.gdx.Input.TextInputListener;

public class TextInput implements TextInputListener {
	
	private TaskCreator parent;
	
	public TextInput(TaskCreator parent){
		this.parent  = parent;
	}

	@Override
	public void input(String text) {
		parent.next(text);
	}

	@Override
	public void canceled() {
	}
	
	

}
