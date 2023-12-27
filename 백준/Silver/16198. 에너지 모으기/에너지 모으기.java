import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static List<Integer> numList;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }

        dfs(N, 0);
        System.out.println(max);
    }

    public static void dfs(int length, int sum) {
        if (length == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < length - 1; i++) {
            int energy = numList.get(i - 1) * numList.get(i + 1);
            int tmp = numList.remove(i);
            dfs(length - 1, sum + energy);
            numList.add(i, tmp);
        }
    }
}
