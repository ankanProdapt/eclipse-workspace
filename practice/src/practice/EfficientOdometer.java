package practice;

public class EfficientOdometer {
	
	public static Integer getDigitCount(int reading) {
		return String.valueOf(reading).length();
	}
	
	public static int getMax(int digitCount) {
		int maxPossible = 0;
		for(int i = 0; i < digitCount; i++) {
			maxPossible += Math.pow(10,i) * (9-i);
		}
		return maxPossible;
	}
	public static int getMin(int digitCount) {
		int minPossible = 0;
		for(int i = 1; i <= digitCount; i++) {
			minPossible *= 10;
			minPossible += i;
		}
		return minPossible;
	}
	
	public static boolean isAscending(int reading) {
		int prev = 10;
		while(reading > 0) {
			int lastDigit = reading % 10;
			if(lastDigit >= prev) return false; 
			
			prev = lastDigit;
			reading /= 10;
		}
		
		return true;
	}
	
	public static int getNext(int reading, int prevDigit) {
		if(prevDigit - 1 != reading % 10) {
			return reading + 1;
		}
		reading = getNext(reading/10, reading % 10);
		return reading*10 + reading%10 + 1;
	}
	public static int nextReading(int reading) {
		if(reading % 10 != 9) {
			return reading + 1;
		}
		int digitCount =  getDigitCount(reading);
		
		int maxPossible = getMax(digitCount);
		if(maxPossible == reading)
			return getMin(digitCount);
		
		int prevDigit = 10;
		return getNext(reading, prevDigit);
	}
	
	
//	public static int prevReading(int reading) {
//		int digitCount =  getDigitCount(reading);
//		int minPossible = getMin(digitCount);
//		
//		if(minPossible == reading)
//			return getMax(digitCount);
//		
//		
//	}
	
	
	public static void main(String[] args) {
		System.out.println(isAscending(12345));
		System.out.println(nextReading(3456789));
		//System.out.println(prevReading(12345));
		//System.out.println(nextKthReading(12345, 2));
		//System.out.println(prevKthReading(12345, 1000));
		//System.out.println(distanceBetween(12345, 14589));
	}
}
