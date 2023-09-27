import java.io.*;
import java.util.*;

// DP(Dynamic Programming)
// 주어진 문제를 작은 문제로 쪼개서 풀어나감에 있어 반복되는 호출을 줄이는 방법
// 반복되는 문제는 한 번만 푼다 == 이미 풀렸던 값은 재활용
// 기억하기(Memoization)

public class Main {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.print(recur(N));
    }

    // 무조건 큰 수로 나눈다고 장땡이 아님
    // 10 -> 5 -> 4 -> 2 -> 1(4번)  10 -> 9 -> 3 -> 1(3번)
    // 6으로 나눠지는 경우 3으로 나누는 경우와 2로 나누는 경우 1을 빼는 경우 모두 재귀 호출
    // 3으로만 나눠지는 경우 3으로 나누는 경우와 1을 빼는 경우 재귀 호출
    // 2로만 나눠지는 경우 2로 나누는 경우와 1을 빼는 경우 재귀 호출
    static int recur(int N) {

        if (dp[N] == null) {
            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나눠지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
