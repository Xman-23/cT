package chapter_Five_Recursive;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {

	public static void main(String[] args) {

	}
}

class VowelDictionarySolution {

	VowelDictionarySolution() {
		super();
	}

	static char[] vowelArray = new char[] {'A','E','I','O','U'};

	public static List<String> generate(String string) {
		List<String> list = new ArrayList<String>();
		list.add(string);

		if(string.length() == 5) {
			return list;
		}
		for(char c : vowelArray) {
			list.addAll(generate(string+c));
		}

		return list;
	}

	public static int indexOfVowelString(String string) {
		int indexOfVowelString = generate("").indexOf(string);
		return indexOfVowelString;
	}
}
