package com.bubbledone.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task {
	private boolean isComplete;
	private float priority;
	private long estimatedTimeToCompletion; // minutes
	private Calendar dueDate;
	private String name;
	private String notes;

	public Task(String name, Calendar dueDate) {
		this.name = name;
		this.dueDate = dueDate;
		this.estimatedTimeToCompletion = 15;
		this.isComplete = false;
		this.priority = calcPriority(dueDate);
		this.notes = "";
	}

	private float calcPriority(Calendar dueDate2) {
		double time = Math.abs(dueDate2.getTimeInMillis() - new GregorianCalendar().getTimeInMillis()) - 6.0113960866016E13;
		time /= 10000;
		System.out.println(time);
		double a = 0.0;
		if(time > 1209600000/2){
			a = 1.0/15;
		}else if(time > 1209600000/4){
			a = 1.0/12;
		}else if(time > 1209600000/6){
			a = 1.0/10;
		}else if(time > 1209600000/8){
			a = 1.0/8;
		}else if(time > 1209600000/10){
			a = 1.0/6;
		}else if(time > 1209600000/12){
			a = 1.0/5;
		}else if(time > 1209600000/14){
			a = 1.0/2;
		}else {
			a = 1.0/1;
		}
//		System.err.println(time);
//		a = (float) Math.min(estimatedTimeToCompletion / time, 1.);
//		a = (float) Math.max(a, 0.);
//		a = (float) Math.pow(a, 0.01);
		float answer = (float) Math.pow((10 + 10.0 * Math.random()), 1);
		System.err.println(answer);
		return answer;
	}

	public Task(String name, Calendar dueDate, long timeNeeded) {
		this.name = name;
		this.dueDate = dueDate;
		this.estimatedTimeToCompletion = timeNeeded;
		this.isComplete = false;
		this.priority = calcPriority(dueDate);
		this.notes = "";
	}

	public long getEstimatedTimeToCompletion() {
		return estimatedTimeToCompletion;
	}

	public void setEstimatedTimeToCompletion(long estimatedTimeToCompletion) {
		this.estimatedTimeToCompletion = estimatedTimeToCompletion;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		if (!notes.equals(""))
			this.notes = notes;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.equals(""))
			this.name = name;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public float getPriority() {
		return priority;
	}

	public void setPriority(float priority) {
		this.priority = priority;
	}

	public void resetPriority() {
		this.setPriority(1.0f);
	}
}
