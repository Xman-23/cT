package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class codingTest {

	public static void main(String[] args) {
		/*
		 * card(new int[][] { {3,1,2,4}, {5,6,1,7}, {8,3,5,2} } );
		 */
		//solution(new int[] {1,1,2});
		//isHarshad(18);
		//solution("pPoooyY");
		//countDivisibleByThree(new int[] {3, 5, 9, 10, 12});
		//findMaxMinDifference(new int[] {3, 5, 1, 9, 7});
		//solutionTwo("Zbcdefg");
		//findMaxTripleProduct(new int[] {-1, -2, -3,- 4});
		//findMaxTripleProductTwo(new int[] {1,2,3,4});
		//dddd();
		//s12("aaaa","aa");
		s13("AbCdEfG","dE");
	}
	
	public static int card(int[][] cards) {
		//3 1 2 4 [I@71a794e5
		//5 6 1 7 [I@76329302
		//8 3 5 2 [I@5e25a92e
		int returnInt = 0;
		for(int i=0; i<cards.length; i++) {
			Integer max = Integer.MAX_VALUE;
			for(int j=0; j<cards[i].length; j++) {
				int number = cards[i][j];
				System.out.println("number ==" + number);
				if(number< max) {
					max = number;
				}
			}
			System.out.println("max =" +  max);
			if(max > returnInt) {
				returnInt = max;
			}
		}
		
		System.out.println(returnInt);
		
		return returnInt;
	}
	public static int[] solution(int[] numbers) {
		// numbers = {1,1,2};
		Set<Integer> set = new TreeSet<Integer>();
		for(int i=0; i<numbers.length-1; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				int number = numbers[i]+numbers[j];
				set.add(number);
 			}
		}
		System.out.println(set);
		List<Integer> list = new ArrayList<Integer>(set);
		int[] array = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	public static boolean isHarshad(int x) {
		//x =18 -> 1+8 = 9 -> 18%9 == 0 true

		String toString = String.valueOf(x);
		int sum = 0;
		boolean check = false;
		for(int i=0; i<toString.length(); i++) {
			char ch = toString.charAt(i);
			if(ch>='0' && ch<='9' ) {
				sum = sum + (ch-'0');
			}
		}
		System.out.println(sum);

		if(x % sum == 0) {
			check = true;
		}else {
			check = false;
		}

		return check;
	}
	public static boolean solution(String s) {
		
		//s = "pPoooyY";
		int pCounter = 0;
		int yCounter = 0;
		String toLowerCaseString = s.toLowerCase();
		boolean check = false;
		for(int i=0; i<toLowerCaseString.length();i++) {
			if(toLowerCaseString.charAt(i) == 'p') {
				pCounter++;
			}else if(toLowerCaseString.charAt(i) =='y') {
				yCounter++;
			}
		}
		System.out.println("pCounter =" + pCounter+", yCouner = "+ yCounter);
		
		if(pCounter == yCounter) {
			check = true;
		}else {
			check = false;
		}
		
		return check;
	}
	public static String solutionOne(String s) {

		String reverseReturnString = new StringBuilder(s).reverse().toString();

		return reverseReturnString;
	}

	public static int countDivisibleByThree(int[] numbers) {

		int returnCounter = 0;
		/*input : [3, i=0
					5, i=1
					9, i=2
					10 , i=3
					12]  i=4 
		  input.length  = 5;
		*/
		for(int i=0; i<numbers.length;i++) {
			int num = numbers[i];
	
			if(num % 3 ==0) {
				returnCounter++;
			}
		}
		System.out.println("returnCounter = " + returnCounter);
		return returnCounter;
	}
	public static int findMaxMinDifference(int[] numbers) {

		int returnNumber = 0;
		int max = numbers[0]; //3 
		int min = numbers[0]; //3

		/*
		 * intput = [
		 * 				3,
		 * 				5,
		 * 				1,
		 * 				9,
		 * 				7
		 * 			   ]
		 *  output = 8 (최댓값 9 - 최솟값 1 = 8)
		 */

		for(int i=1; i<numbers.length;i++) {
			int num = numbers[i]; //5,1,9,7
			if(num < min) {
				min = num;
			}
			if(num > max) {
				max = num;
			}
		}
		System.out.println("min = " + min +"max = "+ max );
		returnNumber = max - min;
		return returnNumber;
	}
	public static int countOddNumbers(int[] numbers) {

		int returnCounter = 0;

		for(int i=0; i<numbers.length; i++) {
			int number = numbers[i];

			if(number % 2 !=0) {
				returnCounter++;
			}
		}
		return returnCounter;
	}

	public static String solutionTwo(String s) { 

		//input = "Zbcdefg";
		//output = "gfedcbZ";

		Character[] ch = new Character[s.length()];

		for(int i=0; i<s.length();i++) {
			ch[i] = s.charAt(i);
		}
		Arrays.sort(ch,Comparator.reverseOrder());
		System.out.println("ch = " + Arrays.toString(ch));
		String returnString = "";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ch.length;i++) {
			sb = sb.append(ch[i]);
		}
		return sb.toString();

	}
	//서로 다른 세가지의 원소의 곱이 가장 큰값을 찾는 코드
	public static int findMaxTripleProduct(int[] numbers) {

		Integer result = Integer.MIN_VALUE;

		for(int i=0; i <numbers.length-2; i++) {
			for(int j=i+1; j<numbers.length-1; j++) {
				for(int l=j+1; l<numbers.length; l++) {
					int number = numbers[i] * numbers[j] * numbers[l];
					if(number > result) {
						result = number;
					}
				}
			}
		}
		System.out.println(result);
		return result;
	}
	public static int findMaxTripleProductTwo(int[] numbers)  {
		
		Integer result = Integer.MIN_VALUE;

		for(int i=0; i<numbers.length-2; i++) {
			int number = numbers[i] * numbers[i+1] * numbers[i+2];
			if(number > result) {
				result = number;
				System.out.println(result);
			}
		}
		return result;
	}
	public static String[] s11(String[] strArr) {

		//input "and","notad","abcd"
		List<String> list = new ArrayList<String>();

		for(int i=0; i<strArr.length;i++) {
			if(!strArr[i].contains("ad")) {
				list.add(strArr[i]);
			}
		}

		String[] returnStringArray = new String[list.size()];

		for(int i=0; i<list.size();i++) {
			returnStringArray[i] = list.get(i);
		}

		return returnStringArray;
	}

	public static int s12(String myString, String pat) {

		int returnCounter = 0;
		int index = 0;
		while((index = myString.indexOf(pat,index)) != -1) {
			returnCounter++;
			index = index +1;
		}
		return returnCounter;
	}
	public static String s13(String myString, String pat) {
		System.out.println(myString.endsWith("dE")+", "+pat.length());
		int length = myString.length();

		for(int i=length; i>= pat.length(); i--) {
			String sub = myString.substring(0,i);
			System.out.println(sub);
			if(sub.endsWith(pat)) {
				System.out.println("들어오는 경우");
				return sub;
			}
		}
		return "";
	}
	public static int s14(int[] array, int height) {

		//input [149,180,192,179] 머쓱이 키 167
		int returnCounter = 0;

		for(int i=0; i<array.length; i++) {
			int num = array[i];
			if(num > height) {
				returnCounter++;
			}
		}

		
		return returnCounter;
	}

	public static int s15(int[] array, int n) {

		//input = [1,1,2,3,4,5] , n =1

		int returnCounter = 0;

		for(int i=0; i<array.length;i++) {
			int num = array[i];
	
			if(num == n) {
				returnCounter++;
			}
		}
		return returnCounter;
	}

}


