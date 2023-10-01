import java.io.*;
import java.util.*;

// P[n] : n개 카드팩 가격
// D[n] : n개 살 때의 금액 최댓값
// D[i] = P[n] + D[i-n]
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 카드 N개

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        // 두 번째 줄은 요소 하나하나를 가져와야 하기 때문에 readLine() 을 통해서 읽고
        // StringTokenizer를 통해 따로 입력을 읽고 배열에 집어넣기
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], P[j] + dp[i - j]);
//              dp[i] = (P[j] + dp[i - j]);
            }
        }
        System.out.println(dp[N]);
    }
}
