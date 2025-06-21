package chapter_Six_Brute_Force_Search;

import java.util.Arrays;
import java.util.Spliterator;

public class CarpetSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   
	}

}
class CarpetSolverSolution {

	public CarpetSolverSolution() {
		super();
	}
	//카펫의 원래 가로,세로 길이 찾기
	public static int[] carpetSolver(int brown,int yellow) {

		//'brown'은 바깥에 색칠된 격자의 갯수
		//'yellow'은 안쪽에 색칠된 격자의 객수
		//카펫의 전체 넓이를 알지 못한다.
		//-> 즉 카펫의 넓이에 해당하는('가로', '세로')길이를 구하여라

		//카펫의 넓이(total) =  (brown + yellow)
		int total =brown + yellow;

		//가로와 세로는 무조건 '3'이상이여야한다
		//적어도 3X3으로 이뤄져야지만, 테두리를 제거했을떄 안쪽격자(정사각형)이 남음
		//그리고 조건에 가로>=세로 이므로, 세로가 가로를 넘지 않을때까지만 'for'문을 돌린다.
		/*
		가로 width = total / height

		가로가 최소 3 이상이어야 하니까 → total / height = (width) ≥ 3

		양변에 height를 곱하고 부등호 방향 유지하면 → total ≥ 3 * height

		양변을 3으로 나누면 → height ≤ total / 3
		 */
		for(int height=3; height<=total/3/*(total/3=width)*/; height++) {
			//'total%height'은 'width'를 구하는 공식이므로,
			//'total%height' 했을때 나머지가 있다면은 '정수'가 아님
			//2차원 배열 즉, 격자는 정수로만 이뤄져있기때문에
			//'total%height' 의 값이 '0'이어야지만 가로가 정수임을 알 수 있다.
			if(total%height != 0) {
				continue;
			}

			//'if문'의 'total%height'을 통해서 'width'를 구할때 적어도 정수임을 알 수 있으므로,
			//안전하게 'width'를 구해도 된다
			int width = total/height;
			//안쪽 넓이(격자(칸의갯수))를 구하기 위해서는, 
			//위('1줄'),아래('1줄') 테두리 제거(-2), 왼쪽('1줄'),오른쪽('1줄') 테두리 제거(-2)
			//즉, 높이는-2가 되고, 가로도 -2가 된다 그 둘을 곱한게 안쪽의 넓이(격자(칸의갯수))이다.
			int inner = (width-2) * (height-2);
			//만약 inner와 yellow가 정확하게 맞아 떨어진다면은 ('위,아래,왼쪽,오른쪽')테두리를 제거하기전에 '가로,세로' 길이가
			//카펫의 가로,세로의 길이이며 이 둘을 곱한게 카펫의 전체 넓이다.
			if(inner == yellow) {
				return new int[] {width,height};
			}
		}
		return new int[0];
	}
}