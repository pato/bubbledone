package com.bubbledone.main.android;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.bubbledone.interfaces.GetDate;
import com.bubbledone.main.TaskCreator;

public class AndroidGetDate implements GetDate{
	private AndroidApplication application;
	
	public AndroidGetDate(AndroidApplication application) {
		this.application = application;
	}
	
	@Override
	public void getDate(final TaskCreator taskCreator) {
		application.handler.post(new Runnable() {
			@Override
			public void run() {
				final Calendar c = Calendar.getInstance();
				final int mYear = c.get(Calendar.YEAR);
				final int mMonth = c.get(Calendar.MONTH);
				final int mDay = c.get(Calendar.DAY_OF_MONTH);
				 
				DatePickerDialog dpd = new DatePickerDialog(application.getContext(),
				        new DatePickerDialog.OnDateSetListener() {
				 
				            @Override
				            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				            	Calendar c = Calendar.getInstance();
				            	c.set(Calendar.YEAR, year);
				            	c.set(Calendar.MONTH, monthOfYear);
				            	c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
				                taskCreator.next(c);
				 
				            }
				        }, mYear, mMonth, mDay);
				dpd.setTitle("Set due date");
				dpd.show();
			}
		});
	}

	@Override
	public void getEstimatedDuration(final TaskCreator taskCreator) {
		application.handler.post(new Runnable() {
			@Override
			public void run() {
				final int mHour = 0;
				final int mMinute = 15;
				
				TimePickerDialog tpd = new TimePickerDialog(application.getContext(),
				        new TimePickerDialog.OnTimeSetListener() {
				            @Override
				            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
				                taskCreator.next(minute + hourOfDay * 60);
				            }
				        }, mHour, mMinute, true);
				tpd.setTitle("Set estimated duration");
				tpd.show();
			}
		});
	}

	@Override
	public void getDueTime(final TaskCreator taskCreator) {
		application.handler.post(new Runnable() {
			@Override
			public void run() {
				final Calendar c = Calendar.getInstance();
				final int mHour = c.get(Calendar.HOUR);
				final int mMinute = c.get(Calendar.MINUTE);
				
				TimePickerDialog tpd = new TimePickerDialog(application.getContext(),
				        new TimePickerDialog.OnTimeSetListener() {
				            @Override
				            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
				                taskCreator.next(minute + hourOfDay * 60);
				            }
				        }, mHour, mMinute, true);
				tpd.setTitle("Set due time");
				tpd.show();
			}
		});
	}
}
