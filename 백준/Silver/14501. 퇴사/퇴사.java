import java.io.*;
import java.util.*;

// i + T[i] >= N + 1  no
// i + T[i] < N + 1   ok
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N + 1보다 작을 때 일 함
        int N = Integer.parseInt(br.readLine());

        // 배열 오류 안 나도록 넉넉하게 N + 10 해도 됨
        int[] T = new int[N + 1];    // 기간
        int[] P = new int[N + 1];    // 보수
        int[] DP = new int[N + 2];   // 날짜의 끝부터 첫 날까지 거꾸로 DP 배열 구현

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());   // 상담 기간
            P[i] = Integer.parseInt(st.nextToken());   // 보수
        }

        for (int i = N; i > 0; i--) {
            int next = i + T[i];  // 다음 날짜

            if (next > N + 1) {  // 퇴사 날짜를 넘어가는 경우
                DP[i] = DP[i + 1];
            } else {  // 퇴사 날짜 전인 경우
                // 1. 일하지 않았을 때(DP[i + 1])
                // 2. 일 했을 때 벌 수 있는 총 보수(P[i] + DP[next])
                DP[i] = Math.max(DP[i + 1], P[i] + DP[next]);
            }
        }

        // DP[i]부터 첫날까지 구한 값
        System.out.println(DP[1]);
    }
}
