package com.bubbledone.main;

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
	public void setTaskBubble(TaskBubble bubble) {
		this.bubble = bubble;
	}
	public TaskBubble getTaskBubble() {
		return bubble;
	}
}
