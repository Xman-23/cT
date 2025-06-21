package middle;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.time.*;
import java.time.format.*;
import java.io.*;

public class CodingTest0513Middle {
	public static void main(String[] args) {
		//Ct0513Middle.longestsuffix();
		//Ct0513Middle.commonSuffix();
		//Ct0513Middle.commonSuffixTwo();
		//Ct0513Middle.commonPrefix();
		Ct0513Middle.stringCompartor();
	}
}

class Ct0513Middle {

	Ct0513Middle() {
		super();
	}

	public static void longestsuffix() {

		Scanner scanner= new Scanner(System.in);

		Integer min_VALUE = Integer.MIN_VALUE; //-22억(MIN_VALUE)
		String string = scanner.nextLine();
		List<String> list = new ArrayList<String>();

		for(int i = string.length()-1; i>=0; i--) {
			list.add(string.substring(i));
		}
		System.out.println(list);
		String returnLongestSuffix = "";

		for(int i=0; i<list.size(); i++) {
			if(list.get(i).length() > min_VALUE) {
				min_VALUE = list.get(i).length();
				returnLongestSuffix = list.get(i);
			}
		}
		System.out.println("가장 긴 접미사 찾기 = " + returnLongestSuffix);
	}

	public static void commonSuffix() {

		Scanner scanner = new Scanner(System.in);

		String stringOne = scanner.next();
		String stringTwo = scanner.next();
		System.out.println(stringOne+", " +stringTwo);
		List<String> list = new ArrayList<String>();

		if(stringOne.length() == stringTwo.length()) {
			for(int i = stringOne.length()-1; i>=0; i--) {
				if(stringOne.substring(i).equals(stringTwo.substring(i))) {
					list.add(stringOne.substring(i));
				}else {
					break; // 같은 접미사가 아닐경우 for문을 순회할 필요가 없음.
				}
			}
			
		}else {
			System.out.println("문자의 갯수를 맞춰 주세요.");
		}
		scanner.close();
		System.out.println(list);
		Integer compartorMin = Integer.MIN_VALUE; //-22억
		String retunSuffix = "";
		for(int i=0; i<list.size();i++) {
			if(list.get(i).length()>compartorMin) {
				compartorMin = list.get(i).length();
				retunSuffix = list.get(i);
			}
		}
		System.out.println(retunSuffix);
	}
	//수정본
	public static void commonSuffixTwo() {

		Scanner scanner = new Scanner(System.in);

		String stringOne = scanner.next(); // dabc
		String stringTwo = scanner.next(); // babc
		scanner.close();
		StringBuilder returnCommonSuffix = new StringBuilder();

		for(int i = stringOne.length()-1, j = stringOne.length()-1; i>=0 && j>=0; i--,j--) {
			if(stringOne.charAt(i) == stringTwo.charAt(j) ) {
				returnCommonSuffix.insert(0, stringOne.charAt(i));
				/*
					sb.insert(0, 'a'); // sb = "a" 처음에 인덱스 0 = a
					sb.insert(0, 'b'); // sb = "ba" 두번째 값이 오면 a가 1칸씩 오른쪽으로 밀림
					sb.insert(0, 'c'); // sb = "cba" 세번째 값이오면 b도 오른쪽으로 한칸씩 밀리고 a도 자동으로 한칸씩밀림.
				 */
			}else {
				break;
			}
		}
		System.out.println(returnCommonSuffix);
	}
	public static void commonPrefix() {

		Scanner scanner = new Scanner(System.in);

		String stringOne = scanner.next();
		String stringTwo = scanner.next();
		scanner.close();
		StringBuilder returnCommonPrefix = new StringBuilder();

		for(int i=0, j=0; i<stringOne.length() && j<stringTwo.length(); i++, j++) {
			if(stringOne.charAt(i) == stringTwo.charAt(j)) {
				returnCommonPrefix.append(stringOne.charAt(i));
				System.out.println("여기 오나요?? i =" + i + ", j = "+ j);
			}else {
				break; // 접두사 가 처음부터 맞지 않거나, 접두사가 도중에 맞지않으면 공통된것이 아니므로 break;
			}
		}
		System.out.println(returnCommonPrefix);
	}
	//문자열 대칭 비교하기.
	public static void stringCompartor() {

		Scanner scanner = new Scanner(System.in);

		String prefixString = scanner.next(); //접두사는 앞에서 부터 시작하므로 i++
		String suffixString = scanner.next(); //접미사는 뒤에서 부터 시작하므로 j--
		scanner.close();
		StringBuilder returnStringBuilder = new StringBuilder();
		
		for(int i=0, j= suffixString.length()-1; i<prefixString.length() && j>=0; i++,j--) {
			if(prefixString.charAt(i)==suffixString.charAt(j)) {
				returnStringBuilder.append(prefixString.charAt(i));
			}
		}
		System.out.println(returnStringBuilder);
	}
	public static void stringSuffixAndPrefix() {

		Scanner scanner= new Scanner(System.in);

		String string = scanner.nextLine();
		int maxLength= 0;
		scanner.close();
		//input = xyABCxy
		for(int i=1; i<string.length(); i++) {
			//substring(0,i) = 0<= x < i
			String prefix = string.substring(0,i);
			String suffix  = string.substring(string.length()-i);

			if(prefix.equals(suffix)) {
				maxLength = i;
			}
			
		}
		System.out.println(string.substring(0,maxLength));
	}
}
