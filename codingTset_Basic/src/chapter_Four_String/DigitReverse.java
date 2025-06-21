package chapter_Four_String;

import java.util.Arrays;

public class DigitReverse {

	DigitReverse() {
		super();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(DigitReverseSolution.DigitReverseSolution(12345)));
	}
}
class DigitReverseSolution {
	
	DigitReverseSolution() {
		super();
	}

	public static int[] DigitReverseSolution(int number) {
		String string = Integer.toString(number);
		char[] stringBuilder = new StringBuilder(string).reverse().toString().toCharArray();
		int[] returnIntArray = new int[stringBuilder.length];

		for(int i=0; i<returnIntArray.length;i++) {
			returnIntArray[i] = stringBuilder[i]-'0';
		}

		return returnIntArray;
	}
}