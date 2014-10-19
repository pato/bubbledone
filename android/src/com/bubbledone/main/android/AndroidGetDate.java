package com.bubbledone.main.android;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.bubbledone.interfaces.GetDate;
import com.bubbledone.main.TaskCreator;

public class AndroidGetDate implements GetDate{
	private Context context;
	
	public AndroidGetDate(Context context) {
		this.context = context;
	}
	
	@Override
	public void getDate(final TaskCreator taskCreator) {
		final Calendar c = Calendar.getInstance();
		final int mYear = c.get(Calendar.YEAR);
		final int mMonth = c.get(Calendar.MONTH);
		final int mDay = c.get(Calendar.DAY_OF_MONTH);
		 
		DatePickerDialog dpd = new DatePickerDialog(context,
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
		dpd.show();
	}

	@Override
	public void getEstimatedDuration(final TaskCreator taskCreator) {
		final Calendar c = Calendar.getInstance();
		final int mHour = c.get(Calendar.HOUR);
		final int mMinute = c.get(Calendar.MINUTE);
		
		TimePickerDialog tpd = new TimePickerDialog(context,
		        new TimePickerDialog.OnTimeSetListener() {
		            @Override
		            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
		            	Calendar c = Calendar.getInstance();
		            	c.set(Calendar.HOUR, hourOfDay);
		            	c.set(Calendar.MINUTE, minute);
		                taskCreator.next(c);
		            }
		        }, mHour, mMinute, false);
		tpd.show();
	}

	@Override
	public void getDueTime(final TaskCreator taskCreator) {
		final Calendar c = Calendar.getInstance();
		final int mHour = c.get(Calendar.HOUR);
		final int mMinute = c.get(Calendar.MINUTE);
		
		TimePickerDialog tpd = new TimePickerDialog(context,
		        new TimePickerDialog.OnTimeSetListener() {
		            @Override
		            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
		            	Calendar c = Calendar.getInstance();
		            	c.set(Calendar.HOUR, hourOfDay);
		            	c.set(Calendar.MINUTE, minute);
		                taskCreator.next(c);
		            }
		        }, mHour, mMinute, false);
		tpd.show();
	}
}
