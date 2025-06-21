package codingTest0425;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CodingTest_11 {
	public static void main (String[] agrs) {
		int[] numbers = {5, 3, 9, 1, 9};
		int resultValue = CodingTest_11.getSecondMaxTreeSetValue(numbers);
		System.out.println(resultValue);
	}

	public static int getSecondMaxTreeSetValue(int[] numbers) {
		//배열의 길이가 2이상이여야지만 비교 가능
		if(numbers.length < 2) {
			return -1;
		}

		Set<Integer> set = new TreeSet<Integer>(Comparator.reverseOrder());
		int secondMaxValue = 0;
		
		for(int i=0; i<numbers.length; i++) {
			int num = numbers[i];

			//음수 비교 방지
			if(num < 0) {
				continue;
			}

			set.add(num);
			System.out.println("set["+i+"번째]"+set);
		}

		if(set.size()<2) {
			return -1;
		}else if(set.size() >= 2) {
			Iterator<Integer> iterator = set.iterator();
			iterator.next();
			secondMaxValue = iterator.next();
		}

		return secondMaxValue;
	}
}
