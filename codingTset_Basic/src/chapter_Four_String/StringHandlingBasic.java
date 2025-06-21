package chapter_Four_String;

public class StringHandlingBasic {
	public static void main(String[] args) {
		System.out.println(StringHandlingBasicSolution.stringHandlingBasicSolution());
	}
}

class StringHandlingBasicSolution {

	StringHandlingBasicSolution() {
		super();
	}

	public static boolean stringHandlingBasicSolution() {
		String parameter = "a234";

		if(parameter.length() == 4 || parameter.length() ==6) {
			for(int i=0; i<parameter.length();i++) {
				char ch = parameter.charAt(i);
				//숫자가 영어보다 먼저 올 수있으므로 ex)12a,
				//!(Character.isDigit())
				if(!Character.isDigit(ch)) {
					return false;
				}
			}
			//모든 조건을 통과할 경우 return true
			return true;
		}
		//문자열 길이가 4 또는 6이 아닐 경우 return false;
		return false;
	}
}
