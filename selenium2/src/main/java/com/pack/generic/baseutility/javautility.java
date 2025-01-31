package com.pack.generic.baseutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautility {
	public int getrandomnumber()
	{
		Random random=new Random();
	  int randomnumber =random.nextInt(5000);
	  return randomnumber;
		
	}
	public String getSystemDateYYYYDDMM() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d);
		return date;
		
	}
	
	public String getrequireddataYYYYDDMM(int days) {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30 );
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
	public String getRequiredDataYYYYMMDD(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
