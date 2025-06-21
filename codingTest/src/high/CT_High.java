package high;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class CT_High {
	public static void main(String[] args) {
		//CTHigh.d();
		//CTHigh.dd();
		//CTHigh.ddd();
		CTHigh.dddd();
		//int max = Math.max(1,2);
		//System.out.println(max);
	}
}

class CTHigh {

	CTHigh() {
		super();
	}
	//괄호 짝 맞추기
	public static void d() {

		Scanner scanner = new Scanner(System.in);

		Stack<Character> stack = new Stack<Character>();
		String string = scanner.nextLine();
		boolean isFalse = false;

		for(int i=0; i<string.length(); i++) {
			char ch = string.charAt(i);
			if(ch == '(') {
				stack.push(ch);
			}else if(ch == ')') {
				//stack 비어있다는것은 '(' 없다는것이므로, 
				//짝 자체가 안 맞기 때문에 1중 for 문 탈출 break;
				if(stack.isEmpty()) {
					break;
				//stack 비어있지않다는것은 스택 안에 '('가 있다는것이므로
				//짝 비교
				}else {
					stack.pop(); //')' 맞을 경우 '('를 스택 안에서 꺼내면서 짝 맞추기
				}
			}
		}
		//짝이 맞다면은 stack 안에 '(' 다 비워지므로 공백이 된다 그러므로 is False
		if(stack.isEmpty()) {
			isFalse = true;
		}
		System.out.println(isFalse);
	}
	/*
	 19. 숫자 조합으로 특정 수 만들기
	🧠 풀이 설명
	입력받은 수들 중 3개를 골라 합이 K가 되는지 확인합니다.

	3중 for문을 사용해 모든 조합을 탐색합니다.
	*/
	public static void dd() {

		Scanner scanner = new Scanner(System.in);

		int arrayLength = scanner.nextInt();
		int targetNumber = scanner.nextInt();
		int[] intArray = new int[arrayLength];
		boolean returnBoolean = false;
		for(int i=0; i<intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}
		System.out.println(Arrays.toString(intArray));

		for(int i=0; i<intArray.length-2; i++) {
			for(int j=i+1; i<intArray.length-1;j++) {
				for(int l=j+1; i<intArray.length; l++ ) {
					if(intArray[i] + intArray[j] + intArray[j] == targetNumber) {
						returnBoolean = true;
						//3중 for문 탈출 (L)
						break;
					}
				}
				//2중 for문 탈출(J)
				if(returnBoolean) {
					break;
				}
			}
			//1중 for문 탈출(I)
			if(returnBoolean) {
				break;
			}
		}
		System.out.println(returnBoolean);
	}
	/*
	 20. 연속 부분합 최대값
	🧠 풀이 설명
	연속된 부분 수열의 최대 합을 구하는 문제 → Kadane's Algorithm 사용.

	현재 위치까지의 최대 연속 합을 유지하며 전체 최대값을 업데이트합니다.
	 */
	public static void ddd() {

		Scanner scanner = new Scanner(System.in);

		int arrayLength = scanner.nextInt();
		int[] intArray = new int[arrayLength];

		for(int i=0; i<intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}

		int sumCurrent	= intArray[0];
		int maxReturn 	= intArray[0];

		for(int i=1; i<intArray.length; i++) {
			int current = intArray[i];
			sumCurrent 	= Math.max(current, sumCurrent+current);
			maxReturn	= Math.max(maxReturn, sumCurrent);
		}
		System.out.println(maxReturn);
	}
	/*
	 19. 숫자 조합으로 특정 수 만들기
	🧠 풀이 설명
	입력받은 수들 중 2개를 골라 합이 K가 되는지 확인합니다.

	2중 for문을 사용해 모든 조합을 탐색합니다.
	*/
	public static void dddd() {

		Scanner scanner = new Scanner(System.in);

		int arrayLength = scanner.nextInt();
		int[] intArray = new int[arrayLength];
		List<int[]> list = new ArrayList<int[]>();

		for(int i=0; i<intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}

		int targetNumber = scanner.nextInt();
		
		for(int i=0; i<intArray.length-1; i++) {
			for(int j=i+1; j<intArray.length; j++) {
				if(intArray[i] + intArray[j] == targetNumber) {
					list.add(new int[] {i,j});
				}
			}
		}

		System.out.println();
		
		
		for(int[] listInt :list) {
			int i=0;
			System.out.println(listInt.length);
		}
		
	}
}
