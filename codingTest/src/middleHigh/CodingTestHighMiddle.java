package middleHigh;

import java.io.*;
import java.math.*;
import java.time.*;
import java.time.format.*;
import java.lang.*;
import java.util.*;

public class CodingTestHighMiddle {
	public static void main (String[] args) {
		//CT_HighMiddle.stringReverseCheck();
		//CT_HighMiddle.check();
		//CT_HighMiddle.check2();
		//CT_HighMiddle.isPrimeCheck();
		//CT_HighMiddle.pibonacci();
		//CT_HighMiddle.pibonacciArray();
		//CT_HighMiddle.arrayPartSumCounter();
		//CT_HighMiddle.arrayRightRotate(); //(i+k%n)%n
		//CT_HighMiddle.arrayLeftRotate(); //(i-k+n)%n
		//CT_HighMiddle.twoStringCheck();
		//CT_HighMiddle.wordReverse();
		//CT_HighMiddle.prefixDuplicateRemove();
		CT_HighMiddle.numberCheck();
		
	}
}

class CT_HighMiddle {
	
	CT_HighMiddle() {
		super();
	}

	public static void stringReverseCheck() {

		Scanner scanner= new Scanner(System.in);
		
		String originalString = scanner.nextLine();
		String reverseString = new StringBuilder(originalString).reverse().toString();

		System.out.println(originalString.equals(reverseString) ? "YES" : "NO");
		
	}
	//괄호 체크
	public static void check() {

		Scanner scanner = new Scanner(System.in);
		//input = {[{}]}
		Stack<Character> stack = new Stack<Character>();
		String string = scanner.nextLine();
		boolean check = true;
		
		for(int i=0; i<string.length();i++) {
			char ch = string.charAt(i);
			if(ch == '(' || ch =='{' || ch == '[' || ch ==']' || ch == '}' || ch == ')') {
				if(ch == '{' || ch =='[' || ch == '(') {
					stack.push(ch);
				}else if(ch =='}' || ch == ']' || ch == ')') {
					if(stack.isEmpty()) {
						check = false;
						break; // for문을 돌 필요도 없음
					}else {
						char top = stack.pop();
						if(ch == ')' && top != '(') {
							check = false;
							break;// for문을 돌 필요도 없음
						}else if(ch == ']' && top !='[') {
							check = false;
							break; //for문을 돌 필요도 없음
						}else if(ch == '}' && top != '{') {
							check = false;
							break; //for문을 돌 필요도 없음
						}
					}
				}
			}else {
				check = false;
				break;// 괄호외에 다른 문자열이 들어온것이므로 괄호의 유효성을 검사할 수 없음.
			}
		}
		//인풋 괄호가 "({[([{" 만 올경우 짝이 맞는 괄호가 아니므로, 스택이 비어있지 않음
		//고로 stack.isEmpty()로 스택이 비어있는지 검사하여 비어있지않으면
		//check == false;
		if(!stack.isEmpty()) {
			check = false;
		}
		
		System.out.println(check);
	}

	public static void isPrimeCheck() {
		
		Scanner scanner = new Scanner(System.in);
		
		int length = scanner.nextInt();
		int counter = 0;

		
		for(int i=0; i<length; i++) {
			int num = scanner.nextInt();
			// Ex 4,3 일 경우 4가 소수가 아므므로
			//check = false로 변경
			//후에 3은 소수 이지만 for문을 타지 못하므로
			//check 가 = ture 가되지못해 conter를 할 수 없음
			//그러므로 check를 for문을 순회할 때마다 true로 초기화
			boolean check = true;
			if(num <= 1) {
				check = false;
			}else if(num >= 2) {
				for(int j=2; j<=Math.sqrt(num); j++) {
					if(num % j == 0) {
						check = false;
						break; //2중 for문 탈출(J)
					}
				}
			}
			if(check) {
				counter++;
			}
			System.out.println("num = " + num +", counter = " + counter );
		}
		scanner.close();
		System.out.println(counter);
	}
	public static void check2() {

		Scanner scanner = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		//input = ()
		String string = scanner.nextLine();
		boolean check = true;
		for(int i=0; i<string.length(); i++) {
			char ch = string.charAt(i);
			if(ch =='(') {
				stack.push(ch);
			}else if(ch == ')') {
				if(stack.isEmpty()) {
					check = false;
					break;
				}else {
					stack.pop();
				}
			}else { // 소괄호 이외의 문자는 검사하지 않음
				check =false;
				break;
			}
		}
		//인풋 괄호가 "(((((" 만 올경우 짝이 맞는 괄호가 아니므로, 스택이 비어있지 않음
		//고로 stack.isEmpty()로 스택이 비어있는지 검사하여 비어있지않으면
		//check == false;
		if(!stack.isEmpty()) {
			check = false;
		}
		System.out.println(check);
	}

	public static void pibonacci() {

		Scanner scanner = new Scanner(System.in);

		int length = scanner.nextInt();
		int prev = 0;
		int current = 1;

		if(length == 0) {
			System.out.println(prev);
		}else if(length == 1) {
			System.out.println(prev + ", " + current);
		}else if(length >= 2) {
			for(int i=2; i<=length; i++) {
				int temp = current;
				current = prev + current;
				prev = temp;
			}
		}
		
		System.out.println(current);
	}

	public static void pibonacciArray() {

		Scanner scanner= new Scanner(System.in);

		int length = scanner.nextInt();
		int[] intArray = new int[length+1];

		if(length == 0) {
			intArray[0] = 0;
			System.out.println(intArray[0]);
		}else if(length ==1) {
			intArray[0] = 0;
			intArray[1] = 1;
			System.out.println(intArray[0]+", " + intArray[1]);
		}else if(length >=2) {
			intArray[0] = 0;
			intArray[1] = 1;
			StringBuilder sb = new StringBuilder();
			for(int i=2; i<intArray.length; i++) {
				intArray[i] = intArray[i-2] + intArray[i-1];
			}
			for(int i=0; i<intArray.length; i++) {
				sb.append(intArray[i]);
				if(i<(intArray.length-1)) {
					sb.append(", ");
				}
			}
			System.out.println(sb);
		}
	}

	public static void arrayPartSumCounter() {
		
		Scanner scanner = new Scanner(System.in);

		int length = scanner.nextInt();
		int returnCounter = 0;
		int[] intArray = new int[length];

		for(int i=0; i<intArray.length;i++) {
			intArray[i]  = scanner.nextInt();
		}
		int target = scanner.nextInt();
		for(int i=0; i<intArray.length-1; i++) {
			for(int j=i+1; j<intArray.length; j++) {
				if(intArray[i] + intArray[j] == target) {
					returnCounter++;
				}
			}
		}
		System.out.println(returnCounter);
	}

	public static void arrayRightRotate() {

		Scanner scanner = new Scanner(System.in);

		int originalLength = scanner.nextInt();
		int[] intArray = new int[originalLength];

		for(int i=0; i<intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}

		//오른쪽 으로 'k'번 회전할 변수
		int rightRotate = scanner.nextInt();
		//오른쪽 으로 회전하기 위한 값 초기화 rightRotate = rightRotate % originalLength;
		rightRotate = rightRotate % originalLength;

		int[] returnArray = new int[originalLength];
		
		for(int i=0; i<returnArray.length;i++) {
			//오른쪽 초기화를 위한 공식 Array[(i+rightRotate%originalLength)%orginalLength] = array[i]
			returnArray[(i+rightRotate%originalLength)%originalLength]  = intArray[i]; 
		}

		String returnString = "";

		for(int i=0; i<returnArray.length; i++) {
			returnString = returnString +returnArray[i];
			if(i<returnArray.length-1) {
				returnString = returnString + " ,";
			}
		}
		System.out.println(returnString);
	}

	public static void arrayLeftRotate() {

		Scanner scanner= new Scanner(System.in);

		int orginalLength = scanner.nextInt();
		int[] intArray = new int[orginalLength];

		for(int i=0; i<intArray.length;i++) {
			intArray[i] = scanner.nextInt();
		}
		//왼쪽 회전을 위한 변수
		int leftArrayRotate = scanner.nextInt();
		//왼쪽 회전을 위한 값 초기화 leftArrayRotate = leftArrayRotate % originalLength;
		leftArrayRotate = leftArrayRotate % orginalLength;
		int[] returnArray = new int[orginalLength];

		for(int i=0; i<returnArray.length; i++) {
			//왼쪽 회전을 위한 공식  Array[(i-leftRightRotate+originalLength)%originalLength
			returnArray[(i-leftArrayRotate+orginalLength)%orginalLength] = intArray[i];
		}

		String returnString = "";

		for(int i=0; i<returnArray.length; i++) {
			returnString = returnString + returnArray[i];
			if(i<returnArray.length-1) {
				returnString = returnString + ", ";
			}
		}
		System.out.println(returnString);
	}

	public static void twoStringCheck() {

		Scanner scanner = new Scanner(System.in);

		String originalString = scanner.nextLine();
		char[] originalChar = originalString.toCharArray();
		String comparatorString = scanner.nextLine();
		Set<Character> set = new TreeSet<Character>(); // 문자 중복방지
		
		if( originalString.length() == comparatorString.length()) {
			for(int i=0; i<originalChar.length; i++) {
				for(int j=0; j<comparatorString.length(); j++) {
					if(originalChar[i] == comparatorString.charAt(j)) {
						set.add(originalChar[i]);
					}
				}
			}
		}
		List<Character> list = new ArrayList<Character>(set);
		String returnString = "";
		StringBuilder stringBuilder = new StringBuilder();
		//"StringBuilder" 와 "StirngBuffer"는 "Class" 이므로 
		//"String" 과 같이 + 연산자를 사용할 수 없다, 
		//각 클래스 객체의 append() 메서드 사용.
		//"String"이 '+'가 사용가능한 이유는 내부적으로 "StringBuilder"를 사용하여
		//"StringBuilder.append().toString()" 을 해주기 때문에 "String"은 "+" 가 가능
		for(int i=0; i<list.size(); i++) {
			stringBuilder.append(list.get(i));
			if(i<list.size()-1) {
				stringBuilder.append(" ");
			}
		}
		System.out.println(returnString);
	}

	public static void wordReverse() {

		Scanner scanner = new Scanner(System.in); 

		String word = scanner.nextLine();
		String[] wordArray = word.split(" ");
		List<String> wordList = new ArrayList<String>();

		for(int i=0; i<wordArray.length;i++) {
			String reverseString = new StringBuilder(wordArray[i]).reverse().toString();
			wordList.add(reverseString);
		}

		StringBuilder stringBuilder = new StringBuilder();

		for(int i=0; i<wordList.size(); i++) {
			stringBuilder.append(wordList.get(i));
			if(i < wordList.size()-1) {
				stringBuilder.append(" ");
			}
		}
		System.out.println(stringBuilder.toString());
	}

	public static void twoNumberSumTargetCounter() {

		Scanner scanner = new Scanner(System.in);

		int length = scanner.nextInt();
		Set<Integer> set = new TreeSet<Integer>();
		for(int i=0; i < length; i++) {
			set.add(scanner.nextInt());
		}
		List<Integer> list = new ArrayList<Integer>(set);
		int targetNumber = scanner.nextInt();
		int returnCounter = 0;

		for(int i=0; i<list.size()-1; i++) {
			for(int j=i+1; j<list.size(); j++) {
				if(list.get(i) + list.get(j) == targetNumber) {
					returnCounter ++;
				}
					
			}
		}
		System.out.println(returnCounter);
	}

	public static void prefixDuplicateRemove() {
		System.out.println("여기들어옴?");
		Scanner scanner = new Scanner(System.in); 

		int length = scanner.nextInt();
		scanner.nextLine();
		String[] stringArray = new String[length];
		System.out.println(stringArray.length);
		for(int i=0; i< stringArray.length;i++) {
			System.out.println("i = " + i);
			stringArray[i] = scanner.nextLine();
		}
		System.out.println(Arrays.toString(stringArray));
		boolean[] check = new boolean[length];
		
		for(int i=0; i<stringArray.length; i++) {			// 0 		1		2			3
			String comparatorString = stringArray[i]; // apple,apply,application,app 
			for(int j=0; j<stringArray.length;j++) {
				//"j = 1" apply.stratsWith(apple(i=0)) false, "j=2" applicaion.startsWith(apple) false, "j=3" app.stratsWith(apple)
				//"j = 0" apple.startsWith(apply(i=1)) false, "j=2" application.startsWith(apply) false, "j=3" app.startsWtih(apply)
				//"j = 0" apple.startsWith(application(i=2)) false, "j=1" apply.startsWtih(application) false, "j=3" app.startsWith(application) false
				//"j = 0" apple.startsWith(app(i=3)) true, "j=1" apply.startsWith(app) true, "j=2" application.startsWith(app)
				if(i != j && stringArray[j].startsWith(comparatorString)) {
					check[j] = true;
				}
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		String returnString = "";
		for(int i=0; i<check.length; i++) {
			if(!check[i]) { // 접두사만 남김.
				returnString =stringBuilder.append(stringArray[i]).append(" ").toString().trim();
			}
			/*
			else { //접두사를 제외한 고유문자만 남김
				
			}
			*/
		}
		System.out.println(returnString);
	}
	//등차 수열 판별
	public static void numberCheck() {

		Scanner scanner = new Scanner(System.in);

		int length =scanner.nextInt();
		int[] intArray = new int[length];

		for(int i=0; i<intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}

		boolean check = true;
		//5			- 		3 = 2 
		//각 행들간의 값이 "2"씩 차이나야함 3,5,7,9,11,13~~~
		int checkNumber = intArray[1] - intArray[0]; 
		//등차수열이 맞는지 비교하기 위한 변수 초기화 = Array[1(i)] - Array[0(i-1)
		for(int i=2; i<intArray.length;i++) {
			int number = intArray[i] - intArray[i-1];
			if(number != checkNumber) {
				check = false;
				break; //한번이라도 긱 행들간의 값들이 "2" 씩 값이 차이가 안날 경우 
						//등차수열이 아님 그러므로 for문을 순회 할 필요없이 break;
			}
		}
		System.out.println(check ? "등차수열 : YES" : "등차수열 : NO");
	}
}
