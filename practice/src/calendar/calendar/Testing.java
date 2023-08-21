package calendar;

public class Testing {
	public static void main(String[] args) {
		Date today = new Date(25, 7, 2023);
		
		System.out.println(today);
		System.out.println(today.nextDate());
		System.out.println(today.nextDateAfter(365));
		System.out.println(today.prevDate());
		System.out.println(today.prevDateBefore(10));
		System.out.println(today.getDayOfTheWeek());
		System.out.println(today.format("mmm|dd|yyyy|www|pipe"));
	}
}
