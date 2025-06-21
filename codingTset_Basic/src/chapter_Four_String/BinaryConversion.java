package chapter_Four_String;

public class BinaryConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BinaryConversionSolution {

	public BinaryConversionSolution() {
		super();
	}

	public static int[] binaryConversionSolution(String s) { 
		int loop = 0; //반복 횟수
		int removeZeroCounter = 0; //'0'을 지운 횟수
		//input : "110010101001"

		//Class 안에 내용 (인스턴스 멤버)를 비교하기위해서 "==" 아닌 , "equals()" 사용
		while(!s.equals("1")) {
			int zeroCounter = zeroCounter(s);
			loop = loop + 1;
			//지워야할 "0" counter 갯수 누적
			removeZeroCounter = removeZeroCounter + zeroCounter;
			//!주의 removeZeroCounter 를 빼면 안됨 누적된 '0' 의 갯수이므로 
			//'length'가 잘 못 계산되어 이진으로 전환 될 수 있음
			//그러므로 zeroCounter 를 빼줘야한다.
			int length = s.length() - zeroCounter;
			s = Integer.toString(length,2);
		}
		return new int[] {loop,removeZeroCounter};
	}

	public static int zeroCounter (String s) {
		int zeroCounter = 0;
		for(int i=0; i<s.length();i++) {
			char ch = s.charAt(i);
			if(ch == '0') {
				zeroCounter = zeroCounter +1;
			}
		}
		return zeroCounter;
	}
}