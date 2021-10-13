package techgig2021.prelims;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {



	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		   int numberOfCases = 0;
		   if(stdin.hasNext()){
			   numberOfCases = Integer.parseInt(stdin.nextLine());
		   }

		   for(int i=0;i<numberOfCases;i++){
			  String rangeValues = stdin.nextLine();
		      printResult(Integer.parseInt(rangeValues.split(" ")[0]), Integer.parseInt(rangeValues.split(" ")[1]));
		   }

	}
	
	public static void printResult(int lowerRange, int upperRange) {
		if(upperRange - lowerRange == 0) {
			System.out.println(upperRange - lowerRange);
			return;
		}
		
		System.out.println(calculateMaxDifferenceOfPrimeNumbers(lowerRange, upperRange));
	}
	
	public static int calculateMaxDifferenceOfPrimeNumbers(int lowerRange, int upperRange) {
		int maxDifference = -1;
		
		List<Integer> primeList = new ArrayList<>();
		
		for(int i=lowerRange;i<=upperRange;i++) {
			boolean isPrime = true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				primeList.add(i);
			}
		}
		
		if(primeList.size() == 1) {
			maxDifference = 0;
		}else if(primeList.size() > 1) {
			maxDifference = primeList.get(primeList.size()-1) - primeList.get(0);
		}
		
		return maxDifference;
	}

}
