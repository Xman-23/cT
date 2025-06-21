package codingTest0425;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CodingTest_6 {
	public static void main(String[] args) {
		int[] numbersOne = {3, 1, 5, 2}; // 2
		int[] numbersTwo = {10, 10, 10, 10}; // -1
		int[] numbersThree = {-3, -2, -1}; //-1
		int[] numbersFour = {1, 2, 1}; // 1

		System.out.println(CodingTest_6.secondMinGetValue(numbersOne));
		System.out.println(CodingTest_6.secondMinGetValue(numbersTwo));
		System.out.println(CodingTest_6.secondMinGetValue(numbersThree));
		System.out.println(CodingTest_6.secondMinGetValue(numbersFour));
	}

	public static int secondMinGetValue(int[] numbers) {
		//Validation Check
		if(numbers.length < 2) {
			return -1;
		}

		Set<Integer> set = new TreeSet<>(); //Set은 중복허용x , 순서 보장 x , List는 중복허용 o ,순서보장 o , Map key 중복x , value 중복o
		for(int i=0; i<numbers.length; i++) {

			if(numbers[i]<0) {
				System.out.println("음수 입니다");
				continue; //음수 일 경우 다음 for문 시작
			}

			if(numbers[i]>0) {
				set.add(numbers[i]); //TreeSet 이무로 중복x 순서를 오름차순으로 정렬
			}
		}
		if(set.size()<2) {
			return -1;
		}
		Iterator<Integer> iterator = set.iterator();
		System.out.println(iterator.next());

		return iterator.next();
	}
}
