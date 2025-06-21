package high;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class CodingTest0514High {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class CT0514High {

	public CT0514High() {
		super();
	}
	//괄호 깊이
	public static void dddd() {

		Scanner scanner = new Scanner(System.in);

		String string = scanner.next();
		scanner.close();
		int depth = 0;
		int returnCounter = 0;
		//input = ((()))

		for(int i=0; i<string.length();i++) {
			if(string.charAt(i) == '(') {
				depth++;
				if(depth > returnCounter) {
					returnCounter = depth;
				}
			}else if(string.charAt(i) == ')') {
				depth --;
			}
		}
		System.out.println(returnCounter);
	}
}

