package chapter_Four_String;

public class UsernameRecommender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class UsernameRecommenderSolution {

	UsernameRecommenderSolution() {
		super();
	}
	
	public static String usernameRecommenderSolution() {
		String string = "...!@BaT#*..y.abcdefghijklm";
		//1단계. id 소문자
		string = string.toLowerCase();
		//2단계. 소문자,숫자,빼기(-),밑줄(_),마침표를 제외한 모든 문자 제거
		/*
		 	정규표현식에서 [a-z]는 'a'부터 'z'까지의 모든 소문자'를 의미합니다.

			여기서 '-'는 문자 범위를 나타내는 연산자입니다. ex)a-z, 0-9...

			"-" 문자 처리 = \-
			정규표현식에서는 \-만 써도 되지만,

			Java 문자열에서는 \ 자체가 특수문자라서 \\-로 써야 정규표현식에 \-가 전달됩니다.

			"\\-_. " 자바 문자열은 실제로는 \-_.라는 문자 4개를 의미
		 */
		string = string.replaceAll("[^a-z0-9\\-_.]", "");

		//3단계. 연속된 마침표 즉, 마침표가 연속으로 2개이상이 올 경우 하나로 취급
		/*
		 "." 는 정규표현식에서 아무 문자 하나를 뜻함 그러므로 "\." 를 해줘야지 정규표현식에서 문자로 취급
		 하지만, Java에서는 "\"는 Escape 문자이므로 "\."를 문자 취급을 해줄려면은, "\\."로 작성을 해줘야지만
		 "\."로 취급한다.
		 "+"는 "+"앞에 문자 하나이상을 뜻함
		 */
		string = string.replaceAll("\\.+", ".");

		//4단계 처음이나 끝에 마침표가 등장하면 제거 (위에서 "."개 2개 이상인경우 "."로 바꿈"
		//		(	^	), ($)
		//즉, .!@BaT*.y.abcdefghijklm 이므로 맨앞에 "."를 제거
		string = string.replaceAll("^\\.+|\\.+$","");
		//"문자열 그대로 바꿀 거면 replace() / 정규표현식 패턴으로 바꿀 거면 replaceAll()"
		//replaceAll은 "패턴" 즉 정규표현식을 의미

		//5단계 만약 바꾼 문자열이 빈문자열("")일경우 a로 대입
		if(string.isEmpty()) {
			string = "a";
		}

		//6단계 문자열 길이가 16일경우 15글자만 남김,그리고 15글자의 맨 마지막이 "."이면은 제거
		if(string.length() > 15) {
			string = string.substring(0,15); //0,1,2,3,4,5,6,7,8,9,10,11,12,13,14
			string = string.replaceAll("\\.$", ""); //만약 마지막 문자가 '.'이면 제거
		}
		//7단계 문자열의 길이가 3미만일경우 맨마지막 글자를 계속더해줘서 문자열길이를 3이상으로 만들기
		for(int i=string.length(); i<=2; i++) {
			string = string +string.charAt(string.length()-1);
		}
		return string;
	}
}
