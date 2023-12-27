import java.util.*;
import java.io.*;


// 입력 받기 -> 인접 행렬에 값 넣어주기 -> DFS 실행 -> 출력
public class Main {

    static boolean[] check;  // 이미 바이러스에 감염되었는지를 판단
    static int[][] arr;      // 인접 행렬 표현하기 위한 배열
    static int count = 0;

    static int node, line;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;    // 1-2 or 2-1 똑같음
        }

        dfs(1);

        System.out.println(count - 1);
    }

    private static void dfs(int start) {

        // 1번은 이미 바이러스 걸렸으니 count 1부터 시작
        check[start] = true;
        count++;

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}
