package takeHome;
import java.io.*;
import java.util.*;

public class Day6_a {
	
	public static void writeToFile(String result) {
		try {
            FileWriter Writer = new FileWriter("sortedDetails.txt");
			
			Writer.write(result);
			Writer.close();
		}
		catch(IOException e){
			System.out.println("Something went wrong");
		}
		
		System.out.println(result);
	}
	
	public static String getResult(Map<Integer, List<String>> ratings) {
		List<Integer> keys = new ArrayList<Integer>(ratings.keySet());
		Collections.sort(keys);
		Collections.reverse(keys);
		
		String result = "";
		int rank = 1;
		for(Integer rating : keys) {
			for(String productName: ratings.get(rating)) {
				result += String.format("%d, %s\n", rank, productName);
			}
			rank += ratings.get(rating).size();
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		Map<Integer, List<String>> ratings = new HashMap<Integer, List<String>>();
		
		
		try {
			File Obj = new File("productDetails.txt");
			Scanner Reader = new Scanner(Obj);
			
			while(Reader.hasNextLine()) {
				String[] data = Reader.nextLine().strip().split(", ");
				Integer productRating = Integer.valueOf(data[1]);
				String productName = data[0];
				
				if(ratings.containsKey(productRating)) {
					ratings.get(productRating).add(productName);
				}
				else {
					List<String> temp = new ArrayList<String>();
					ratings.put(productRating, temp);
					ratings.get(productRating).add(productName);
				}
			}
			Reader.close();
			
			
			// Getting data in sorted order
			String result = getResult(ratings);
			
			
			// writing to a file
			writeToFile(result);
			
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
	}
}
