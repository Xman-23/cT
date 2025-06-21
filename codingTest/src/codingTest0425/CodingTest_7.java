package codingTest0425;

public class CodingTest_7 {

	public static void main(String[] args) {
		int[] num = {5, 3, 9, 1, 9};
		System.out.println(getNumber(num));
	}
	public static int getNumber(int[] num) {
		if(num.length < 2) {
			return -1;
		}

		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for(int i=0; i<num.length; i++) {
			int numTwo = num[i];

			if(numTwo>max) {
				secondMax = max;
				max = numTwo;
			}else if(numTwo > secondMax && numTwo != max) {
				secondMax = numTwo;
			}
		}
		return (secondMax == Integer.MIN_VALUE) ? -1 : secondMax;
	}
}
