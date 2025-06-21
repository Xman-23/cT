package middle;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class CodingTest_Middle_Two {
	public static void main(String[] args) {

		String testString = "You creat AndroidAAAAAnnnnnddddoooiidddddd";
		int num = 5;
		int[] numbersOne = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] numbersTwo = {10, 11, 12, 13, 14, 15, 16, 17, 18,19,20,21,22,23};
		int[] numbersThree = {17, 18,19,20,21,22,23};

		System.out.println("소수 판별 = " + Method_Middle_Two.isPrime(num));
		System.out.println("중복 문자 제거 = " + Method_Middle_Two.removeDuplicateChars(testString));
		System.out.println("두 배열 합하기 = " + Arrays.toString(Method_Middle_Two.mergedArray(numbersOne, numbersTwo)));
		System.out.println("세 배열 합하기 = " + Arrays.toString(Method_Middle_Two.mergedArray(numbersOne, numbersTwo,numbersThree)));
	}
}

class Method_Middle_Two {

	Method_Middle_Two() {
		super();
	}
	//소수 판별
	public static boolean isPrime(int n) {
		if(n <= 1) {
			return false;
		}
		//소수 인 2,3,5
		System.out.println(Math.sqrt(2));
		System.out.println(Math.sqrt(3));
		System.out.println(Math.sqrt(4));
		System.out.println(Math.sqrt(5));
		System.out.println(Math.sqrt(6));
		System.out.println(Math.sqrt(7));
		System.out.println(Math.sqrt(8));
		System.out.println(Math.sqrt(9));
		
		for(int i =2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	//중복 문자 제거
	public static String removeDuplicateChars(String str) {

		//Set 중복x ,순서 유지 x
		//HashSet 중복x, 순서 유지x
		//TreeSet  중복x,순서 유지x(오름차순)
		//LinkedHashSet 중복x,순서 유지o

		//문자열 검증
		if(str == null || str == "" || str.trim().isEmpty()) {
			return null;
		}
		
		Set<Character> set = new LinkedHashSet<Character>();
		String returnString = ""; // 불가변 클래스 문자열을 더할때마다 클래스를 생성해야하기때문에 불필요한 메모리 소모
		StringBuffer stringBuffer = null; // 가변 클래스 이기때문에 문자열을 자주 수정해도 String 처럼 클래스를 더할때마다 생성할 필요가 없다

		char[] charArray = str.trim().toCharArray();
		
		for(Character character  : charArray) {
			set.add(character);
		}

		if(set.size() <= 0) {
			return null;
		}
		System.out.println("set = " + set);
		Iterator<Character> iterator = set.iterator();

		while(iterator.hasNext()) {
			returnString = returnString + iterator.next().toString();
		}

		return returnString;
	}

	public static int[] mergedArray(int[] arrayOne, int[] arrayTwo) {

		System.out.println("arrayOne.length = " + arrayOne.length + ", arrayTwo.length = " + arrayTwo.length);
		
		int[] returnMergedArray = new int[arrayOne.length + arrayTwo.length ];
		System.out.println();
		//1,2,3,4,5,6,7,8,9
		//0,1,2,3,4,5,6,7,8
		//10,11,12,13,14,15,16,17,18
		//9, 10, 11,12,13,14,15,16,17
		
		for(int i=0; i < arrayOne.length; i++) {
			returnMergedArray[i] = arrayOne[i];
			System.out.println("i = ["+i+"], Arrays.toString = " + Arrays.toString(returnMergedArray));
		}
		//정해진 배열이 온다는 보장이 없기에 첫번째 배열길이만큼 채운후에 
		//두번째 배열을 넣을려면, 첫번째 배열의 인덱스의 끝 이후 즉 arrayOne.length
		//arrayOne.length+i(0)으로 시작하는것이 맞다.
		for(int i=0; i < arrayTwo.length; i++) {
			returnMergedArray[arrayOne.length+i] = arrayTwo[i];
			System.out.println("i = ["+i+"], Arrays.toString = " + Arrays.toString(returnMergedArray));
		}


		return returnMergedArray;
	}
	//메소드 오버로딩 (메소드의 이름은 같지만 파라미터의 갯수가 다르거나, 파라미터의 자료형이 달라야한다
	public static int[] mergedArray(int[] arrayOne, int[] arrayTwo, int[] arrayThree) {
		
		int[] returnMergedOne  = new int[arrayOne.length + arrayTwo.length + arrayThree.length];
		System.out.println("arrayOne.length = " + arrayOne.length);
		System.out.println("arrayTwo.length = " + arrayTwo.length);
		System.out.println("arrayThree.length = " + arrayThree.length);

		int arrayOneLength = arrayOne.length;
		int arrayTwoLength = arrayTwo.length;
		int arrayThreeLength = arrayThree.length;

		for(int i=0; i < arrayOneLength; i++) {
			returnMergedOne[i] = arrayOne[i];
		}

		for(int i=0; i < arrayTwoLength; i++) {
			returnMergedOne[arrayOneLength+i] = arrayTwo[i];
		}
		
		for(int i=0; i< arrayThreeLength;i++) {
			returnMergedOne[arrayOneLength+arrayTwoLength+i] = arrayThree[i];
		}
		
		/*
		 * // 배열 복사 
		 	System.arraycopy(arrayOne, 0, returnMergedOne, 0, arrayOne.length);
		  	System.arraycopy(arrayTwo, 0, returnMergedOne, arrayOne.length,arrayTwo.length); 
		  	System.arraycopy(arrayThree, 0, returnMergedOne,arrayOne.length + arrayTwo.length, arrayThree.length);
		 */
		return returnMergedOne;
	}

}
