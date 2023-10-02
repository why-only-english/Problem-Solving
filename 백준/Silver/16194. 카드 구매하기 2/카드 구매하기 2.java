import java.io.*;
import java.util.*;

// P[n] : n개 카드팩 가격
// D[n] : n개 살 때의 금액 최솟값
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 카드 N개

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            // 최솟값이 항상 0이 나옴
            // dp 초깃값을 integer의 max value로 지정
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], P[j] + dp[i - j]);
//              dp[i] = (P[j] - dp[i - j]);
            }
        }
        System.out.println(dp[N]);
    }
}
