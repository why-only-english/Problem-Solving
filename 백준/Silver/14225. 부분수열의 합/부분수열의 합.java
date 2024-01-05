import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] isReachable = new boolean[2000001]; // 최대 100000*20

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // 나올 수 없는 가장 작은 자연수 구하기
        for (int i = 1; ; i++) {
            if (!isReachable[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void dfs(int current, int sum) {
        if (current == N) {
            // 구해진 값 체크
            isReachable[sum] = true;
            return;
        }

        dfs(current + 1, sum + arr[current]);
        dfs(current + 1, sum);
    }
}
