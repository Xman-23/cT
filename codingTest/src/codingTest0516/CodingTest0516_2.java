package codingTest0516;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CodingTest0516_2 {

}
class CT {
    int n;
    int[][] board;
    boolean[][] visited;
    int[] dx = {0, 0, -1, 1}; // 상하좌우
    int[] dy = {-1, 1, 0, 0};
    int count = 0;
    //중복 없는 경로 찾기
    public int solutionOne(int nInput, int[][] inputBoard) {
        n = nInput;
        board = inputBoard;
        visited = new boolean[n][n];
        visited[0][0] = true;

        dfs(0, 0);

        return count;
    }

    public void dfs(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            count++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && board[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }
    }
    //위상 정렬
    public int[] solution(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 구성 및 진입 차수 계산
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            graph[from].add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        // 진입 차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 결과를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
    //최단 거리
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[x][y] + 1; // 거리 누적
                    }
                }
            }
        }

        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}