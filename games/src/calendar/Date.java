package calendar;

public class Date {
	public final int day, month, year;
	
	private static final String[] MONTHS = {"", "jan", "feb", "mar", "apr", "may", "jun",
										  "jul", "aug", "sep", "oct", "nov", "dec"};
	private static final int[] NON_LEAP = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int MAX_MONTH = 12;
	
	private static final int[] MONTH_VALUE = {0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
	private static final int[] CENTURY_CODE = {6, 4, 2, 0};
	private static final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday",
													"Thursday", "Friday", "Saturday"};
	
	
	public Date(int dd, int mm, int yyyy) {
		day = dd;
		month = mm;
		year = yyyy;
	}
	
	public static int[] findCalendar(int year) {
		return isLeap(year)? LEAP: NON_LEAP;
	}
	
	public static boolean isLeap(int year) {
		if(year % 100 == 0) {
			return (year % 400 == 0);
		}
		return (year % 4 == 0);
	}
	
	
	// The Key Value Method
	public String getDayOfTheWeek() {
		
		int key = year % 100;
		key /= 4;
		key += day;
		key += MONTH_VALUE[month];
		if(isLeap(year) && month <= 2) {
			key -= 1;
		}
		int yy = year / 100;
		key += CENTURY_CODE[yy % 4];
		key += year % 100;
		key += 6;
		key %= 7;
		return DAYS_OF_WEEK[key];
	}
	
	
	
	
	public Date nextDate() {
		int dd = day;
		int mm = month;
		int yyyy = year;
		
		int[] calendar = findCalendar(yyyy);
		
		if(dd == calendar[mm]) {
			mm++;
			dd = 1;
			if(mm - 1 == MAX_MONTH) {
				mm = 1;
				yyyy++;
			}
		}
		else {
			dd++;
		}
		
		return new Date(dd, mm, yyyy);
	}
	
	public Date nextDateAfter(int days) {
		Date curDate = new Date(day, month, year);
		
		for(int i = 0; i < days; i++) {
			curDate = curDate.nextDate();
		}
		
		return curDate;
	}
	
	
	
	
	
	
	
	public Date prevDate() {
		int dd = day;
		int mm = month;
		int yyyy = year;
		
		int[] calendar = findCalendar(yyyy);
		
		if(dd == 1) {
			if(mm == 1) {
				yyyy--;
				mm = MAX_MONTH;
			}
			else {
				mm--;
			}
			dd = calendar[mm];
		}
		else {
			dd--;
		}
		
		return new Date(dd, mm, yyyy);
	}
	
	public Date prevDateBefore(int days) {
		Date curDate = new Date(day, month, year);
		
		for(int i = 0; i < days; i++) {
			curDate = curDate.prevDate();
		}
		
		return curDate;
	}
	
	
	
	
	
	public String format(String formatSpecifier) {
		
		String[] data = formatSpecifier.split("\\|");
		
		String separator = data[data.length - 1];
		
		if(separator.equals("pipe")) {
			separator = "|";
		}
		
		
		String formattedString = "";
		
		for(int i = 0; i < data.length - 1; i++) {
			if(data[i].equals("dd")) {
				formattedString += String.format("%02d", day);
			}
			else if(data[i].equals("mm")) {
				formattedString += String.format("%02d", month);
			}
			else if(data[i].equals("mmm")) {
				formattedString += MONTHS[month];
			}
			else if(data[i].equals("yy")) {
				formattedString += String.format("%02d", year % 100);
			}
			else if(data[i].equals("yyyy")) {
				formattedString += String.format("%04d", year);
			}
			else if(data[i].equals("ddd") || data[i].equals("www")) {
				formattedString += this.getDayOfTheWeek();
			}
			
			if(i != data.length - 2) {
				formattedString += separator;
			}
		}
		
		return formattedString;
		
	}
	
	
	
	
	@Override
	public String toString() {
		return String.format("%02d-%02d-%04d, %s", day, month, year, this.getDayOfTheWeek());
	}
}
