package codingTest0425;

import java.util.Arrays;

public class CodingTest_4 {
	public static void main(String[] args) {
		int[] numbers = {3, 5, 7, 2, 8, 5};
		int[] numbers_Two  = {10,10};
		int[] numbers_Three = {1,2};
		int number = CodingTest_4.twoNumbers(numbers_Three);
		System.out.println(number);
	}

	public static int twoNumbers(int[] numbers) {
		System.out.println("메소드 도입부 " + Arrays.toString(numbers));
		
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		System.out.println("max = " + max);
		
		for(int i=0; i<numbers.length; i++) {
			int number = numbers[i];

			if(number > max) {
				secondMax = max;
				max = number;
			}else if (number > secondMax && number != max) {
				secondMax = number;
			}
		}
		
		return (secondMax == Integer.MIN_VALUE) ? -1 : secondMax;
	}
}
