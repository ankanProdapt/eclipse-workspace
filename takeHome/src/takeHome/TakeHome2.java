package takeHome;
import java.util.*;
import java.io.*;

class ProductData implements Comparable<ProductData>{
	String productName;
	int rating;
	
	ProductData(String productName, int rating){
		this.productName = productName;
		this.rating = rating;
	}
	
	public int compareTo(ProductData product) {
		return - (this.rating - product.rating);
	}
}

public class TakeHome2 {
	public static void main(String[] args) {
		List<ProductData> productList = new ArrayList<ProductData>();
		
		
		try {
			File Obj = new File("productDetails.txt");
			Scanner Reader = new Scanner(Obj);
			
			while(Reader.hasNextLine()) {
				String[] data = Reader.nextLine().strip().split(", ");
				String productName = data[0];
				int rating = Integer.valueOf(data[1]);
				productList.add(new ProductData(productName, rating));
			}
			Reader.close();
			Collections.sort(productList);
		}
		
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		
		
		
		
		try {
            FileWriter Writer = new FileWriter("sortedDetails.txt");
			
			String result = "";
			int prev = 0;
			for(int i = 0; i < productList.size(); i++) {
				if(i == 0) {
					result += "1, " + productList.get(i).productName + "\n";
					prev = 1;
				}
				else {
					int prevRating = productList.get(i-1).rating, curRating = productList.get(i).rating;
					if(prevRating == curRating) {
						result += String.valueOf(prev) + ", " + productList.get(i).productName + "\n";
					}
					else {
						result += String.valueOf(i+1) + ", " + productList.get(i).productName + "\n";
						prev = i+1;
					}
				}
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
