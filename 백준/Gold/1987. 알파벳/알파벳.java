import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int R, C;
    static int[][] map;
    static boolean[] visited = new boolean[26]; // 알파벳 방문 여부를 저장하는 배열
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new int[R][C];

        // map 배열에 [R][C] 크기의 알바벳 입력하여 2차원 배열 생성
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        visited[map[0][0]] = true; // 시작 지점 알파벳 방문 체크
        dfs(0, 0, 1); // 1행 1열 (0, 0)부터 시작, 현재 이동한 위치는 1회

        System.out.println(ans);
    }

    private static void dfs(int x, int y, int count) {
        ans = Math.max(ans, count);  // 정답 갱신

        // 상하좌우 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            // 범위 체크 및 방문한 알파벳이 아닌 경우
            if (isValid(cx, cy) && !visited[map[cx][cy]]) {
                visited[map[cx][cy]] = true; // 알파벳 방문 체크
                dfs(cx, cy, count + 1);
                visited[map[cx][cy]] = false; // dfs가 종료되면 알파벳 방문 체크를 해제
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}