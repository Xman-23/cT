package chapter_Four_String;

public class CountPYCharacters {

	public static void main(String[] args) {
		System.out.println(CountPYCharactersSolution.countPYCharactersSolution("pPoooyY"));
	}
}

class CountPYCharactersSolution  {

	CountPYCharactersSolution() {
		super();
	}

	public static boolean countPYCharactersSolution(String parameterString) {

		String parameterToLowerCase = parameterString.toLowerCase();
		int pCounter = 0;
		int yCounter = 0;

		for(int i = 0; i<parameterToLowerCase.length();i++) {
			char ch = parameterToLowerCase.charAt(i);

			if(ch == 'p') {
				pCounter++;
			}else if(ch == 'y') {
				yCounter++;
			}

		}
		if(pCounter == yCounter) {
			return true;
		}else {
			return false;
		}
	}
}