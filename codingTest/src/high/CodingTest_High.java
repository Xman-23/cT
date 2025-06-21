package high;

import java.time.*;
import java.time.format.*;
import java.math.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class CodingTest_High {

	public static void main(String[] args) {
		System.out.println(Method_High.arrayPartSumTargetCounter(new int[] {1, 2, 3}, 3));

	}
}

class Method_High {

	Method_High() {
		super(); //부모 Object 생성자 호출
	}

	
	//배열에 부분배열의합이 대상과 같으면 카운트
	public static int arrayPartSumTargetCounter(int arr[], int target) {

		//Ex: arr = new int[] {1,2,3}, target = 3

		if(arr.length == 0 || arr ==null) {
			return -1;
		}

		int returnCounter = 0;

		for(int startIndex = 0; startIndex < arr.length; startIndex ++) {
			// for 문 돌때마다 sum을 0으로 초기화
			// 안하면 첫번째만 카운터 하고 sum에 값이 계속 누적
			// 즉, 카운터를 셀 수가 없음.
			int sum = 0; //1중 for문의 존재 이유
			//Ex: arr = new int[] {1,2,3}, target = 3
			for(int endIndex = startIndex; endIndex < arr.length; endIndex++) {
				sum = sum + arr[endIndex];
				if(sum == target) {
					returnCounter++;
				}
			}
		}
		return returnCounter;
	}
}
