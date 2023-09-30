import java.io.*;
import java.util.*;

//3 : 3(1개) / 21(2개) / 111(1) -> 4
//
//4 : 3+1 / 1+3 / 2+2 / 2+1+1 / 1+2+1 / 1+1+2 / 1111
//3 - 2개 2 - 4개 1 - 1개  -> 7
//
//5 : 32(2개) / 311(3개) / 221(3개) / 2111(4개) / 11111
//3 - 5개 2 - 7개 1 - 1개 -> 13
//
//6 : 33(1개) / 321(6개) / 3111(4개) / 222(1개) / 2211(6개) / 21111(5개) / 111111
//3 - 11개 2 - 12개 1 - 1개 -> 24
//
//7 : 331(3개) / 322(3개) / 3211 (12개) / 31111(5개) / 2221(4개) 22111(10개) / 211111(6개) /
//3 - 23개 2 - 20개 1- 1개 -> 44

// 1 -> 2 -> 4 -> 7 -> 13 -> 24 -> 44
// dp[n] = dp[n-3] + dp[n-2] + dp[n-1]
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[12]; // 11로 하면 ArrayIndexOutOfBoundsException

        // 초기 값 초기화
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 점화식
        for (int i = 4; i <= 11; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]);
        }

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(dp[t] + "\n");
        }
        System.out.println(sb);
    }
}
