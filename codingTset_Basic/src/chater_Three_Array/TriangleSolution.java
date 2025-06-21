package chater_Three_Array;
//삼각형(나선) 달팽이
public class TriangleSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Triangle {
	Triangle() {
		super();
	}

	public int[] triangle(int n) {
		int[][] twoArray = new int[n][n];

		int x = 0; // (2차원 배열에서 점을 찍을 시작 x(열인덱스)좌표
		int y = 0; // (2차원 배열에서 점을 찍을 시작 y(행인덱스)좌표
		int value = 1; //(0(y(행인덱스)),0(x(열인덱스)) 에 처음 값을 넣을 값

		//무한 루프를 돌면서 일정 조건에 도달하면 break;로 조기종료
		while(true) {
			//배열을 반시계방향(나선으로 도는 순서 아래->오른쪽->왼쪽위->아래~~)
	
			//1. 아래 방향(특정 조건을 만족하면 break; 로 조기종료
			while(true) {
				// (0,0)에 먼저 '1'을 넣고 다음 값을 위해 후위증감형 '++' 사용
				twoArray[y][x] = value++; //(1,2,3,4) 찍고 value = '5'인 상태로 탈출, (10) 찍고 value = '11'인 상태로 탈출
				//아래 끝 까지 도달했는지 or 다음 위치에 값이 있는지 확인
				//아래 끝(y+1)까지 도달했다는건 오른쪽으로 '방향전환'
				//or 다음 위치에 값이 있다면 거긴 이미 한번돌았다는 의미로 오른쪽으로 '방향전환'
				if(y+1 == n || twoArray[y+1][x] !=0) {
					break; //아래 방향으로 도는 안쪽 while문을 탈출)
				}
				//그리고 조건에 부합하지 않으면 방향을 돌아도 된다는 의미 이므로, 
				//다음 아래 방향을 위해서 'y'의 현재값에 +1을 시켜줌
				y = y+1;
			}
			//2. 오른쪽 방향(x+1)
			//그전에 지금 현재 위의 while문에 의해서 'y=3'이고 'x=0'인 상태
			//여기서 그래도 숫자를 찍으면 원래 있떤 [3][0]에 있는 숫자 '4'가 '5'로 바뀌게 되어서 문제가 됨
			//그러므로 오른쪽으로 이동할 곳에 값이 있는지와 오른쪽으로 한번 돌아봤는지를 확인하기 위한 조건문이 필요
			if(x+1 == n || twoArray[y][x+1] !=0) {
				break;
			}
			x= x+1;
			//오른쪽 돌기 while문
			while(true) {
				twoArray[y][x] = value++; //5,6,7 찍고 value = '8'인 상태로 while문 탈출
				if(x+1 == n || twoArray[y][x+1]!=0) {
					break;
				}
				x = x+1;
			}
			//왼쪽위로 이동할때 '0'이 아닌 다른 숫자가
			//나선으로 다 돌았다는 의미가 됨
			if(twoArray[y-1][x-1] != 0) {
				break;
			}
			y = y-1;
			x = x-1;
			//왼쪽 위 돌기 while문
			while(true) {
				twoArray[y][x] = value++; //(8,9) 찍고 value = '10'인상 태로 while문 탈출
				if(twoArray[y-1][x-1] !=0) {
					break;
				}
				y = y-1;
				x = x-1;
			}
			//이 조건을 만족하면 나선을 다 돌았다는 의미 이므로, 바깥 while문 탈출
			if(y+1 == n || twoArray[y+1][x] !=0) {
				break;
			}
			y = y+1;
		}
		//삼각형 달팽이 1차원 배열로 펼치기
		//'value'가 '11'인 상태로 탈출 했으므로 
		//1~10 까지 담을 길이를 맞추기 위해서 "value-1"처리를 하여,
		//1차원 배열의 길이를 맞춰줌
		int[] oneArray = new int[value-1]; 
		int index = 0;
		//여기서 순열 N(N+1)/2 사용 (1행 = 1개, 2행 = 2개, 3행 = 3개 ,4행 = 4개
		//i = y(행인덱스(세로)), j = x(열인덱스(가로));
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i;j++) {
				//index를 후위증감형으로 처리하여 0부터 9까지 즉, 1~10까지의 수를 담음
				oneArray[index++] = twoArray[i][j];
			}
		}
		return oneArray;
	}
}
