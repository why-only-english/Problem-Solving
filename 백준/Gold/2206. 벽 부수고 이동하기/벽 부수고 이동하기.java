import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 벽 부수기 1번만 가능
// 최단 거리 이동 방향에 벽이 있을 때랑 없을 때 구분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // (1, 1) -> (1, 1)
        if (N - 1 == 0 && M - 1 == 0) {
            System.out.println(1);
            System.exit(0);
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] map = new char[N][M];  // 맵 배열
        int[][] dist = new int[N][M];    // 거리 측정 배열
        boolean[][][] visited = new boolean[2][N][M];  // 벽 부수기 여부 구분
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // x좌표, y좌표, 벽 부수기 여부
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];

                // 주어진 입력에 맞게 탐색
                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                // 다음 칸에 벽이 있을 때
                // (1) 벽을 부순적이 있는지 체크
                // (2) 그 벽을 방문한적이 있는지 체크
                if (map[nX][nY] == '1') {
                    if(cur[2] == 0 && !visited[1][nX][nY]){
                        visited[cur[2]][nX][nY] = true;    // 방문 처리
                        dist[nX][nY] = dist[cur[0]][cur[1]] + 1; // 거리 측정
                        q.offer(new int[]{nX, nY, 1});    // 다시 큐에 넣고 탐색
                    }
                }

                // 벽 아닐 때
                else  {
                    if(!visited[cur[2]][nX][nY]){
                        // 해당 칸을 방문을 안했을 때!
                        visited[cur[2]][nX][nY] = true;    // 방문 처리
                        dist[nX][nY] = dist[cur[0]][cur[1]] + 1; // 거리 측정
                        q.offer(new int[]{nX, nY, cur[2]}); // 다시 큐에 넣고 탐색
                    }
                }

                // 도착지점에 도달 했을 때 출력하고 종료!
                if(nX == N-1 && nY == M-1){
                    System.out.print(dist[nX][nY] + 1);
                    System.exit(0);
                }
            }
        }
        // 실패했을 때
        System.out.println(-1);
    }
}
