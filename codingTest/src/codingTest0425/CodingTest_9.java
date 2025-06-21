package codingTest0425;

public class CodingTest_9 {
	public static void main(String[] args) {
		int[] num = {1,1,2};
		System.out.println(getNumber(num));
	}
	
	public static int getNumber(int[] num) {
		if(num.length<2) {
			return -1;
		}

		int min = Integer.MAX_VALUE;
		int twomin = Integer.MAX_VALUE;

		for(int number : num) {
			if(number<min) {
				twomin = min;
				min = number;
			}else if(number != min && number <twomin ) {
				twomin = number;
			}
		}
		return (twomin == Integer.MAX_VALUE) ? -1 : twomin;
	}
}
