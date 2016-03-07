package Job;

import java.util.Date;

public class DateTimeUtils {
	public int printDifference(Date startDate, Date endDate){
	
		int different = (int) (endDate.getTime() - startDate.getTime());
				
		int minutesInMilli = 1000 * 60;
		int hoursInMilli = minutesInMilli * 60;

		int elapsedHours = different / hoursInMilli;
		
		return elapsedHours;
	
	}
	
}