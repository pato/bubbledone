package com.bubbledone.main.android;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

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
		            public void onDateSet(DatePicker view, int year,
		                    int monthOfYear, int dayOfMonth) {
		                taskCreator.next("test");
		 
		            }
		        }, mYear, mMonth, mDay);
		dpd.show();
	}

	@Override
	public void getEstimatedDuration(TaskCreator taskCreator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDueTime(TaskCreator taskCreator) {
		// TODO Auto-generated method stub
		
	}
}
