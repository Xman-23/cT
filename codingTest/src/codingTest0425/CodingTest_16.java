package codingTest0425;

import java.util.*;
import java.math.*;
import java.time.*;
import java.time.format.*;
import java.io.*;
import java.lang.*;

public class CodingTest_16 {
	public static void main(String[] args) {
		int[] numbers = {5, 5, 5, 5};
		System.out.println(CodingTest_16.getNumber(numbers));
	}

	public static int getNumber(int[] numbers) {
		if(numbers.length < 2) {
			return -1;
		}

		Set<Integer> set = new TreeSet<Integer>(Comparator.reverseOrder());
		int returnInt = 0;

		for(int i=0; i<numbers.length; i++) {
			int number = numbers[i];

			if(number > 0) {
				set.add(number);
			}
		}

		if(set.size() < 2) {
			return -1;
		}else if(set.size() >= 2) {
			Iterator<Integer> iterator = set.iterator();
			iterator.next();
			returnInt=iterator.next();
		}

		return returnInt;
	}
}
