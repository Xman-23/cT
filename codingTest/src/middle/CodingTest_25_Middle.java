package middle;

import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class CodingTest_25_Middle {
	public static void main(String[] args) {
		int[] 	numbers 	= {1,4,3,6,8,1,2,77,9,12,2,4,5};
		int		num		= 5;

		//System.out.println("배열 오름차순 정렬(중복O) = " + Arrays.toString(Method_Middle.sortArray(numbers)));
		//System.out.println("배열 오름차순 정렬(중복X) = " + Method_Middle.sortArrayTreeSet(numbers));
		//System.out.println("팩토리얼 = " + Method_Middle.factorial(num));
		System.out.println("파보나치 컴퓨터 기준(인덱스) = " + Method_Middle.fibonacciComputer(num));
		//System.out.println("파보나치 사람 순서 기준(사람) = " + Method_Middle.fibonacciHuman(num));
		//System.out.println("파보나치 배열(N) = " + Arrays.toString(Method_Middle.fibonacciArray(num)));
		//System.out.println("파보나치 배열 순서(N) = " + Arrays.toString(Method_Middle.fibonacciArrayLength(num)));
		
	}
}

class Method_Middle {

	Method_Middle() {
		super();
	}

	//배열 정렬(오름차순)
	public static int[] sortArray(int[] numbers) {

		if(numbers.length == 0 || numbers == null) {
			return null;
		}

		Arrays.sort(numbers);

		return numbers;
	}

	//배열 오름차순 정렬(중복X)
	public static Set<Integer> sortArrayTreeSet(int[] numbers) {

		if(numbers.length == 0 || numbers == null) {
			return null;
		}

		Set<Integer> set = new TreeSet<Integer>();

		for(int num : numbers) {
			if(num <= 0) {
				continue;
			}else {
				set.add(num);
			}
		}

		return set;
	}

	//팩토리얼 문제
	public static int factorial(int n) {

		if(n <= 1) {
			return 0;
		}
		//주의!! returnNumber 를 0으로 초기화 하면 안된다..
		// '0'이 안되는 이유는 0*i(1) = 0, 0*i(2) = 0 이므로 무조건으로 0을 반환
		int returnNumber = 1; 
		for(int i = 1; i<=n; i++) {
			returnNumber = returnNumber * i;
		}
	
		return returnNumber;
	}

	//파보나치 0, 1, 1, 2, 3, 5, 8 ~ 를 뜻함
	//파보나치 문제(컴퓨터 인덱스 기준 0,1,2,3,4,5)
	//int n은 인덱스를 뜻함.(컴퓨터의 순서 0부터 시작 ex) 0,1,2,3,4,5,6,7
	public static int fibonacciComputer(int n) {

		if(n <= 1) { //파보나치의 첫번째 자리는 0
			return n;
		} 
		//   0, 1, 1, 2 ,3 , 5
		//   0, 1, 2, 3, 4, 5 - 컴퓨터 인덱스
		//   1, 2, 3, 4, 5, 6 - 사람의 순서
		int prev =0; //컴퓨터 인덱스 0번째 자리 = 0, 사람으로 치면 첫번째 자리를 의미
		int temp = 0;
		int current = 1; // 컴퓨터 인덱스 1번째 자리 = 1, 사람으로 치면 두번째 자리를 의미
		//컴퓨터 기준 = 0번째는 prev, 1번째는 current , 2번째는 i=2 로 치환
		//사람 기준 = 첫번째는 prev, 두번째는 current, 세번째는 i=3로 치환
		// int i=2 : 컴퓨터 인덱스 2번째 자리 = 1, 사람으로 치면 세번째 자리
		for(int i=2; i<= n; i++) { //첫번째 자리 0, 두번째 자리 1 , 세번쨰 자리 2, 네번째 자리 3 ~
			temp = current;
			current = prev + current;
			prev = temp;
		}

		return current;
	}

	//파보나치 0, 1, 1, 2, 3, 5, 8
	//파보나치 문제(사람 기준 1,2,3,4,5,6,7)
	//int n 은 사람의 순서로 취급
	public static int fibonacciHuman(int n) {
		if(n == 1) {
			return 0;
		}else if(n == 2) {
			return 1;
		}
		//여기서 prev와 current는 각각 첫번째자리, 두번째 자리를 뜻함.
		int prev = 0; //파보나치 첫번째 자리 는 0, 컴퓨터 인덱스는 0
		int temp = 0;
		int current =1;// 파보나치 두번째 자리 는 1, 컴퓨터 인덱스는 1

		//여기서 int i=3 는 세번째 자리를 뜻함
		//컴퓨터 인덱스 기준 = 0번째 prev =0으로 치환, 첫번째 current =1로 치환 , 두번째 i=2치환 (아무 언급 없으면)
		//사람 기준 = 첫번째 prev =1으로 치환, 두번째 current =1 로 치환,  세번째 i=3으로 치환 (i는 1부터 시작)
		for(int i=3; i<=n; i++) {
			temp = current;
			current = prev + current;
			prev= temp;
		}
		return current;
	}

	//피보나치 배열문제
	public static int[] fibonacciArray(int n) {
		// n은 인덱스를 뜻하지만, 인덱스를 다 담기 위해선 배열의 length(길이)를 n+1을 해줘야 인덱스 n을 다 담을 수 있음
		int[] returnFibonacci = new int[n+1]; 
		//n >= 0을 해주는 이유 n이 0이상의 자리를 의미하므로 0번째 자리의 값 0 을 대입
		//0, 1, 1, 2, 3, 5, 8
		//0, 1, 2, 3, 4 ,5 ,6 컴퓨터 인덱스 기준
		//1, 2, 3, 4, 5, 6, 7 사람기준(배열의 길이)
		if(n >= 0) {
			returnFibonacci[0] = 0; //prev를 뜻하고
		}
		//n >= 1을 해주는 이유 n이 1이상의 자리를 의미하므로 1번째 자리의 값 1 을 대입
		//0, 1, 1, 2, 3, 5, 8
		//0, 1, 2, 3, 4 ,5 ,6 컴퓨터 인덱스 기준
		//1, 2, 3, 4, 5, 6, 7 사람기준(배열의 길이)
		if(n >= 1 ) {
			returnFibonacci[1] = 1; //current를 뜻함
		}
		//int i=2 는 컴퓨터 인덱스 2번째를 의미, 사람 기준으로는 세번쨰 자리
		//0, 1, 1, 2, 3, 5, 8
		//0, 1, 2, 3, 4 ,5 ,6 컴퓨터 인덱스 기준
		//1, 2, 3, 4, 5, 6, 7 사람기준(배열의 길이)
		for(int i=2; i< n; i++) {
			returnFibonacci[i] = returnFibonacci[i-2] + returnFibonacci[i-1];
		}
		return returnFibonacci;
	}
	
	//피보나치 문제
	public static int[] fibonacciArrayLength(int n) {
		//n은 0보다 작으면 안되고(음수), 30보다 크면 안된다 
		//즉 n<0 (음수) 또는 n >30 (31부터는) null 을 반환
		if(n< 0 ||n > 30) {
			return null;
		}
		int[] returnFibonacci = new int[n]; //n만큼의 인덱스를 담을려면 returnFibonacci의 length를 n+1을 해줘야한다
		
		if(n>=0 ) {
			returnFibonacci[0] = 0;
		}
		if(n>=1) {
			returnFibonacci[1] = 1;
		}

		for(int i=2; i< n; i++) {
			returnFibonacci[i] = returnFibonacci[i-2] + returnFibonacci[i-1];
		}

		return returnFibonacci;
	}
}
