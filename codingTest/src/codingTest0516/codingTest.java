package codingTest0516;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.time.*;
import java.time.format.*;


public class codingTest {
	//거리 최소화
	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};

		boolean[][] visit = new boolean[n][m];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[]{0,0});
		visit[0][0] = true;

		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			for(int i=0; i<4 ;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx>=0 && ny>=0 && nx<n && ny < m) {
					if(!visit[nx][ny] && maps[nx][ny] == 1) {
						q.offer(new int[] {nx,ny});
						visit[nx][ny] = true;
						maps[nx][ny] = maps[x][y] +1;
					}
				}
			}
		}
		return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
	}
	//위상정렬
	public int[] solution(int n , int edges[][]) {
		ArrayList<Integer>[] gra = new ArrayList[n+1];
		int[] ind = new int[n+1];

		for(int i=1; i<=n; i++) {
			gra[i] = new ArrayList<>();
		}

		for(int i=0; i<edges.length;i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			gra[u].add(v);
			ind[v]++;
		}

		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		for(int i=1; i<=n; i++) {
			if(ind[i] == 0) {
				q.offer(i);
			}
		}

		while(!q.isEmpty()) {
			int now = q.poll();
			result.add(now);

			for(int i=0; i<gra[now].size(); i++) {
				int next = gra[now].get(i);
				ind[next]--;
				if(ind[next] == 0) {
					q.offer(next);
				}
			}
		}
		int answer[] = new int[result.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}
	//중복없이 경로 찾기
	int n;
	int[][] bor;
	boolean[][] visit;
	int[] dx = {0,0,-1,1};
	int[] dy = {-1,1,0,0};
	int counter =0;
	public int soultion(int nInput, int[][] inputBoard) {

		n = nInput;
		bor = inputBoard;
		visit = new boolean[n][n];
		visit[0][0] = true;
		
		dfs(0,0);
		
		return counter;
	}

	public void dfs(int x , int y) {
		if(x == n-1 && y == n-1) {
			counter++;
			return;
		}
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx>=0 && ny >= 0 && nx<n && ny<n) {
				if(!visit[nx][ny] && bor[nx][ny] == 0) {
					visit[nx][ny] = true;
					dfs(nx,ny);
					visit[nx][ny] = false;
				}
			}
		}
	}
	//필렌드롬
	public int solution(String s) {
		int returnMax = 1;

		for(int i=0; i<s.length(); i++) {

			int left = i;
			int right = i;

			while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				returnMax = Math.max(returnMax, right-left +1);
				left--;
				right++;
			}

			left = i;
			right = i+1;

			while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				returnMax = Math.max(returnMax, right-left +1);
				left --;
				right ++;
			}
		}
		return returnMax;
	}

	public int solutionOne(String s) {
		int returnMin = s.length();

		for(int len = 1; len<=s.length()/2; len++) {
			StringBuilder sb = new StringBuilder();
			String prevString = s.substring(0,len);
			int counter = 1;
			//a a b b a c c c length 8
			//2a2ba3c
			//0 1 2 3 4 5 6 7
 			for(int i=len; i<s.length(); i++) {
				String currentString = (i+len <= s.length()) ? s.substring(i,i+len) : s.substring(i);
				
				if(currentString.equals(prevString)) {
					counter++;
				}else {
					if(counter > 1) {
						sb.append(counter);
					}
					sb.append(prevString);
					prevString = currentString;
					counter = 1;
				}
			}
			if(counter > 1) {
				sb.append(counter);
			}
			sb.append(prevString);
			returnMin = Math.min(returnMin, sb.length());
		}
		return returnMin;
	}
	//트리
	public int solutionTwo (int n, int[][] edges) {
		List<Integer>[] gra = new ArrayList[n+1];
		boolean[] visit = new boolean[n+1];
		int[] maxDepth = new int[1];

		for(int i=1; i<=n; i++) {
			gra[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<edges.length;i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			gra[u].add(v);
			gra[v].add(u);
		}

		dfs(1,1,gra,visit,maxDepth);

		return maxDepth[0];
	}

	public void dfs(int node, int depth, List<Integer>[] gra, boolean[] visit, int[] maxDepth ) {
		visit[node] = true;

		if(depth > maxDepth[0]) {
			maxDepth[0] = depth;
		}

		for(int i=0; i<gra[node].size(); i++) {
			int next = gra[node].get(i);
			if(!visit[next]) {
				dfs(next,depth+1,gra,visit,maxDepth);
			}
		}
	}
}



