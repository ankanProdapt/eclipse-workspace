package cp;
import java.util.*;

public class test {
	
	public static int minOfThree(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
	
	public static void solve() {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a+b+c - minOfThree(a,b,c) >= 10) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0) {
			t--;
			solve();
		}
	}
}
