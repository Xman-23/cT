package chapter_Two_time_comPlexity;

import java.util.Arrays;
import java.util.Scanner;

public class PrefixSumCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("시작 인덱스 입력: ");
	    int start = scanner.nextInt();
	    System.out.print("끝 인덱스 입력: ");
	    int end = scanner.nextInt();
	    scanner.close();
	    /*
	     	arr =          [2, 4, 5, 1, 3]
			index =         0  1  2  3  4
			prefixSumArray = [0, 2, 6, 11, 12, 15]
	     */
	    int[] arr = {2, 4, 5, 1, 3};
	    int result = PrefixSumCalculatorMethod(arr, start, end);
	    System.out.println("구간 합: " + result);
	}

	public static int PrefixSumCalculatorMethod(int[] arr, int start, int end) {

		int returnPrefixSum = 0;
		int[] prefixSumArray = new int[arr.length+1];
		prefixSumArray[0] = 0;

		for(int i=0; i<arr.length; i++) {
			prefixSumArray[i+1] =arr[i];
		}
		System.out.println(Arrays.toString(prefixSumArray));

		//연속된 부분의 합
		//인덱스0의 값은0 이전것과 더할것이 없으므로 i는 1부터 시작
		
		//returnArray[2] = copyArray[2-1]+ copyArray[2];
		//System.out.println(Arrays.toString(returnArray));
		
		for(int i=1; i<prefixSumArray.length; i++) {
			
			prefixSumArray[i] = prefixSumArray[i-1] + prefixSumArray[i];
			//현재 인덱스 에다가 이전 인덱스의값과 + 현재 인덱스의 합을 넣어서
			//연속 구간의 합으로 구조된 배열을 만든다.
		}
		System.out.println(Arrays.toString(prefixSumArray));
		if(start<0 || end < 0 || start >= arr.length || end >=arr.length) {
			return -1;
		}else {
			//원본 인덱스 기준으로 계산
			returnPrefixSum = prefixSumArray[end+1] - prefixSumArray[start];
		}
		return returnPrefixSum;
	}

}
