package chapter_Two_time_comPlexity;

import java.util.*;
//O(NM)을 HashSet(O(N+M))으로 해결하는 방법
public class HashSet_O_NM {

	public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9};
        int[] B = {3, 6, 9, 12};

        Set<Integer> set = new HashSet<Integer>();
        for (int num : A) {
            set.add(num);  // O(N)
            //O(N)인 이유는 A가 기본타입의 배열이므로 hashCode() 와 equals() 메서드가 없으므로,
            //HashSet이 hashCode를 이용하여 버짓(저장된 위치)를 쉽게 찾지 못하므로,
            //A배열의 길이만큼 0부터 A.length-1만큼 끝까지 순회해야하기 떄문에 O(N)이다.
        }

        for (int num : B) {
            if (set.contains(num)) {  // O(1) 평균
            	//O(1)인경우 Set Class의 contains메서드가 호출되면 contains메서드 내부에서는
            	//hashCode(),equals() 메서드가 호출된다.
            	//즉 hashcode를 이용하여 저장된 위치(버짓)으로 빠르게 찾아가서 비교를하므로
            	//O(1)상수 시간이다.
                System.out.println(num + "은 존재합니다.");
            } else {
                System.out.println(num + "은 없습니다.");
            }
        }

	}

}
