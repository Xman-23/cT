package chapter_Four_String;

import java.util.Arrays;

public class makeStrangeString {
	public static void main(String[] args) {
		String s = "try hello world";
		//split(" ")도 split(" ", -1)과 마찬가지로 배열에 저장되는 각 요소는 
		//공백이 제거된 순수한 문자열(단어)만 들어갑니다.
		String[] sa = s.split(" ",-1);
		System.out.println(Arrays.toString(sa));
		String s2 = sa[1];
		System.out.println(s2);
	}
}

class makeStrangeStringSolution {
	
	makeStrangeStringSolution() {
		super();
	}
	public static String makeStrangeStringSolution(String string) {
		StringBuilder sb = new StringBuilder();
		boolean toUpper = true;
		char[] chArray = string.toCharArray();
		for(int i=0; i<chArray.length;i++) {
			char ch = chArray[i];
			if(Character.isAlphabetic(ch)) {
				if(toUpper) {//첫번째 문자는 무조건 대문자
					sb.append(Character.toUpperCase(ch));
				}else {
					sb.append(Character.toLowerCase(ch));
				}
				toUpper =!toUpper;
			}else { //공백이라면,
				sb.append(ch); //공백이 오면 추가
				toUpper  = true; //공백 다음 글자는 무조건 대문자 이므로 toUpper 를 'true'
			}
		}
		return sb.toString();
	}

	public static String makeStrangeStringSolutionTwo(String string) {
		StringBuilder sb = new StringBuilder();
		String[] stringArray = string.split(" ",-1);

		for(int i=0; i<stringArray.length;i++) {
			String word = stringArray[i];
			for(int j=0; j<word.length(); j++) {
				char ch = word.charAt(j);
				if(j%2 == 0) {
					sb.append(Character.toUpperCase(ch));
				}else {
					sb.append(Character.toLowerCase(ch));
				}
			}
			if(i<stringArray.length-1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

}
