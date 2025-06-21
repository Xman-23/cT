package chapter_Four_String;

public class NumberStringAndWordConverter {
	public static void main(String[] args) {
		
	}
}

class NumberStringAndWordConverterSolution {

	NumberStringAndWordConverterSolution() {
		super();
	}

	public static Integer numberStringAndWordConverterSolution() {
		String parameterString = "one4seveneight";
		String[] numberWord = new String[] 
										{"zero","one", "two", "three", "four",
										"five", "six", "seven", "eight", "nine"};
		for(int i=0; i<numberWord.length;i++) {
			parameterString = parameterString.replaceAll(numberWord[i], Integer.toString(i));
		}
		return Integer.parseInt(parameterString);
	}
}
