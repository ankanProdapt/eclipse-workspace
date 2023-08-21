## The Date Class

*This class can be used to represent date, find day of the week, get next or previous dates, and also to format the date.*

- ### Constructor:
`public Date(int day, int month, int year)`
		
		Example:
		Date d1 = new Date(25, 7, 2023);
		Date d2 = new Date(1, 1, 2022);

- ### nextDate:
`public Date nextDate()` => Returns Next Date
		
		Example:
		d1.nextDate();

- ### nextDateAfter:
`public Date nextDateAfter(int k)` => Returns Date after k days
		
		Example:
		d2.nextDateAfter(5);

- ### prevDate:
`public Date prevDate()` => Returns Previous Date
		
		Example:
		d1.prevDate();

- ### getDayOfTheWeek():
`public String getDayOfTheWeek()` => Returns Day of the week
		
		Example:
		d1.getDayOfTheWeek();     //Tuesday


- ### prevDateBefore:
`public Date prevDateBefore(int k)` => Returns Date before k days
		
		Example:
		d2.prevDateBefore(10);

- ### format:
`public String format(String formatSpecifier)` => Returns String of date in the given format specifier
		
		formatSpecifier should be a string in this format:
		[arg1]|[arg2]|...|[separator]
		
		Allowed args:
		1. dd   => 2 digits of day
		2. mm   => 2 digits of month
		3. mon  => First 3 letters of month
		4. yy   => Last 2 digits of year
		5. yyyy => 4 digits of year
		6. www  => day of the week
		7. ddd  => day of the week
		
		Allowed Separators:
		Any string containing ASCII Characters.
		If you want to use "|" as a separator, mention it as "pipe".
		
		Examples:
		d1.format("dd|mm|yy|www|-");        //25-07-23-Tuesday
		d1.format("mmm|dd|yyyy|www|pipe");  //jul|25|2023|Tuesday