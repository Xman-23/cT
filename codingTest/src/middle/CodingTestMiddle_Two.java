package middle;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class CodingTestMiddle_Two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CodingTest_Middle.arraySum(); // 배열 합하기
		//CodingTest_Middle.MaxAndMinNumber(); //배열에서 큰값, 작은값 찾기
		//CodingTest_Middle.reverseString(); //문자열 거꾸로 
		//CodingTest_Middle.numberSumer(); // 입력한 숫자를 다 더하기
		//CodingTest_Middle.isPrime(); 
		//CodingTest_Middle.gugudan();
		CodingTest_Middle.twoAndthreeCounter();
	}
}

class CodingTest_Middle {

	CodingTest_Middle() {
		super();
	}
	//배열의 
	public static void arraySum() {
		Scanner scanner = new Scanner(System.in);
		int forLength = scanner.nextInt();
		int returnNum = 0;
		scanner.nextLine();
		for(int i=0; i<forLength; i++) {
			int num = scanner.nextInt();
			returnNum = returnNum + num;
		}
		System.out.println("returnNum = " + returnNum);
	}
	//배열 큰값,작은값 구하기 (Set,List)
	public static void MaxAndMinNumber() {

		Scanner scanner = new Scanner(System.in);

		int forLength = scanner.nextInt();
		/* List로 개 어렵게 풀기
		List<Integer> list = new ArrayList<Integer>();

		scanner.nextLine(); //개행문자,탭 비우기

		for(int i=0; i<forLength; i++) {
			int num = scanner.nextInt();
			list.add(num);
		}

		Set<Integer> treeSet = new TreeSet<Integer>();
		Set<Integer> reverseTreeSet = new TreeSet<Integer>(Comparator.reverseOrder());

		for(int array : list) {
			int i = 0;
			treeSet.add(array);
			reverseTreeSet.add(array);
			i++;
		}
		*/
		Set<Integer> treeSet = new TreeSet<Integer>();
		Set<Integer> reverseTreeSet = new TreeSet<Integer>(Comparator.reverseOrder());
		
		 //Set으로 개 쉽게 풀기
		for(int i=0; i<forLength; i++) {
			int number = scanner.nextInt();
			treeSet.add(number);
			reverseTreeSet.add(number);
		}

		Iterator<Integer> setIterator = treeSet.iterator();
		Iterator<Integer> reverseSetIterator = reverseTreeSet.iterator();
		System.out.println("최소값 = " + setIterator.next());
		System.out.println("최대값 = " + reverseSetIterator.next()); 
	}
	//문자열 뒤집기
	public static void reverseString() {

		Scanner scanner = new Scanner(System.in);

		String string = scanner.nextLine();

		StringBuilder reverseStringBuilder= new StringBuilder(string).reverse();
		System.out.println("문자열 거꾸로 출력 =" + reverseStringBuilder.toString());
	}
	//주어진 숫자 다 더하기 Ex: input = 123, output =6
	public static void numberSumer() {

		Scanner scanner = new Scanner(System.in);
		//Ex : number = 123
		int number =  scanner.nextInt();
		scanner.nextLine();
		//반환할 변수
		int returnNumber = 0;

		while(number !=0) {
			int digit = number % 10;
			returnNumber = returnNumber + digit;
			number =number / 10;
		}

		System.out.println("리턴할 변수 = " + returnNumber);

	}
	//소수 판별기
	public static void isPrime() {

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		scanner.nextLine();
		//소수 판별하기 위한 boolean isPrime
		boolean isPrime = true;

		if(number <= 1) {
			isPrime = false;
			System.out.println(isPrime ? "Prime" : "NotPrime");
		}else if(number >= 2) {
			for(int i=2; i<=Math.sqrt(number); i++) {
				if(number % i == 0) {
					isPrime = false;
				}
			}
		}
		System.out.println(isPrime ? "Prime" : "Not Prime");
	}
	//구구단은 애자
	public static void gugudan() {
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt();
		System.out.println("number = " + number);
		for(int i=1; i<=9; i++) {
			System.out.println("구구단 = " + number + "*" + i + "=" + number*i);
		}
	}
	//짝수, 홀수 갯수 
	public static void twoAndthreeCounter() {

		Scanner scanner = new Scanner(System.in);

		int forLength = scanner.nextInt();
		int returnTwoCounter = 0;
		int returnThreeCounter = 0;
		int[] arrayLength = new int[forLength];
 

		for(int i=0; i<arrayLength.length; i++) {
			int number = scanner.nextInt();
			if(number % 2 != 0) {
				returnThreeCounter++;
			}else {
				returnTwoCounter++;
			}
		}

		System.out.println("짝수 갯수 = " + returnTwoCounter +", 홀수 갯수 = " + returnThreeCounter);
	}
}
