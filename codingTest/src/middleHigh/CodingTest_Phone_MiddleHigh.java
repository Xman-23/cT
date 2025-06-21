package middleHigh;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class CodingTest_Phone_MiddleHigh {
	public static void main(String[] args) {
		System.out.println("문자열 아나그램 = " + MethodPhoneMiddleHigh.stringAnangram("banana", "nabana"));
		System.out.println("괄호짝맞는지확인 = " + MethodPhoneMiddleHigh.isValid("({[]})"));
		System.out.println("부분배열에서 인덱스의 합이 대상인 인덱스(쌍) 반환 = " 
		                      + Arrays.toString(MethodPhoneMiddleHigh.twoSumArray(new int[] {2, 7, 11, 15}, 9)));
		List<int[]> list = MethodPhoneMiddleHigh.twoSumList(new int[] {2, 7, 3, 6}, 9);
		for(int[] index : list) {
			System.out.println("부분배열에서 인덱스의 합이 대상인 인덱스(List)반환 = " + Arrays.toString(index));
		}
		System.out.println("회문 확인 하기 = " + MethodPhoneMiddleHigh.isPalindrome(121));
		System.out.println("두 배열 합하고 오름차순으로 정렬하기 = " 
		                      + Arrays.toString(MethodPhoneMiddleHigh.twoSumArraySort(new int[] {11,22,344,11,1,2,3,4,5,6}, new int[] {1,2,3,4,111,555,333,4412,434412,3})));
		System.out.println("세 배열 합하고 오름차순으로 정렬하기 = " 
                + Arrays.toString(MethodPhoneMiddleHigh.threeArraySumSort(new int[] {11,22,344,11,1,2,3,4,5,6}, new int[] {1,2,3,4,111,555,333,4412,434412,3}, new int[] {4,5,12,56,12,6,868,2313,46,1234,57,8,122,3,56,3})));
		System.out.println("문자열을 숫자로 변환 =" + MethodPhoneMiddleHigh.stringToint("-4562"));
		System.out.println("접미사 찾기 = " + MethodPhoneMiddleHigh.lonestSuffix("banana"));
		System.out.println(MethodPhoneMiddleHigh.longestPrefixSuffix("banana"));
	}
}

class MethodPhoneMiddleHigh {

	MethodPhoneMiddleHigh() {
		super();
	}

	//두개의 문자열이 아나그램인지 확인하기 
	//아나그램은 문자열을 오름차순으로 정렬했을때 두문자가 똑같은지 확인
	public static boolean stringAnangram(String stringOne, String stringTwo) {

		if((stringOne == "" || stringOne == null || stringOne.isEmpty()) ||
		   stringTwo == "" || stringTwo== null || stringTwo.isEmpty()) {
			return false;
		}
		// "//s" => /s는 탭 개행문제 공백을 뜻함
		String replaceAllToLowerCaseStringOne = stringOne.replaceAll("//s","").toLowerCase();
		String replaceAllToLowerCaseStringTwo = stringTwo.replaceAll("//s","").toLowerCase();

		char[] arrayCharacterOne = replaceAllToLowerCaseStringOne.toCharArray();
		char[] arrayCharacterTwo = replaceAllToLowerCaseStringTwo.toCharArray();

		Arrays.sort(arrayCharacterOne);
		Arrays.sort(arrayCharacterTwo);
		
		System.out.println("arrayCharacterOne = " + Arrays.toString(arrayCharacterOne));
		System.out.println("arrayCharacterTwo = " + Arrays.toString(arrayCharacterTwo));
		
		return Arrays.equals(arrayCharacterOne, arrayCharacterTwo);
	}
	//괄호 짝 맞는지 확인
	public static boolean isValid(String parameterString) {

		Stack<Character> stack = new Stack<Character>();

		for(int index=0; index < parameterString.length(); index++) {
			char character = parameterString.charAt(index);
			if(character == '(' ||
			   character == '{' ||
			   character == '[' )
			{
				stack.add(parameterString.charAt(index));
			}else {
				if(stack.isEmpty()) {
					return false;
				}else {
					char stackPop = stack.pop();
					if(character == ')' && stackPop != '(' ||
					   character == '}' && stackPop != '{' ||
					   character == ']' && stackPop != '[') {
						return false;
					}
				}

			}
		}

		return stack.isEmpty();
	}
	//부분배열에서 인덱스의 합이 대상인 인덱스(쌍) 반환
	public static int[] twoSumArray (int[] array, int target) {

		if(array.length == 0 || array == null) {
			return null;
		}

		//Ex array= {2,7,11,15}, targer = 9 index(인덱스)[0,1]반환
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		

		for(int i=0; i < array.length; i++) {
			int compareResult = target - array[i];
			if(map.containsKey(compareResult)) {
				return new int[] {map.get(compareResult), i};
			}else {
				map.put(array[i], i);
			}
	
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	//부분배열에서 인덱스의 합이 대상인 인덱스(List) 반환
	public static List<int[]> twoSumList (int[] array, int target) {

		if(array.length == 0 || array == null) {
			return null;
		}
		//Ex array = {2,7,3,6}, target = 9 index [0,1],[2,3];
		List<int[]> returnList= new ArrayList<int[]>();
		Map<Integer,Integer> arrayMap = new HashMap<Integer, Integer>();

		for(int index = 0; index < array.length; index++) {
			int compareResult = target - array[index];
			if(arrayMap.containsKey(compareResult)) {
				returnList.add(new int[] {arrayMap.get(compareResult), index});
			}else {
				arrayMap.put(array[index], index);
			}
		}
		return returnList;
	}
	//회문(필렌드롬) 문자가 뒤집었을때 똑같은지 판별(boolean) Ex) 121 -> 뒤집어도 121
	public static boolean isPalindrome(int number) {

		if(number <= 0) {
			return false;
		}
		//비교할 원본 값;
		int originalNumber = number;
		//비교할 거꾸로 값
		int reverseNumber =0;
		// returnBoolean
		boolean returnBoolean =false;
		//number =121;
		//회문 시작 while
		while(number != 0) {
			int digit = number % 10;
			reverseNumber = reverseNumber * 10 +digit;
			number  = number /10;
		}
		returnBoolean = originalNumber == reverseNumber;
		return returnBoolean;
	}
	//두개의 배열 합하고 오름차순
	public static int[] twoSumArraySort(int[] arrayOne, int[] arrayTwo) {

		if((arrayOne.length == 0 || arrayOne == null) ||
		   (arrayTwo.length == 0 || arrayTwo == null)) {
			return null;
		}
		int[] returnArraySort = new int[arrayOne.length+arrayTwo.length];
		//System.arraycopy(arrayOne,0,returnArraySort,0,arrayOne.length);
		//System.arraycopy(arrayTwo, 0, returnArraySort, arrayOne.length, arrayTwo.length);

		for(int index=0; index < arrayOne.length; index ++) {
			returnArraySort[index] = arrayOne[index];
		}
		for(int index=0; index <arrayTwo.length; index++) {
			//첫번째 배열을 복사한후에 
			//첫번째 length 자리 부터 두번째 배열을 합해야한다
			//근데 [arrayOne.length]만 명시할시 한자리에만 값이 대입 된다.
			//그러므로 arrayOne.length+index를 해줘야한다.
			returnArraySort[arrayOne.length + index] = arrayTwo[index];
		}

		System.out.println("Arrays.toString() = " + Arrays.toString(returnArraySort));
		Arrays.sort(returnArraySort);
		System.out.println("배열 정렬 =  " + Arrays.toString(returnArraySort));
		return returnArraySort;
	}

	//세개의 배열을 합하고 정렬하기
	public static int[] threeArraySumSort(int[] arrayOne, int[] arrayTwo, int[] arrayThree) {

		if(	(arrayOne.length == 0 || arrayOne == null) ||
			(arrayTwo.length == 0 || arrayTwo == null) ||
			(arrayThree.length == 0 | arrayThree == null) ) {
			return null;
			}

		int[] returnArray = new int[arrayOne.length+arrayTwo.length+arrayThree.length];
		//배열 복사하기 System.arraycopy(복사할 배열,어디부터 복사할지 시작부분,복사당할 배열,복사당할배열의 어디서부터 시작할지,복사할 배열의 어디까지 복사할껀지)		System.arraycopy(arrayOne, 0, arrayThree, 0, 0);
		System.arraycopy(arrayOne, 0, returnArray, 0, arrayOne.length);
		System.arraycopy(arrayTwo, 0, returnArray, arrayOne.length, arrayTwo.length);
		System.arraycopy(arrayThree, 0, returnArray, arrayOne.length+arrayTwo.length, arrayThree.length);
	
		/*
		 for(int i=0; i<arrayOne.length; i++) { returnArray[i] = arrayOne[i]; }
	
		 for(int i=0; i<arrayTwo.length; i++) { returnArray[arrayOne.length+i] = arrayTwo[i]; }
 
		 for(int i=0; i<arrayThree.length; i++) {returnArray[arrayOne.length+arrayTwo.length+1] = arrayThree[i]; }
		 */
		Arrays.sort(returnArray);
		
		return returnArray;
	}

	public static int stringToint(String string) {

		if(string == "" || string == null || string.trim().isEmpty()) {
			return -1;
		}

		int returnNumber = 0;
		boolean isNegative = false; // 양수, 음수 판별;

		if(string.charAt(0) == '-' ) {
			isNegative = true; //true이면 음수 '-'
			string = string.substring(1);
		}
		
		for(int i=0; i<string.length(); i++) {
			char character = string.charAt(i);
			// '0'은 아스키 코드로 48, '9' 아스키 코드 57
			// 즉 아스키 코드로 48보다 작은것
			// 57보다 큰것 Ex: 특수문자, a(65)~z, A(97)~Z 은 숫자로 바꿀 수 없으므로
			//return -1
			if(character < '0' || character > '9' ) {
				return -1;
			}else {
				returnNumber = returnNumber * 10 + (character - '0');
			}
		}
		//isNegative 가 true면 음수(-), false면 양수(+)
		return (isNegative) ? -returnNumber : returnNumber;
	}
	//가장 긴 접미사 찾기
	public static String lonestSuffix(String string) {
		
		if(string == "" || string == null || string.trim().isEmpty()) {
			return "-1";
		}

		String returnString = "";

		//banana (length=6, index=5)
		//012345 
		//  i= 1 anana,a, i=2 nana,na, i=3 ana,ana
		//  i= 4 na,nana, i=5 a,anan 
		for(int startIndex = 1,
				 endIndex = string.length()-1;
				 startIndex < string.length();
				 startIndex++,endIndex--) {
			//if(stirng.substring(stratIndex).equals(stirng.substirng(string.lenghth()-startIndex))
			if(string.substring(startIndex).equals(string.substring(endIndex))) {
				returnString = string.substring(startIndex);
			}
		}

		return returnString;
	}
	
	public static String longestPrefixSuffix(String s) {
	    int n = s.length();

	    // 접두사와 접미사의 길이가 1 이상인 경우부터 검사
	    for (int i = 1; i <= n / 2; i++) {
	        String prefix = s.substring(0, i);  // 접두사
	        String suffix = s.substring(n - i);  // 접미사

	        if (prefix.equals(suffix)) {
	            return prefix;  // 일치하는 접두사와 접미사가 있으면 반환
	        }
	    }

	    return "";  // 일치하는 접두사와 접미사가 없으면 빈 문자열 반환
	}
}
