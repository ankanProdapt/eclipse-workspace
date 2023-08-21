package practice;
import java.util.*;

public class Solution {
	
	private static final String[] ONES =     {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	private static final String[] TENS =     {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	private static final String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	
	
	public static int toHinduArabic(String roman) {
		int hinduArabic = 0;
		
		// Handling Thousands
		while(roman.charAt(0) == 'M') {
			hinduArabic += 1000;
			roman = roman.substring(1);
		}
		
		// Handling Hundreds
		for(int i = 9; i > 0; i--) {
			if(roman.indexOf(HUNDREDS[i]) == 0) {
				hinduArabic += 100 * i;
				roman = roman.substring(HUNDREDS[i].length());
				break;
			}
		}
		
		// Handling Tens
		for(int i = 9; i > 0; i--) {
			if(roman.indexOf(TENS[i]) == 0) {
				hinduArabic += 10 * i;
				roman = roman.substring(TENS[i].length());
				break;
			}
		}
		
		// Handling Ones
		for(int i = 9; i > 0; i--) {
			if(roman.indexOf(ONES[i]) == 0) {
				hinduArabic += i;
				roman = roman.substring(ONES[i].length());
				break;
			}
		}
		
		return hinduArabic;
	}
	
	
	
	public static String toRoman(int hinduArabic) {
		String roman = "";
		
		// Handling Ones Place
		roman = ONES[hinduArabic%10] + roman;
		hinduArabic /= 10;
		
		// Handling Tens Place
		roman = TENS[hinduArabic%10] + roman;
		hinduArabic /= 10;
		
		// Handling Tens Place
		roman = HUNDREDS[hinduArabic%10] + roman;
		hinduArabic /= 10;
		
		// Handling Thousands
		roman = "M".repeat(hinduArabic) + roman;
		
		return roman;
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(toHinduArabic("III"));
		System.out.println(toHinduArabic("XXVII"));
		System.out.println(toHinduArabic("LVIII"));
		System.out.println(toHinduArabic("CXXIII"));
		System.out.println(toHinduArabic("DCXLI"));
		System.out.println(toHinduArabic("CCCXLIII"));
		System.out.println(toHinduArabic("MMMDCCXXIV"));
		System.out.println(toHinduArabic("MMMMMCDLXIX"));
		
		
		
		System.out.println(toRoman(27));
		System.out.println(toRoman(64));
		System.out.println(toRoman(544));
		System.out.println(toRoman(697));
		System.out.println(toRoman(177));
		System.out.println(toRoman(499));
		System.out.println(toRoman(8726));
		System.out.println(toRoman(6399));
		System.out.println(toRoman(1));
	}
}
