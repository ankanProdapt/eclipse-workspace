package practice;
import java.util.*;
import java.util.stream.Collectors;

public class Day4_a {
	
	public static boolean areAnagrams(String a, String b, boolean caseSensitive) {
		
		if(!caseSensitive) {
			a = a.toLowerCase();
			b = b.toLowerCase();
		}
		
		char arrA[] = a.toCharArray();
		char arrB[] = b.toCharArray();
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		return String.valueOf(arrA).equals(String.valueOf(arrB));
	}
	
	/*
	 * Same as calling
	 */
	public static boolean areAnagrams(String a, String b) {
		return areAnagrams(a, b, false);
	}
	
	
	
	public static List<ArrayList<String>> groupAnagramsTogether(String[] words){
		
		List<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
		
		for(int i = 0; i < words.length; i++) {
			boolean foundMatch = false;
			for(ArrayList<String> group: groups) {
				if(areAnagrams(group.get(0), words[i])) {
					group.add(words[i]);
					foundMatch = true;
					break;
				}
			}
			if(!foundMatch) {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(words[i]);
				groups.add(temp);
			}
		}
		
		
		return groups.stream().filter(group -> group.size() != 1).collect(Collectors.toList());
	}
	
	
	
	
	public static void main(String[] args) {
		String[] words = {"spear", "spare", "pears", "rose", "sore", "rise", "song", "reaps"};
		System.out.println(groupAnagramsTogether(words));
	}
	
	
}
