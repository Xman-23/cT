package chater_Three_Array;

public class TriangleSolutionAnother {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

class TriangleAnother {
	
	TriangleAnother() {
		super();
	}
	//		아래,	오른쪽,	왼쪽위
	//dx	    0	,	 +1,	      -1	
	//dy	  +1	,	   0,         -1
	//(좌,우) 좌표를 위한 'x', 'd' = delta(변화량)
	final static int[] dx = new int[] {0,+1,-1}; 
	//(상,하) 좌표를 위한 'y', 'd' = delta(변화량)
	final static int[] dy = new int[] {+1,0,-1};

	public static void triangleAnother(int n) {
		int value = 1;	//찍을 값 '1' 부터 시작
		int x = 0;		//x 좌표
		int y = 0;		//y 좌표
		int d = 0;	//delta 방향 전환을 위한 변수
		int[][] arrayTwo = new int[n][n];
		//아래, 오른쪽 , 왼쪽 을 while 문 하나로 해결
		while(true) {
			arrayTwo[y][x] = value++;
			int nx = x + dx[d]; //2. 오른쪽(1, (1+1=2),(2+1=3), 3. 왼쪽 위(2,(2-1=1)) 
			int ny = y + dy[d]; //1. 아래로 먼저(0, (0+1=1), (1+1=2), (2+1=3), 3. 왼쪽 위(2,(2-1=1)) 4. 아래(2)
			//'방향전환'을 위한 'if문'  'ny,nx' == -1이라는것은 배열의 범위를 벗어남을 방지 하기 위해서 
			if(ny == n || nx == n ||ny == -1 || nx == -1 || arrayTwo[ny][nx] !=0) {
				//방향 전환을 위한 변수 아래, 오른쪽 , 왼쪽 위(3가지 방향 (%3))
				//if문을 들어올 때 마다 방향 전환
				d = (d+1) % 3; //'d=1' 오른쪽, 'd=2' 왼쪽위 , 'd=0' 아래
				nx = x + dx[d]; // 'x=1' 'x'값 변환(3,1)
				ny = y + dy[d]; // 'y=3' 'y'값 유지(3,1)
				//while문을 탈출 하기 위한 'if'문 'arrayTwo[y][x] != 0'에 의해 while 문 탈출
				if(ny == n || nx == n || ny == -1 || nx == -1 || arrayTwo[ny][nx] !=0) {
					break; //while문 탈출
				}
			}
			x = nx;
			y = ny;
		}
		//'while문' 빠져나온 시점의  'value = 11' 그러므로 'value = 11-1'을 해줘 1~10까지의 숫자를 맞춤 
		//int[] arrayOne = new int[value -1]; // 책 버전
		int[] arrayOne = new int[n * (n + 1) / 2]; //gpt 버전
		//arrayOne의 'index'의 후위증감형을 위한 변순
		int index = 0;
		//수열 사용 N(N+1)/2, 1행 = 1개 ,2행 2개 , 3행 3개 , 4행 4개 ~~
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				arrayOne[index++]  = arrayTwo[i][j];
			}
		}
	}
}
