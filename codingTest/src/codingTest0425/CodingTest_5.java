package codingTest0425;

import java.util.Arrays;

public class CodingTest_5 {
	public static void main(String[] args) {
		int[] numbers_One = {7, 3, 2, 5, 8};
		int[] numbers_Two = {10, 10, 10};
		int[] numbers_Three = {1,2};
		int number_One = CodingTest_5.secondMaxGetValue(numbers_One); 
		int number_Two = CodingTest_5.secondMaxGetValue(numbers_Two); 
		int number_Three = CodingTest_5.secondMaxGetValue(numbers_Three); 

		System.out.println(number_One);
		System.out.println(number_Two);
		System.out.println(number_Three);
	}

	public static int secondMaxGetValue(int[] numbers) {
		System.out.println("메소드 시작 :" + Arrays.toString(numbers) );

			if(numbers.length < 2 ) {
				return -1;
			}
	
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for(int num : numbers) {
			if(num < 0) {
				System.out.println("음수입니다");
				continue; // 음수는 무시하고 다음 for 실행
			}else if(num > max) {
				secondMax = max;
				max = num;
			}else if(num > secondMax && num != max) {
				secondMax = num;
			}
		}

		return (secondMax == Integer.MIN_VALUE) ? -1 : secondMax;
	}
}
