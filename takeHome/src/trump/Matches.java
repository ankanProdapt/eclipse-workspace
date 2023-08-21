package trump;

public class Matches implements Category{
	
	String category = "Matches";
	
	@Override
	public int compare(Integer score1, Integer score2) {
		return (score1 > score2) ? 1 : ((score1 == score2) ? 0 : -1); 
	}
	
	@Override
	public String toString() {
		return category;
	}
	
}
