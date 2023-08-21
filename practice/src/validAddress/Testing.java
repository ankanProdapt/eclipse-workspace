package validAddress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testing {
	
	
	public static boolean containsLeadingZeroes(String s) {
		return (Integer.valueOf(s.charAt(0)) == 0) && s.length()>1;
	}
	
	
	public static boolean isValidNumber(Integer N) {
		return (N >= 0) && (N <= 255);
	}
	
	
	public static boolean isValidIP(String word) {
		String[] parts = word.split("\\.");
		
		if(parts.length != 4) {
			return false;
		}
		
		for(String part: parts) {
			try {
				if(!isValidNumber(Integer.valueOf(part)) || containsLeadingZeroes(part)) {
					return false;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		
		List<String> validIPAddress = new ArrayList<String>();
		
		
		// Reading from file
		try {
            File Obj = new File("addressFile.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String[] words = Reader.nextLine().split(" ");
                for(String word: words) {
                	if(isValidIP(word)) {
                		validIPAddress.add(word);
                	}
                }
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
		
		
		// Writing in file
		try {
            FileWriter Writer = new FileWriter("validIPAddress.txt");
			
			String result = "";
			for(String address: validIPAddress) {
				result += address + "\n";
			}
			
			System.out.println(result);
			
			Writer.write(result);
			Writer.close();
		}
		catch(IOException e){
			System.out.println("Something went wrong");
		}
		
		
	}
}
