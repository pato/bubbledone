package com.bubbledone.ui;

import com.bubbledone.main.TaskBubble;

public class BubbleInfoPopup {
	private TaskBubble bubble;
	private boolean display;
	
	public BubbleInfoPopup() {
		display = false;
	}
	public void display() {
		display = true;
	}
	public void hide() {
		display = false;
	}
	public boolean isVisible() {
		return display;
	}
	public void setTaskBubble(TaskBubble bubble) {
		this.bubble = bubble;
	}
	public TaskBubble getTaskBubble() {
		return bubble;
	}
}
