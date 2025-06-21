package Chapter_Five_Recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HanoiSolution hanoiSolution = new HanoiSolution();
		hanoiSolution.hanoiSolution(3, 1, 2, 3);
		System.out.println(hanoiSolution.list.size());;
		int[] start = new int[hanoiSolution.list.size()];
		int[] mid = new int[hanoiSolution.list.size()];
		int[] end = new int[hanoiSolution.list.size()];
		for (int i = 0; i < hanoiSolution.list.size(); i++) {
		    int[] move = hanoiSolution.list.get(i);  // i번째 int[] 배열 꺼내기
		    start[i] = move[0];       // 배열의 첫 번째 요소 (출발 기둥)
		    end[i] = move[1];         // 배열의 두 번째 요소 (도착 기둥)
		}

		int i=0; //'i'를 밖에서 선언해야함 
		for(int[] m : hanoiSolution.list ) {
			//int i=0; 안에다가 'i'를 선언할 경우 for문을 돌면서 매번 0으로 초기화, 그러므로 증감연산자 "++"가 소용이 없음.
			mid[i] = m[0];
			i++;
		}
		System.out.println(Arrays.toString(start));
		System.out.println(Arrays.toString(end));
		System.out.println(Arrays.toString(mid));
	}
}

class HanoiSolution {

	HanoiSolution() {
		super();
	}

	StringBuilder stringBuilder = new StringBuilder();
	int count = 0;
	List<int[]> list = new ArrayList<int[]>();
									//n= 3, 1 , 2 ,3
	public void hanoiSolution(int n, int start, int mid, int end) {
		if(n ==  1) {
			stringBuilder.append(start).append(", ").append(end).append("\n");
			list.add(new int[] {start,end});
			count++;
			return;
		}
		// n = 3 
		// n = 2, 1, 3, 2
		// n = 1, 1, 2, 3
		//--------------------------------------------------------------------------------------------------------------
		//n = 2, 2, 1, 3
		//n = 1, 2,3,1 작은원판 두번째 기둥에서 첫번째 기둥으로 옮김(count++)
		hanoiSolution(n-1, start, end, mid );
		//n = 2, 1, 3 , 2
		//중간원판 첫번째 기둥에서 두번째 기둥으로 옮김 (count ++)
		//n = 3, 1, 2 , 3
		//------------------------------------------------------------------------------------------------------------------
		//가장큰 원판 첫번째 기둥에서 세번째 기둥으로 옮김 (count++)
		//n = 2, 2, 1, 3
		//중간 원판을 두번째 기둥에서 세번째 기둥으로 옮김(count++)
		stringBuilder.append(start).append(", ").append(end).append("\n");
		list.add(new int[] {start,end});
		count++;
		//n = 2 , 1,3,2
		//n = 1 , 3,1,2 작은원판 세번째기둥에서 두번째 기둥으로 옮김(count ++)
		//n = 3, 1,2,3
		//n = 2, 2,1,3
		// n = 1, 1,2,3 작은원판 첫번째 기둥에서 세번째 기둥으로 옮김(count++)
		hanoiSolution(n-1, mid, start, end );
	}
}

