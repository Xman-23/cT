package easy;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class CodingTest_24_Easy {

	public static void main(String[] args) {
		int[] numbers = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7};
		String trimString = "  Hi Anna!     ";
		
		System.out.println("배열의 합 = " + Method.sumArray(numbers));
		System.out.println("중복 없는 짝수의 갯수 = " + Method.returnArray(numbers)[0] +"개, 중복없는 홀수의 갯수 = " + Method.returnArray(numbers)[1]+ "개");
		System.out.println("짝수의 갯수  = " + Method.returnArrayTreeSet(numbers)[0] + "개, 홀수의 갯수 = " + Method.returnArrayTreeSet(numbers)[1] + "개");
		System.out.println("문자열 뒤바꾸기 = " + Method.reverseString(trimString));
		System.out.println("최댓값 = " + Method.MaxNumber(numbers));
		System.out.println("최솟값 = " + Method.MinNumber(numbers));
		System.out.println("단어 몇개 ?? = " + Method.countWords(trimString) + " 개");
	}
}

class Method {

	public Method() {
		super();
	}

	//배열 합 문제
	public static int sumArray(int[] numbers) {
		
		if(numbers.length == 0 || numbers == null) {
			return -1;
		}

		int returnNumber = 0;

		for(int i=0; i<numbers.length; i++) {
			int num = numbers[i];
			returnNumber = returnNumber + num;
		}

		return returnNumber;
	}

	//짝수 , 홀수 갯수 찾기 문제
	public static int[] returnArray(int[] numbers) {

		if(numbers.length == 0 || numbers == null) {
			return null;
		}

		int returnTwoNumberCounter = 0;
		int returnThreeNumberCounter = 0;
		
		for(int i=0; i<numbers.length; i++) {
			int num = numbers[i];
			//0과 음수는 홀수, 짝수 로 취급을 할 수 없음
			if(num<=0) {
				continue; //num의 값이 0과 음수가 올경우 무시하고 다시 for문순회
			//1부터 홀수, 짝수 구분
			}else  {
				if(num % 2 == 0) {
					returnTwoNumberCounter ++;
				}else {
					returnThreeNumberCounter ++;
				}
			}
		}

		int[] returnArray = {returnTwoNumberCounter, returnThreeNumberCounter};
		return returnArray;
	}

	//배열에 중복이 있을 경우 중복을 제거하고 홀수,짝수 찾기
	public static int[] returnArrayTreeSet(int[] numbers) {

		if(numbers.length == 0 || numbers == null) {
			return null;
		}

		int returnTwoCounter = 0;
		int returnThreeCounter = 0;
		Set<Integer> set = new TreeSet<Integer>();

		for(int num : numbers) {
			if(num <= 0 ) {
				continue; // num 이 0과 음수가 올경우 짝수와 홀수를 판별할 수 없기에 무시하고 for:each 순회
			}else if( num >=1) {
				set.add(num);
			}
		}

		//set의 사이즈가 0과 같거나 작다면은 카운터를 셀수 없음..
		// "!<" = (>=) 이고, "!>" = (<=)이며, "!=" = (대상이 같거나(==) ,대상보다 작거나 큰값 (<,>)을 뜻한다) <= 와 >=는 안됨 왜 '='때문에
		if(set.size() <= 0) {
			return null;
		}
		
		Iterator<Integer> iterator = set.iterator();

		while(iterator.hasNext()) {
			int num = iterator.next();

			if(num <= 0) {
				continue;
			}else if (num >= 1) {
				if(num % 2 != 0) {
					returnThreeCounter ++;
				}else {
					returnTwoCounter ++;
				}
			}
		}


		int[] returnArray = {returnTwoCounter, returnThreeCounter};
		return returnArray;
	}

	public static String reverseString(String trimStringParameter) {
		
		if(trimStringParameter == null || trimStringParameter == "") {
			return "-1";
		}

		String returnString = "";
		/*String trimString = trimStringParameter.trim(); //앞뒤 공백만 제거

		//값 궁금해서 체그
		System.out.println("String.length() = " + trimString.length());
		System.out.println("String.charAt() = " + trimString.charAt(1));

		for(int i = trimString.length()-1; i>=0; i--) {
			returnString = returnString + trimString.charAt(i);
		}*/

		StringBuilder stringBuilder = new StringBuilder(trimStringParameter.trim());
		returnString = stringBuilder.reverse().toString();
		
		return returnString;
	}

	//가장 큰 값 찾기
	public static int MaxNumber(int[] numbers) {

		if(numbers.length == 0 || numbers == null) {
			return -1;
		}

		int returnMaxNumber = 0;
		Set<Integer> set = new TreeSet<Integer>(Comparator.reverseOrder());
		
		for(int num : numbers) {
			if(num < 0) {
				continue; //num이 '0'보다 작을 경우 음수이므로 set에 넣지 않는다
							//만약 음수도 같이 찾고 싶으면 if - else 삭제 하면 됨
			}else if(num >= 0) {
				set.add(num);
			}
		}
		System.out.println("Set = " + set);

		if(set.size() <= 0) {
			return -1;
		}

		 Iterator<Integer> iterator = set.iterator();
		 returnMaxNumber =  iterator.next();

		return returnMaxNumber;
	}

	//가장 작은 값 찾기
	public static int MinNumber(int[] numbers) {

		if(numbers.length == 0 || numbers == null) {
			return -1;
		}

		int returnMinNumber = 0;
		Set<Integer> set = new TreeSet<Integer>();
		
		for(int i=0; i<numbers.length; i++) {
			int num = numbers[i];

			if(num < 0) {
				continue;
			}else if(num >= 0) {
				set.add(num);
			}
		}

		if(set.size() <= 0) {
			return -1;
		}

		Iterator<Integer> iterator = set.iterator();
		returnMinNumber =  iterator.next();

		return returnMinNumber;
	}

	//단어 갯수 세기(공백기준)
	public static int countWords(String str) {

		if(str == null || str == "" || str.trim().isEmpty()) {
			System.out.println("*********************** 문자열 공백 확인 ***********************");
			return -1;
		}
		int returnWordLength = 0;
		String[] wordLength = str.trim().split(" ");
		returnWordLength = wordLength.length;

		return returnWordLength;
	}
}


