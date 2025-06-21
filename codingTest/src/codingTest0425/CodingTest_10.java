package codingTest0425;

public class CodingTest_10 {
	public static void main(String[] args) {
		int[] numbers = {10,10,8,10,7};
		int num = CodingTest_10.getSecondMaxValue(numbers);
		System.out.println(num);
	}

	public static int getSecondMaxValue (int[] numbers) {

		if(numbers.length<2) { //배열의 길이가 2이상이여야지 비교 가능
			return -1;
		}

		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MAX_VALUE;

		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] < 0) { // 음수 값 방지
				continue;
			}else if(numbers[i] > max) {
				secondMax = max;
				max = numbers[i];
			}else if(numbers[i] > secondMax && numbers[i] != max) {
				secondMax = numbers[i];
			}
		}
		//배열에 같은 값만 있을 경우 -1로 반환 비교를 할 수없으므로
		return (secondMax == Integer.MIN_VALUE) ? max : secondMax;  
	}
}
