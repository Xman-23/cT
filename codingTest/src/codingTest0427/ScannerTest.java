package codingTest0427;

import java.util.*;
import java.io.*;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringReverse.stringReverse();
	}

}

class StringReverse {

	StringReverse() {
		super();
	}

	public static void stringReverse() {
		Scanner scanner = new Scanner(System.in);
		//n번을 입력받아 뒤집을 변수
		int number = scanner.nextInt();
		scanner.nextLine(); //개행 문자 버리기
		String string = "";
		// 입력받은 n 이 Stirng[] 배열의 Length로 설정 n = 3이면 StringLength = 3 index = 0,1,2 입력가능
		String[] stringReverseArray = new String[number];
		for(int i=0; i<number; i++) {
			//3번 입력을 받을 
			String inputString = scanner.nextLine();
			//뒤집을꺼임 StringBuilder 사용
			StringBuilder reverseStringBuilder = new StringBuilder(inputString).reverse();
			if(i<number-1) {
				string = string + reverseStringBuilder.toString() + ",";
			}else if(i<number) {
				string = string + reverseStringBuilder.toString();
			}
			stringReverseArray[i] = reverseStringBuilder.toString();
			System.out.println("reverseStringBuilder = " + string);
			System.out.println("stringReverseArray = " + Arrays.toString(stringReverseArray));
		};
	}
}
