package codingTest0425;

import java.util.*;
import java.time.format.*;
import java.time.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class CodingTest_17 {
	public static void main(String[] args) {
		int[] numbers1 = {3, 1, 2, 5, 2, 1};
		int[] numbers2 = {7, 7, 7};
		int[] numbers3 = {0, -1, -3, 2, 2};
		System.out.println(getValue(numbers1));
		System.out.println(getValue(numbers2));
		System.out.println(getValue(numbers3));
	}
	
	public static int getValue(int[] numbers) {
		//배열 길이로 유효값 체크
		if(numbers.length < 3) {
			return -1;
		}

		Set<Integer> set = new TreeSet<Integer>();
		int returnValue = 0;

		for(int num : numbers) {
			if(num > 0) {
				set.add(num);
			}
		}
		System.out.println("set = " + set);
		
		if(set.size() < 3) {
			return -1;
		}else if(set.size() >=3) {
			Iterator<Integer> iterator = set.iterator();
			iterator.next();
			iterator.next();
			returnValue = iterator.next();
			
		}
		return returnValue;
	}
}
