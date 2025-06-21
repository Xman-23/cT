package codingTest0425;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CodingTest_8 {
	public static void main(String[] args) {
		int[] num = {1, 1, 2};
		System.out.println(getNumber(num));
	}

	public static int getNumber(int[] num) {

		if(num.length < 2) {
			return -1;
		}

		Set<Integer> set = new TreeSet<Integer>();
		for(int numTwo : num) {
			if(numTwo > 0) {
				set.add(numTwo);
			}
		}

		System.out.println(set);

		if(set.size()<2) {
			return -1;
		}else {
			Iterator<Integer> iterator = set.iterator();
			iterator.next();
			return iterator.next();
		}

	}
}
