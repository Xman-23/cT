package middleHigh;

import java.math.*;
import java.io.*;
import java.lang.*;
import java.lang.classfile.instruction.ReturnInstruction;
import java.time.*;
import java.time.format.*;
import java.util.*;


public class CodingTestMiddleHigh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MiddleHigh.arraySort(); //Scanner 배열 오름차순 정렬
		//MiddleHigh.twoArraySum();
		//MiddleHigh.factorial();
		//MiddleHigh.stringTagerCharacter();
		//MiddleHigh.oneFromNumberSum();
		//MiddleHigh.palindrome();
		//MiddleHigh.pabonacciArray();
		//MiddleHigh.arrayOfFindMaxNumberArraySort();
		//MiddleHigh.gcdAndlcd();
		MiddleHigh.d();
	}

}

class MiddleHigh {

	MiddleHigh() {
		super();
	}
	//Scanner,배열 오름차순
	public static void arraySort() {

		Scanner scanner = new Scanner(System.in);

		int[] arrayIndex = new int[scanner.nextInt()];

		for(int i=0; i<arrayIndex.length; i++) {
			arrayIndex[i] = scanner.nextInt();
		}

		Arrays.sort(arrayIndex);

		System.out.println("Arrays.sort(arrayIndex) = " + Arrays.toString(arrayIndex));

	}
	//Scanner 2차원 배열 대각선 합 구하기
	public static void twoArraySum() {

		Scanner scanner = new Scanner(System.in);

		int arrayLength = scanner.nextInt();
		int returnNumber = 0;
		int[][] twoArray = new int[arrayLength][arrayLength];
		System.out.println("Length 찍어보기 = " + twoArray.length + ", = "+twoArray[0].length  );
		for(int i=0; i<twoArray.length; i++) {
			for(int j=0; j<twoArray.length; j++) {
				twoArray[i][j] = scanner.nextInt();
				if(i==j) {
					returnNumber = returnNumber + twoArray[i][j];
				}
			}
		}
		System.out.println("returnNumber = " + returnNumber);
	}

	public static void factorial() {

		Scanner scanner = new Scanner(System.in);

		int factorialNumber= scanner.nextInt();

		if(factorialNumber<=0) {
			System.out.println("팩토리얼을 구할 수 가 없습니다 1이상의 숫자를 입력해주세요");
		}else {
			int resultNumber = 1;
			for(int i=1; i<= factorialNumber; i++) {
				resultNumber= resultNumber * i;
			}
			
			System.out.println(resultNumber);
		}
	}
	//Scanner 문자열에서 특정문자 갯수 세기
	public static void stringTagerCharacter() {

		Scanner scanner = new Scanner(System.in);
		int returnCounter= 0;
		char targetCharacter = scanner.nextLine().charAt(0);
		String string = scanner.nextLine();

		if((string == "" || string.isEmpty() || string == null)) {
			System.out.println("문자열을 제대로 입력해주세요.");
		}else {
			for(int i=0; i<string.length(); i++) {
				if(string.charAt(i) == targetCharacter) {
					returnCounter++;
				}
			}
		}
		System.out.println("특정문자 카운터 세기 = " + returnCounter);
	}
	//1부터 N 까지 합 구하기 ( 등차수열을 사용해서 합 구하기 (n * (n+1) /2) )
	public static void oneFromNumberSum() {

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt(); // 'N' 에 해당
		System.out.println("number = " + number);
		int resultNumber = number * (number+1) / 2; 
		
		System.out.println("등차수열 을 사용한 1부터 N까지의 합 = " + resultNumber);
	}
	
	public static void palindrome() {

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		int originalNumber = number; // 비교당할 회문의 원본 값
		int returnNumber =0; //비교할 회문의 거꾸로의 값
		boolean isPalindrome = false;

		while(number !=0) {
			int digit = number % 10;
			returnNumber = returnNumber * 10 + digit;
			number = number / 10;
		}
		if(originalNumber == returnNumber) {
			isPalindrome = true;
			System.out.println(isPalindrome ? "is Palindrome" : "is Not Palindrome");
		}else {
			System.out.println(isPalindrome ? "is Palindrome" : "is Not Palindrome");
		}
	}
	
	public static void pabonacciArray() {

		Scanner scanner = new Scanner(System.in);

		int pabonacciNumber = scanner.nextInt();
		int[] pabonacciArray = new int[pabonacciNumber];
		String returnPabonacciString = "";
		//인덱스가 0 으로 올때
		if(pabonacciNumber >= 0) {
			pabonacciArray[0] = 0;
		}
		//인덱스가 1로 올때
		if(pabonacciNumber >= 1) {
			pabonacciArray[1] = 1;
		}
		//indext = 2 부터 시작 왜?
		//인덱스 0과1은 앞에 if문으로 작업을 해놨으므로 indext = 2부터 시작
		for(int i=2; i<pabonacciArray.length; i++) {
			pabonacciArray[i] = pabonacciArray[i-2] + pabonacciArray[i-1];
		}

		for(int i=0; i<pabonacciArray.length; i++) {
			if(i<pabonacciArray.length-1) {
				returnPabonacciString  = returnPabonacciString+pabonacciArray[i]+",";
			}else if (i<pabonacciNumber) {
				returnPabonacciString = returnPabonacciString+pabonacciArray[i];
			}
		}
		System.out.println("피보나치 배열 = " + returnPabonacciString);
	}
	
	public static void arrayOfFindMaxNumberSet() {

		Scanner scanner = new Scanner(System.in);
		
		int returnNumber = 0;
		int arrayLength = scanner.nextInt();
		int findMaxNumber = scanner.nextInt();
		Integer[] array = new Integer[arrayLength];
		Set<Integer> treeSet = new TreeSet<Integer>(Comparator.reverseOrder());

		for(int i=0; i<array.length; i++) {
			array[i] = scanner.nextInt();
		}
		//Arrays.sort(array, Collections.reverseOrder());
		
		for(int i=0; i< findMaxNumber; i++) {
			treeSet.add(array[i]);
		}
		
		if(findMaxNumber > treeSet.size()) {
			System.out.println("정수가 충분하지 않습니다");
		}else  if (findMaxNumber <= treeSet.size()){
			Iterator<Integer> iterator = treeSet.iterator();
			for(int i=0; i<findMaxNumber; i++) {
				if(i < findMaxNumber-1) {
					iterator.next();
				}else if (i < findMaxNumber) {
					returnNumber= iterator.next();
					System.out.println(findMaxNumber + "번째 큰 정수 = " + returnNumber);
				}
			}
		}
	}
	public static void arrayOfFindMaxNumberArraySort() {

		Scanner scanner = new Scanner(System.in);
		
		int returnNumber = 0;
		System.out.print("Array의 Length를 입력해주세요 =");
		int arrayLength = scanner.nextInt();
		System.out.print("배열에서 몇번째 가장 큰 정수를 찾고 싶으신가요? ");
		int findMaxNumber = scanner.nextInt();
		//"T"는 객체를 의미 객체만 올 수 있음, "? super T" 는 T를 부모를 둔 객체만 들어와라
		//Arrays.sort(T[] , ? super T)
		Integer[] array = new Integer[arrayLength];
		for(int i=0; i<array.length; i++) {
			System.out.print("배열에 담을 숫자를 배열의 Length만큼 입력 해주세요 Counter (" + i + ") = ");
			array[i] = scanner.nextInt();
		}
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println(Arrays.toString(array));
		System.out.println(findMaxNumber + "번째 가장큰 정수의 값 =" + array[findMaxNumber-1]);
		
	}

	public static void gcdAndlcd() {

		Scanner scanner = new Scanner(System.in);

		int gcdNumberOne = scanner.nextInt();
		int gcdNumberTwo = scanner.nextInt();
		int lcdNumberOne = gcdNumberOne;
		int lcdNumberTwo = gcdNumberTwo;
		int returnNumber = 0;

		while(gcdNumberTwo != 0) {
			int temp = gcdNumberOne % gcdNumberTwo;
			gcdNumberOne = gcdNumberTwo;
			gcdNumberTwo = temp;
		}
		
		returnNumber = lcdNumberOne*lcdNumberTwo / gcdNumberOne;

		System.out.println("returnNumber =" + returnNumber );

	}

	public static void d () {

		Scanner scanner = new Scanner(System.in);
		//input = 5
		int arrayLength = scanner.nextInt();
		int[] array = new int[arrayLength+1];
		//index =1 인 이유는 int배열을 선언하면은 배열의 길이만큼 0으로 초기화 된다
		//그러므로 index 0 은 0으로 초기화 된 상태 이므로, 굳이 0부터 시작할 필요가 없다
		for(int i=1; i< array.length; i++) {
			//input = [5, 2, 4, 1, 3];
			array[i] = array[i-1] + scanner.nextInt();
			System.out.println("array["+i +"] =" + array[i]);
		}

		int q = scanner.nextInt();
		System.out.println(Arrays.toString(array));
		for(int i=0; i<q; i++) {
			int startMinuseOne = scanner.nextInt(); // input 2(사람기준)
			int end = scanner.nextInt();  //input 4 (사람기준)
			// 사람기준 4번째 값(인덱스 = 3)까지 포함한 값인 인덱스 4가 정답.
			System.out.println(array[end] - array[startMinuseOne-1]);
			 //start는 1이 입력되지만 
			//컴퓨터에서의 첫번째 자리는 인덱스 0 이기때문에 '-1' 처리를 해준후에, 
			//0,1,2,3(네번째자리) 까지의 모듭합을 구한 
			//5번째 자리를 의미하는 인덱스 4가 답
		}

	}
 }
