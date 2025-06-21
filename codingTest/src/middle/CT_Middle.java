package middle;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.time.format.*;


public class CT_Middle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CTMiddle.numberSum();
		//CTMiddle.numberTwoAndThreeCount();
		//CTMiddle.stringReverse();
		//CTMiddle.maxNumberAndLocation();
		//CTMiddle.gugudan();
		//CTMiddle.stringTagerCounter();
		//CTMiddle.isPrime();
		//CTMiddle.wordCounter();
		//CTMiddle.stringReverseCheck();
		//CTMiddle.ascNumber();
		//CTMiddle.arraySum();
		//CTMiddle.linkedHashSetString();
		//CTMiddle.reverseNumber();
		//CTMiddle.reverseNumberCheck();
		//CTMiddle.gradeStudentCounter();
		//CTMiddle.longestWord();
		CTMiddle.onlyNumber();
	}

}

class CTMiddle {
	
	CTMiddle() {
		super();
	}

	public static void numberSum() {

		Scanner scanner = new Scanner(System.in);

		int sum = 0;
		int arrayLength = scanner.nextInt();

		for(int i=0; i<arrayLength; i++) {
			int num = scanner.nextInt();
			sum = sum + num;
		}
		System.out.println("숫자의 합 = " + sum);
	}

	public static void numberTwoAndThreeCount() {

		Scanner scanner = new Scanner(System.in);

		int twoCounter = 0;
		int threeCounter = 0;
		int arrayLength = scanner.nextInt();

		for(int i=0; i<arrayLength; i++) {
			int number = scanner.nextInt();

			if(number % 2 == 0) {
				twoCounter++;
			}else {
				threeCounter++;
			}
		}
 
		System.out.println(Arrays.toString(new int[] {twoCounter,threeCounter}));
	}

	public static void stringReverse() {

		Scanner scanner = new Scanner(System.in);

		String string = new StringBuilder(scanner.nextLine()).reverse().toString();

		System.out.println("문자열 뒤집기 = " + string);
	}

	public static void maxNumberAndLocation() {

		Scanner scanner = new Scanner(System.in);

		int num = 0;
		int maxNum = 0;
		int maxIndex = 0;
		int arrayLength = scanner.nextInt();
		int[] intArray = new int[arrayLength];

		for(int i=0; i<intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}
		System.out.println("Arrays.toString() = " + Arrays.toString(intArray));

		for(int i=0; i<intArray.length; i++) {
			if(intArray[i] > num ) {
				num = intArray[i];
				maxNum = intArray[i];
				maxIndex = i;
			}
		}
		System.out.println(maxNum+ "," +maxIndex);
	}

	public static void gugudan() {

		Scanner scanner = new Scanner(System.in);

		int gugudan = scanner.nextInt();

		for(int i=1; i<=9; i++) {
			System.out.println(gugudan + " * " + i + " = " + gugudan*i);
		}
	}

	public static void stringTagerCounter() {

		Scanner scanner = new Scanner(System.in);

		String string 	=	scanner.nextLine();
		char 	target 	=	scanner.nextLine().charAt(0);
		int 	counter	=	0;
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i) == target) {
				counter++; 
			}
		}
		System.out.println("특정 문자 세기 = " + counter);
	}

	public static void isPrime() {

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		boolean isPrime = false;

		if(number <= 0) {
			System.out.println("정수를 입력해 주세요 (Ex:1, 2, 3, 4, 5)");
		}else if(number == 1) {
			isPrime = true;
			System.out.println(isPrime);
		}

		for(int i=2 ; i<=Math.sqrt(number); i++) {
			if(number % i != 0) {
				isPrime = true;
			}else {
				isPrime = false;
			}
		}
		System.out.println(isPrime);
	}

	public static void wordCounter() {

		Scanner scanner = new Scanner(System.in);

		int retunrnCounter = 0;
		String word = scanner.nextLine();

		String[] wordArray = word.split(" ");
		
		for(int i=0; i<wordArray.length; i++) {
			retunrnCounter ++;
		}

		System.out.println(retunrnCounter);
	}

	public static void stringReverseCheck() {

		Scanner scanner = new Scanner(System.in);
		boolean isfalse = false;
		String originalString = scanner.nextLine();
		String reverseString = new StringBuilder(originalString).reverse().toString();
		System.out.println(originalString+", "+ reverseString);

		if(originalString.equals(reverseString)) {
			isfalse = true;
		}
		System.out.println(isfalse);
	}

	public static void ascNumber() {

		Scanner scanner = new Scanner(System.in);

		int arrayLength = scanner.nextInt();
		Integer[] intArray = new Integer[arrayLength];

		for(int i=0; i<intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}
		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray));
	}

	public static void arraySum() {

		Scanner scanner = new Scanner(System.in);

		int arrayLength = scanner.nextInt();
		int[] arrayOne = new int[arrayLength];
		int[] arrayTwo = new int[arrayLength];
		int[] returnArraySum = new int[arrayOne.length];
		
		for(int i=0; i<arrayLength; i++) {
			arrayOne[i] = scanner.nextInt();
			arrayTwo[i] = scanner.nextInt();
		}

		for(int i=0; i<returnArraySum.length; i++) {
			returnArraySum[i] = arrayOne[i] + arrayTwo[i];
		}

		System.out.println(Arrays.toString(returnArraySum));
	}

	public static void linkedHashSetString() {

		Scanner scanner = new Scanner(System.in);

		Set<Character> set = new LinkedHashSet();
		String string = scanner.nextLine();
		String returnString = "";

		for(int i=0; i<string.length(); i++) {
			set.add(string.charAt(i));
		}
		Iterator<Character>iterator = set.iterator();

		while(iterator.hasNext()) {
			returnString = returnString + iterator.next().toString();
		}
		System.out.println(returnString);
	}

	public static void reverseNumber() {

		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();
		int returnNum = 0;

		while(num !=0) {
			int digit = num % 10;
			//애 반환할꺼임
			returnNum = returnNum * 10 + digit;
			num = num / 10;
		}

		System.out.println(returnNum);

	}
	
	public static void reverseNumberCheck() {

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		int originalNumber = number;
		int reverseNumber = 0;

		while(number != 0) {
			int digit = number % 10;
			reverseNumber = reverseNumber * 10 + digit;
			number = number / 10;
		}
		System.out.println(originalNumber + "," + reverseNumber);
		
		System.out.println(originalNumber == reverseNumber ? true : false);
	}

	public static void gradeStudentCounter() {
		
		Scanner scanner = new Scanner(System.in);

		int arrayLength = scanner.nextInt();
		int returnCounter = 0;
		int sum = 0;
		int[] intArray = new int[arrayLength];

		for(int i=0; i<arrayLength; i++) {
			intArray[i] = scanner.nextInt();
			sum = sum + intArray[i];
		}
		int averageNumber = sum / arrayLength;

		for(int i=0; i<intArray.length;i++) {
			if(intArray[i] >= averageNumber) {
				returnCounter++;
			}
		}
		System.out.println(returnCounter);
	}

	public static void longestWord() {

		Scanner scanner = new Scanner(System.in);

		String returnString = "";
		String string = scanner.nextLine();
		Integer minNumber = Integer.MIN_VALUE; // -22억(처음 비교할값)

		String[] arrayString = string.split(" ");

		//System.out.println(arrayString.length + ", " + arrayString[0].length());

		 for(int i=0; i < arrayString.length; i++) {
			 int length = arrayString[i].length();
			 if(length > minNumber ) {
				 minNumber = length;
				 returnString = arrayString[i];
			 }
		 }
		 System.out.println(returnString);
	}

	public static void onlyNumber() {

		Scanner scanner = new Scanner(System.in);

		String string = scanner.nextLine();
		int returnNumber = 0;

		for(int i=0; i<string.length(); i++) {
			char  ch = string.charAt(i);
			if(ch < '0' || ch > '9') {
				continue;
			}else {
				//ch >= '0' || ch < '9'
				returnNumber = returnNumber * 10 + (ch - '0');
			}
		}
		System.out.println(returnNumber);
	}

}
