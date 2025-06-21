package chapter_Four_String;

public class CountPYCharactersTwo {

	public static void main(String[] args) {

	}

}

class CountPYCharactersTwoSolution {

	CountPYCharactersTwoSolution() {
		super();
	}

	public static boolean countPYCharactersTwoSolution() {
		String stringToLowerCase = "pppoooyyy".toLowerCase();
		String pString = stringToLowerCase.replaceAll("p", "");
		String yString = stringToLowerCase.replaceAll("y","");

		return pString.length() == yString.length();
	}
}
