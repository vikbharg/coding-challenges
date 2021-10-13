package techgig2021.finals;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int numberOfInputs = 0;
		if (stdin.hasNext()) {
			numberOfInputs = stdin.nextInt();
		}
		List<Integer> sequence = new ArrayList<>();

		for (int i = 0; i < numberOfInputs; i++) {
			sequence.add(stdin.nextInt());
		}

		System.out.println(getSmallestNumber(sequence));
	}

	public static int getSmallestNumber(List<Integer> sequence) {
		boolean isComplete = false;
		int initialNumber = 0;
		while (!isComplete) {
			int counter = 0;
			initialNumber = getNextNumber(initialNumber + 1, sequence.get(0));
			int startingNumber = initialNumber;
			for (int i = 1; i < sequence.size(); i++) {
				startingNumber++;
				if(isDigitPresent(startingNumber, sequence.get(i))) {
					counter++;
				}else {
					break;
				}
			}
			if(counter == sequence.size()-1) {
				isComplete = true;
				return initialNumber;
			}
		}
		return 0;

	}


	static int getNextNumber(int lowerLimit, int digit) {
		boolean found = false;
		int nextDigit = lowerLimit;
		while (!found) {
			if (lowerLimit == digit || isDigitPresent(nextDigit, digit)) {
				found = true;
				return nextDigit;
			}
			nextDigit++;
		}
		return 0;
	}

	static boolean isDigitPresent(int start, int digit) {
		while (start > 0) {
			if (start % 10 == digit)
				break;

			start = start / 10;
		}

		return (start > 0);
	}

}
