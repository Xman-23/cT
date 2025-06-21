package codingTest0425;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CodingTest_12 {
	public static void main(String[] args) {
		int[] numArray = {1, 1, 2};
		int resultNumber = CodingTest_12.getSecondMinTreeSetValue(numArray);

		System.out.println(resultNumber);

	}

	public static int getSecondMinTreeSetValue(int[] numArray) {
		//배열 유효성 체크
		if(numArray.length < 2) {
			return -1;
		}

		Set<Integer> set = new TreeSet<Integer>(); // 비교를 위한 TreeSet(중복제거,순서 보장x)
		int secondMinValue = 0; // return할 second 값 선언

		for(int i=0; i<numArray.length; i++) {
			int num = numArray[i];
			//음수 방지
			if(num < 0) {
				continue;
			}else if(num >0) {
				set.add(num);
				System.out.println("Set 값 체크 :" + set);
			}
		}

		//두번째이므로 적어도 2개의 값이 set에 존재 해야함
		if(set.size()<2) {
			return -1;
		}else if(set.size() >= 2) {
			Iterator<Integer> iterator = set.iterator();
			iterator.next(); //첫번째 값으로 이동 가장큰값
			secondMinValue = iterator.next();
		}

		return secondMinValue;
	}
}
