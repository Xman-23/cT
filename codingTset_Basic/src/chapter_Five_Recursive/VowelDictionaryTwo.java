package chapter_Five_Recursive;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionaryTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class VowelDictionaryTwoSolution {

	public VowelDictionaryTwoSolution() {
		super();
	}
	static char[] vowelDictionary = new char[] {'A','E','I','O','U'};
	public static List<String> generate(String string,List<String> list) {
		list.add(string);

		if(string.length() == 5) {
			return list;
		}

		for(char c : vowelDictionary) {
			generate(string+c, list);
		}

		return list;
	}

	public static int indexOfVowelDictionary(String string) {
		List<String> list = new ArrayList();
		int indexOfNumber =generate("", list).indexOf(string);
		return indexOfNumber;
	}
}
