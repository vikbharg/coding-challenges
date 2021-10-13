package techgig2021.semifinals;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Problem1 {

	public static void main(String args[]) throws Exception {

		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int numberOfCases = 0;
		long finalOutput = 0;
		if (stdin.hasNext()) {
			numberOfCases = Integer.parseInt(stdin.nextLine());
		}
		String inputValues = stdin.nextLine();
		for (int i = 0; i < numberOfCases; i++) {

			finalOutput += getMaximumSteps(Long.parseLong(inputValues.split(" ")[i]));
			System.out.println(getMaximumSteps(Long.parseLong(inputValues.split(" ")[i])));
		}
		System.out.print(finalOutput);
	}

	public static Long getMaximumSteps(Long input) {
		long steps = input;
		for (long i = 2; i <= (new Double(Math.ceil(Math.sqrt(input))).longValue()); i++) {
			while (input % i == 0) {
				input = input / i;
				steps += input;
			}
			if ((new Double(Math.ceil(Math.sqrt(input))).longValue()) <= i && input != 1) {
				steps += 1;
			}
		}
		return steps;
	}

}
