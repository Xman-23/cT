package chater_Three_Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//거리두기 확인하기
//Queue에 저장되는것은 처음에는 'P' 좌표 그리고 나서 'O'  좌표가 저장됨
//대기방 , 대기방 안에 가로로 줄 세워진 책상
//방문한곳 이라면은 continue 를 사용하여 밑에 코드를 실행하지 않고
//방향을 전환
//방문한곳 이라면 중복 방지를 위해 true

public class SocialDistancingChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[][] places = {
                {
                    "POOOP",
                    "OXXOX",
                    "OPXPX",
                    "OOXOX",
                    "POXXP"
                },
                {
                    "POOPP", // POOP 패턴 포함 → 실패
                    "OXXOX",
                    "OPXPX",
                    "OOXOX",
                    "POXXP"
                },
                {
                    "PXPXP", // 모든 'P' 사이 칸막이 잘 있음 → 성공
                    "XPXPX",
                    "PXPXP",
                    "XPXPX",
                    "PXPXP"
                },
                {
                    "PXOPX", // 거리두기 실패 예상 ('P'와 'O' 붙어있음)
                    "OXOXO",
                    "PXPXP",
                    "OXOXO",
                    "PXOPX"
                }
            };
			int[] result = SocialDistancingCheckerSolution.socialDistancingChecker(places);
			System.out.println(Arrays.toString(result));
			System.err.println(0%5);
	}

}
/*
	사람(P) 기준 맨해튼 거리 2 이하 → d = 0, d = 1 까지만 탐색 (컴퓨터 기준으로는 인덱스 0, 인덱스 1)

	d = 2 이상이면 탐색할 필요 없음

	그러므로 코드에서는 d >= 2면 continue로 탐색 중단하는 것이 맞음
 */
class SocialDistancingCheckerSolution {
	SocialDistancingCheckerSolution() {
		super();
	}
	public static int[] socialDistancingChecker(String[][] places) {
		//5개의 방에 대해서 '1','0'으로 판별 '1'은 거리두기 성공, '0'은 거리두기 실패 
		int[] returnArray = new int[places.length];
		for(int i=0; i<places.length; i++) {
			//places[i]는 대기방 ex) 5개의 대기방
			String[] place = places[i];
			if(checkDistance(place)) {
				returnArray[i] = 1; // 거리두기 함
			}else {
				returnArray[i] = 0; // 거리두기 안함
			}
		}
		return returnArray;
	}

	public static boolean checkDistance(String[] place) {
		//place == '대기방' 
		for(int y = 0; y<place.length; y++) {
			//place[y] == '대기방' 안에 줄 세워진 가로줄
			for(int x =0; x<place[y].length(); x++) {
				//거리두기는 무조건 'P'를 기준으로 탐색 ex(0,0) = 'P',
				if(place[y].charAt(x) == 'P') {
					//String[] = 대기방의 'P'좌표를 'bfs메서드'로 보냄
					if(!bfs(place,y,x)) { //'bfs' == 'false'이면 거리두기 실패
						return false; //거리두기 실패
					}
				}
			}
		}
		//만약 대기방에 'O' or 'X'만 있으면 거리두기 자동 성공
		return true;
	}

	public static boolean bfs(String[] place, int startY, int startX) {
					//상,하,좌,우
		int[] dy = {-1, +1, 0, 0};
		int[] dx = {0, 0, -1, +1};
		// Queue에는 좌표(y, x)와 맨헤튼거리(d)를 같이 저장
		Queue<int[]> q = new LinkedList<int[]>();
		//방문한 곳을 다시 방문하지 못하도록, 중복방지를 위한 배열변수
		boolean[][] visited = new boolean[5][5];
		//'P'의 좌표를 시작 좌표로 'Queue'에 저장
		q.offer(new int[] {startY, startX, 0});
		//'P'좌표는 방문을 했음을 의미하는 변수
		visited[startY][startX] = true;

		//처음'q'는 'P"의 좌표가 들어있음, 그것을 기준으로 상하좌우 로 탐색
		while(!q.isEmpty()) {
			//그 후에는 'O"의 좌표를 기준으로 상하좌우 탐색
			int[] current = q.poll(); //'P'와 'O'의 좌표, 맨헤튼 거리(d)를 꺼냄 
			int y = current[0]; //'P','O' 의 'y'좌표
			int x = current[1]; //'P','O'의 'x'좌표
			int d = current[2]; //'d'는 맨헤튼거리를 나타냄 
			/*
			2'이면 맨헤턴 거리에서 벗어나므로 거리두기 성공
			ex)'POOP' 거리두기 성공 첫번째 'P'일떄 상하좌우 탐색 맨헤튼 거리=1, 
			첫번째'O'일떄 상하좌우 탐색 맨헤튼 거리 =2
			맨헤튼 거리 가 '0'과'1'일떄 거리두기가 판별이 된다.
			*/

			/*
			BFS 큐에 들어가는 원소는 현재 위치(y, x)와 그 위치까지의 맨해튼 거리(d)를 포함하고 있어요.

			처음엔 'P' 위치가 들어가고, 이때 'P'기준으로 상하좌우를 탐색하면 d=0+1 을 하여 d=1 입니다.

			그 다음에 'O'(빈 테이블)이 나왔을 때는 'O'기준으로 상하좌우를 탐색하면 d=1+1 되어 'd'가 2가 되는데, (2번 탐색)

			d가 2 이상이 되면 더 깊게 탐색하지 않고 넘어갑니다.

			즉,

			맨해튼 거리가 2('d'가 '0','1'일떄만 상하좌우 탐색) 미만인 위치만 탐색하고,

			'd'가 '0','1'일때, 그 위치가 'O'라면 그걸 큐에 넣어서 다시 상하좌우 탐색을 진행하는 거죠.

			그래서 'O' 테이블을 기준으로 상하좌우 탐색하되, 거리 2 이상 넘지 않도록 하는 겁니다.

			이게 바로 "테이블을 기준으로 더 깊이 탐색하지 말고, 큐에 저장되어있는 맨해튼 거리 1의 다음 'O' 테이블 기준으로 상하좌우 탐색"이라는 의미입니다.
			*/

			if (d >= 2) continue;

	        //방향전환을 위한 변수 'i'
			for(int i=0; i<4; i++) {
				int nextY = y + dy[i];
				int nextX = x + dx[i];
				//배열의 범위를 벗어난다면은, 밑에 코드를 실행하지 않고, for문 순회
				if(nextY < 0 || nextY >= 5 || nextX < 0 || nextX >= 5 ) {
					continue;//방향전환
				}
				//다음 방문한곳이 'true'라면,continue 를 사용하여 밑에 코드를 실행하지 않고,
				if(visited[nextY][nextX]) {
					continue; //방향전환
				}

				//방문하지 않은곳 이라면은, 중복 방지를 위해 'true'
				visited[nextY][nextX] = true;

				//'P' or 'O' 기준으로, 상하좌우를 탐색하면서 next(다음)좌표에 'P'가 있는지 확인(거리두기 확인)
				char next = place[nextY].charAt(nextX);

				//다음 방문한곳에 파티션('X')가 있다면 
				if (next == 'X') { 
					continue;//방향전환
				}

				//만약 'P' 다음 바로 'P' 이거나 'O' 다음 바로 'P'이면은 거리두기 실패
				if(next == 'P') {
					//"PP", "POP" 이면 실패
					return false;
				}
				if(next == 'O') {
					//'O(테이블)' 좌표와 맨헤튼거리를 '+1' 해줘서 'Queue'에 저장
					q.offer(new int[] {nextY,nextX,d+1});
				}
			}
		}
		return true;
	}
}
