package middleHigh;

import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.lang.*;
import java.math.*;

public class CodingTest_MiddleHigh {
	public static void main(String[] args) {
		System.out.println("isVaildParenTheses = " + Method_Three.isVaildParenTheses("({[]})"));
		System.out.println("최대공약수 = " + Method_Three.gcd(4, 6));
		System.out.println("최소공배수 = " + Method_Three.lcm(4, 6));
		System.out.println("파보나치 = " + Method_Three.pabonacci(3));
		System.out.println("파보나치 배열 = " + Arrays.toString(Method_Three.pabonacciArray(2)));
		System.out.println("특정 문자 갯수 세기 = " + Method_Three.conterString("banana", 'a'));
		System.out.println("배열내 중복 원소와 갯수 찾기 (원소,Counter)= " + Method_Three.containsElemental(new int[] {1,2,3,4,5,1,2,3,4,5,6,6,7,8,8,4,4,3,3,1,2,3,9}));

		try {
			System.out.println("배열 내에서 더했을때, 타겟과 같은값이 나오는 인덱스 찾기 = " + Arrays.toString(Method_Three.arrayTargetSumIndex(new int[] {1,2,3,4,5,1,2,3,4,5,6,6,7,8,8,4,4,3,3,1,2,3,9},10)));
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		List<int[]> list = Method_Three.arrayTargetSumIndexMore(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}, 12);
		for(int[] p : list) { // List<int[]> 이므로 int[] 배열을 꺼내서 사용할 수 있다.
			System.out.println("p = "+ p); //배열을 의미
			//배열을 볼려면은 Arrays.toString() 사용
			System.out.println("Arrays.toString()"+ Arrays.toString(p)); //List의 사이즈(length)만큼 순회 하여 배열을 보여줌
		}
		
	}
}

class Method_Three {

	Method_Three() {
		super();
	}
	//괄호 짝 맞추기
	public static boolean isVaildParenTheses(String parameterString) {

		Stack<Character> stack = new Stack<Character>();
		char[] characterArray = parameterString.toCharArray();

		for(char parameterCharacter : characterArray) {

			if(parameterCharacter == '(' 
			|| parameterCharacter == '[' 
			|| parameterCharacter == '{') {
				stack.push(parameterCharacter);
			}else {
				//stack이 비어 있다는것은 괄호의 종류가 들어 있지 않다는것.
				if(stack.isEmpty()) {
					return false;
				//stack이 비어 있지 않다는것은 괄호의 종류가 들어있다는것.
				}else {
					char vaildCharacter = stack.pop();
					//괄호 짝 맞추기
					if(parameterCharacter == '}' && vaildCharacter != '{') {
						return false;
					}else if(parameterCharacter == ']' && vaildCharacter != '[') {
						return false;
					}else if(parameterCharacter == ')' && vaildCharacter != '(') {
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}
	// 최대 공약수(GCD) 구하기
	public static int gcd(int numberOne, int numberTwo) {

		int returnNumber = 0;
		//numberTwo 가 while문의 조건에 사용
		//numberOne 가 return 값
		while(numberTwo != 0) {
			int temp = numberOne % numberTwo;
			numberOne = numberTwo;
			numberTwo = temp;
		}

		returnNumber =numberOne;

		return returnNumber;
	}
	
	public static int lcm(int numberOne, int numberTwo) {

		int gcd = 0;
		int gcdNumberOne = numberOne;
		int gcdNumberTwo = numberTwo;
		int lcmNumberOne = numberOne; // 최소공배수 곱하기에 쓸 변수
		int lcmNumberTwo = numberTwo; // 최소 공배수 곱하기에 쓸 변수
		int returnNumber = 0;
		//numberTwo가 while문에 조건식으로 사용
		//numberOne이 return값에 사용
		while(numberTwo != 0) {
			int temp = gcdNumberOne % gcdNumberTwo; // 첫번째 4 % 6, 두번째 6 % 4, 세번째  4 % 2
			//얘가 최대 공약수가 될꺼임 파라미터 첫번째로 온것.. (ex numberOne)
			gcdNumberOne = gcdNumberTwo; // 첫번째 6, 두번째 4 , 세번째 2 
			gcdNumberTwo = temp; // 첫번째 4, 두번째 2, 세번째 0
		}
		
		gcd = gcdNumberOne;

		returnNumber = lcmNumberOne * lcmNumberTwo / gcd;

		return returnNumber;
	}
	//파보나치
	public static int  pabonacci (int computerIndex) {

		if(computerIndex <= 1) {
			return computerIndex;
		}

		int prev = 0;
		int current = 1;
		int temp = 0;
		int returnNumber = 0;
		//컴퓨터 인덱스 기준
		for(int i=2; i<= computerIndex; i++) {
			temp = current;
			// 얘가 파보나치수열의 정답임, returnNumber
			current = prev + current;
			prev = temp;
		}

		returnNumber = current;

		return returnNumber;
	}
	//파보나치 배열 
	public static int[] pabonacciArray (int computerIndex) {
		
		//computerIndex +1을 해준이유는 computerIndex는 0부터 시작하므로 
		//배열의 length를 computerIndex+1을 해줘야지만 원하는 값이 다 들어간다.
		//ex) computerIndex만 했을경우 예를 들어 3이면, 네개의 배열이 채워지는것이 아닌 세개의 배열이 채워진다.
		int[] returnArray = new int[computerIndex+1]; 
		
		if(computerIndex == 0) {
			return new int[] {0};
		}else if(computerIndex == 1) {
			return new int[] {0,1};
		}else if(computerIndex > 1) {
			returnArray[0] = 0;
			returnArray[1] = 1;
		}

		//index = 2 부터 시작 왜?? 0,1번째 인덱스는 0,1로 고정해놨기때문에 2번째 인덱스 부터 시작
		for(int index = 2 ; index<returnArray.length; index++) {
			returnArray[index] = returnArray[index -2] + returnArray[index -1];
		}
		
		return returnArray;
	}

	public static int conterString (String parameterString, char target) {

		if(parameterString == "" || parameterString == null || parameterString.isEmpty()) {
			return -1;
		}

		int returnCounter = 0;

		for(int index = 0; index < parameterString.length(); index++) {
			if(parameterString.charAt(index) == target ) {
				returnCounter ++;
			}
		}
		return returnCounter;
	}
	//배열에 타겟과 같은 값이 있는지 판별(true,false)
	public static boolean containsValue(int[] arr, int target) {

		for(int index=0; index < arr.length; index++) {
			if(arr[index] == target) {
				return true;
			}
		}

		return false;
	}
	//배열내 중복원소 카운터 세기 (map.key(arr[i]),map.value(map.get(arr[i])+1);
	public static Map<Integer, Integer> containsElemental(int[] arr) {

		//.배열내에 중복원소가 몇개 있는지 카운트할 Map
		//Map<중복원소,카운터>
		//Map<Integer,Integer(Counter)
		System.out.println("Arrays.toString() =" + Arrays.toString(arr) );
		Map<Integer,Integer> returnMap = new HashMap<Integer, Integer>();
 
		for(int index=0; index < arr.length; index++) {
			if(returnMap.containsKey(arr[index])) {
				returnMap.put(arr[index], returnMap.get(arr[index])+1);
			}else {
				//            Map<중복원소,카운터>
				returnMap.put(arr[index], 1);
			}
		}

		return returnMap;
	}
	
	public static boolean hasDuplicate(int[] arr) {

		Set<Integer> set = new HashSet<Integer>();

		for(int index = 0; index < arr.length; index++) {
			if(set.contains(arr[index])) {
				return true;
			}else {
				set.add(arr[index]);
			}
		}

		return false;
	}
	//배열에서 더했을때 대상과 같은 인덱스(쌍) 찾기
	//한쌍 찾기 (map.get(compareResult),index)
	public static int[] arrayTargetSumIndex(int arr[], int target) {

		if(arr.length == 0 || arr == null) {
			return null;
		}
		// 배열 예시 {2,7,11,15} , 타겟 9 
		//Map<값과, 그값이 저장된 인덱스>
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();

		for(int index = 0; index <arr.length; index ++) {
			//애가 비교 대상이 될 변수임.
			int result = target - arr[index];

			if(map.containsKey(result)) {
				return new int[] {map.get(result),index};
			}else {
				//처음에는 포함되어있는(containsKet()) Key가 없으므로 무조건 put 실행/
				// Map<값과, 그 값이 저장된 인덱스>
				map.put(arr[index], index);
			}
		}

		throw new ArrayIndexOutOfBoundsException("배열과 Target을 맞게 설정해주세요..");
	}
	//배열의 합이 target 과 같은 인덱스(쌍)을 찾는 문제(반환 타입 !!List사용!!,주의 Map을 반환하지 않음.)
	public static List<int[]> arrayTargetSumIndexMore(int arr[],int target) {

		//Ex: 예시 배열(2,7,3,6), Target = 9

		if(arr.length == 0 || arr == null) {
			System.out.println("정상적인 배열을 선언해주세요");
			return null;
		}
		List<int[]> returnList = new ArrayList<int[]> ();
		Map<Integer, Integer> returnMap = new HashMap<Integer,Integer>();

		System.out.println(Arrays.toString(arr));

		for(int index=0; index<arr.length;index++) {
			//1. 현재 빼짐을 당하는 target과 빼짐을 하는 arr[index] 의 값이
			int compareResult = target - arr[index];
			//2. 이전 인덱스의 값과 같다면은
			if(returnMap.containsKey(compareResult)) {
				//3. 이전 인덱스와 현재 인덱스를 더하면 target의 값이 되므로,
				//List 배열로 이전인덱스와,현재 인덱스를 넣어라.
				returnList.add(new int[] {returnMap.get(compareResult), index});
			}else {
				//0번째에는 무조건 키 값이 없으므로, 무조건 put을 실행하여라
				returnMap.put(arr[index], index);
			}
		}
		
		return returnList;
	}
	//배열 부분합이 대상과 같은지 카운터
	public static int arrayPartSumTargetCount(int[] array, int target) {
		
		if(array.length == 0 || array == null) {
			return -1;
		}

		// 리턴할 카운터의 값
		int returnCounter = 0;
		//array의 길이만큼 순회(for)하여라.
		for(int index=0; index<array.length; index++) {
			int sum = 0; //for문을 돌때마다 sum 값 초기화 왜?
							//sum이 누적이 되어있으면, 첫번째만 찾은 후에 target값을 찾을 수 없기때문
			//Ex 배열 : {1,2,3} target = 3,
			for(int endIndex = index; endIndex < array.length; endIndex++ ) {
				sum = sum + array[endIndex];
				if(sum == target) {
					returnCounter++;
				}
			}
		}

		return returnCounter;
	}
}
