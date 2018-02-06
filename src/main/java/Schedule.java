

import java.util.Date;
import java.util.ArrayList;

public class Schedule {
	
	public long totalTime; // holds time difference from start time to end time in minutes
	
	public Schedule(Date startTime,Date endTime,String title, String detailText,String keyWords) {
		ArrayList<Date> dates = new ArrayList<>();   // holds starttime in index 0 and endtime in index 1 
		ArrayList<String> texts = new ArrayList<>(); // holds title in index 0, detailText 1, keyWords 2
		dates.add(startTime);
		dates.add(endTime);
		texts.add(title);
		texts.add(detailText);
		texts.add(keyWords);
		try {
			totalTime = (endTime.getTime()-startTime.getTime())/1000/60;// in minutes
		} catch (NullPointerException e) {
			totalTime =(long) 0;
		}
		
	}
}
