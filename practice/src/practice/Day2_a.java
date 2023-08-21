package practice;

import java.util.*;

public class Day2_a {
	public static void main(String[] args) {
		System.out.println("Prime Factors: " + findPrimeFactors(15));
		System.out.println("Prime Factors (Including Duplicates): " + findAllPrimeFactors(15));
	}
	
	
	public static boolean isDivisible(Integer N, Integer d){
	    return (N % d == 0);
	}
	
	
	public static ArrayList<Integer> findPrimeFactors(Integer N){
	    ArrayList<Integer> primeFactors = new ArrayList<Integer>();
	    
	    for(int i = 2; i*i <= N; i++){
	        if(isDivisible(N, i)){
	            primeFactors.add(i);
	            while(N % i == 0) {
	            	N /= i;
	            }
	        }
	    }
	    if(N > 1) primeFactors.add(N);
	    return primeFactors;
	}
	
	public static ArrayList<Integer> findAllPrimeFactors(Integer N){
	    ArrayList<Integer> primeFactors = new ArrayList<Integer>();
	    
	    for(int i=2; i*i<=N; i++){
	        while(isDivisible(N, i)){
	            primeFactors.add(i);
	            N /= i;
	        }
	    }
	    if(N > 1) primeFactors.add(N);
	    return primeFactors;
	}
	
}
