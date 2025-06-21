package middle;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.lang.*;
import java.lang.reflect.Method;
import java.io.*;
import java.math.*;

public class CodingTest_Phone_Middel {

	public static void main(String[] args) {

		ArrayList<Integer> parameterList = new ArrayList<Integer>();
		for(int index=0; index <=9; index++) {
			parameterList.add(index);
			parameterList.add(index);
			parameterList.add(index);
		}

		System.out.println("문자열 뒤집기 = " + MethodPhone.reverseString("string"));
		System.out.println("배열에 최댓값과 최솟값 찾기 = " 
								+ Arrays.toString(MethodPhone.arrayMaxAndMinFindNumber(new int[] {1, 2, 3, 4, 5, 6 ,7})));
		System.out.println("소수 판별기 = " + MethodPhone.isPrime(4));
		System.out.println("배열 중복 제거 = " + MethodPhone.duplicateArrayDeleteSet(new int[] {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9}));
		System.out.println("List 중복 제거 =" + MethodPhone.duplicateListDeleteSet(parameterList));
		System.out.println("피보나치 = " + MethodPhone.fibonacci(3));
		System.out.println("두 수의합 = " + MethodPhone.twoSum(3, 5));
		System.out.println("제곱근 구하기 =" + MethodPhone.mathSqrt(4));
		System.out.println("배열 내에 특정값 인덱스찾기 = " + MethodPhone.arrayTagerfInd(new int[] {1,2,3,3,3,34,5,6,7,8,9}, 3));
		System.out.println("배열의 합 구하기 = " + MethodPhone.sumArray(new int[] {1,2,3,4,155,6,233,123,4455}));
		System.out.println("문자열 내에서 특정 문자 개수 세기 = " + MethodPhone.stringCounterTarget("banana", 'a'));
	}
}

class MethodPhone {

	MethodPhone() {
		super();
	}
	//문자열 뒤집기
	public static String reverseString(String parameterString) {

		String returnString = "";
		String returnTwoString = "";
		if(parameterString != "") {
			
			returnString = new StringBuilder(parameterString).reverse().toString();
			int stringLength = parameterString.length();
			for(int index=stringLength-1; index >=0; index-- ) {
				//문자열 과 문자를 더해주면은 String타입이 된다.
				returnTwoString = returnTwoString +parameterString.charAt(index);
				System.out.println("returnTwoString = " + returnString);
			}

		}else {
			return "-1";
		}

		return returnString;
	}
	//배열 최댓값, 최솟값 찾기
	public static int[] arrayMaxAndMinFindNumber(int[] array) {

		if(array.length == 0 || array == null) {
			return null;
		}

		Set<Integer> maxSet = new TreeSet<Integer>();
		Set<Integer> minSet = new TreeSet<Integer>(Comparator.reverseOrder());
		//음수도 허용
		for(int index=0; index<array.length; index++) {
			maxSet.add(array[index]);
			minSet.add(array[index]);
		}

		if(maxSet.size() == 0  || minSet.size() == 0) {
			return null;
		}

		System.out.println("maxSet = " + maxSet);
		System.out.println("minSet = " + minSet);
		
		Iterator<Integer> minIterator = maxSet.iterator();
		Iterator<Integer> maxIterator = minSet.iterator();

		int[] returnArray = new int[] {minIterator.next(),maxIterator.next()};

		return returnArray;
	}
	//소수 판별기
	public static boolean isPrime (int n) {

		if(n <= 1) {
			return false;
		}

		//0,1 은 false
		//i = 2부터 시작, n=5, 4부터 조건에 합당 
		//4는 1, 2, 4로 소수가 아님
		for(int i = 2; i<=Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	//Array 중복 제거 하기
	public static Set<Integer> duplicateArrayDeleteSet(int[] array) {

		if(array.length == 0 || array == null) {
			return null;
		}
		/*	
		Integer[] arr = {1, 2, 3};
		List<Integer> arraysAsList = new ArrayList<Integer>(Arrays.asList(arr));
		*/
		Set<Integer> set = new TreeSet<Integer>();

		for(int index=0; index<array.length; index++) {
			set.add(array[index]);
		}
		
		return set;
	}
	//List 중복 제거 하기
	public static Set<Integer> duplicateListDeleteSet(List<Integer> arrayList) {

		if(arrayList.size()<=0) {
			return null;
		}

		Set<Integer> set = new TreeSet<Integer>(arrayList);

		return set;
	}
	//피보나치
	public static int fibonacci(int index) {

		if(index == 0) {
			return 0;
		}else if(index == 1) {
			return 1;
		}

		int prev= 0;
		int temp = 0;
		int current = 1;
		
		for(int i = 2; i<= index; i++ ) {
			temp = current;
			//얘 가 피보나치의 정답임.
			current = prev + current;
			prev = temp;
		}
		
		return current;
	}
	// 두수의 합
	public static int twoSum(int numberOne, int numberTwo) {

		int retunSum = numberOne+ numberTwo;

		return retunSum;
	}
	// 제곱근 구하기
	public static int mathSqrt(int number) {

		return (int)(Math.sqrt(number));
	}
	//배열에서 특정(Target)값 인덱스 반환하기
	public static String arrayTagerfInd(int[] array, int target) {

		List<int[]> returnList = new ArrayList<int[]>();
		String retunString = "";
		for(int i = 0; i < array.length; i++) {
			if(array[i] == target) {
				returnList.add(new int[] {i});
			}
		}
		for(int[] p : returnList) {
			int index=0;
			if(index < returnList.size()-1) {
				retunString = retunString + p[index]+ ",";
			}else if(index<returnList.size()) {
				retunString = retunString+p;
			}
			index++;

		}
		return retunString;
	}

	//배열의 합 구하기
	public static int sumArray(int[] array) {

		int returnArraySum = 0;

		for(int i=0; i<array.length; i++) {
			returnArraySum = returnArraySum + array[i];
		}
		
		return returnArraySum;
	}

	public static int stringCounterTarget(String parameterString,char target) {

		if(parameterString == "" || parameterString == null || parameterString.isEmpty()) {
			return -1;
		}

		int returnCounter = 0;

		for(int i=0; i<parameterString.length(); i++) {
			if(parameterString.charAt(i) == target) {
				returnCounter++;
			}
		}

		return returnCounter;
	}
}