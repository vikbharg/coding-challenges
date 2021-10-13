package techgig2021.prelims;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Problem1 {


	public static void main(String args[]) throws Exception {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		   int numberOfPerson = 0;
		    String virus = "";
		   if(stdin.hasNext()){
		      virus = stdin.nextLine();
		   }

		   if(stdin.hasNext()){
		      numberOfPerson = Integer.parseInt(stdin.nextLine());
		   }
		        
		   for(int i=0;i<numberOfPerson;i++){
		      printResult(virus, stdin.nextLine());
		   }

	}
	
	public static void printResult(String virus, String person){
	      int searchIndex = 0;
	      boolean positive = true;
	      for(int j=0;j<person.length();j++){
	         searchIndex = virus.indexOf(person.charAt(j), searchIndex);
	         if(searchIndex == -1){
	            positive = false;
	            break;
	         }
	      }
	      if(positive){
	         System.out.println("POSITIVE");
	      }else{
	         System.out.println("NEGATIVE");
	      }
	     
	   }

}
