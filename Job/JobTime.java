package Job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JobTime {	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	private Calendar date;
	private Date start;
	private Date end;
	
	public JobTime() {
		super();
	}
	public Calendar checkin() {
		date = Calendar.getInstance();
		System.out.println(formatter.format(date.getTime()));
		start = date.getTime();
		return date;
	}
	public Calendar checkout() {
		date = Calendar.getInstance();
		System.out.println(formatter.format(date.getTime()));
		end = date.getTime();
		return date;
	}
	public int elapsed(){
		DateTimeUtils dateTimeUtils = new DateTimeUtils();
		return dateTimeUtils.printDifference(start, end);
	}	
}
