import java.io.*;
import java.util.*;

// 그림 그려서 개수 찾아보면 1 -> 2 -> 3 -> 5 -> 8 ...
// dp[n] = dp[n-1] + dp[n-2]
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            // 10007을 마지막에 출력 시에만 나누지 말고(중간에 저장되는 값들 int 값 넘어섬)
            // d[i]을 구할 때마다 연산해 줘야 오버플로우 발생하지 않는다.
            dp[i] = ((dp[i-1] + dp[i-2]) % 10007);
        }

        System.out.println(dp[N]);
    }
}
