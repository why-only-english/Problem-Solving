import java.io.*;
import java.util.*;

// "anta", "tica" 이미 글자 4개
// K < 5 면 무조건 0
public class Main {
    static int N, K;
    static boolean[] visited;
    static String[] word;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        visited = new boolean[26];
        word = new String[N];

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        // "anta" "tica"
        visited['a' - 97] = true;
        visited['n' - 97] = true;
        visited['t' - 97] = true;
        visited['i' - 97] = true;
        visited['c' - 97] = true;

        for (int i = 0; i < N; i++) {
            String str = br.readLine().replaceAll("anta|tica", "");

            word[i] = str;
        }

        bfs(0, 0);
        System.out.println(answer);
    }

    static void bfs(int alpha, int count) {
        if (count == K - 5) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;

                for (int j = 0; j < word[i].length(); j++) {
                    /* 배우지않은 알파벳이 있는 경우 */
                    if (!visited[word[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    temp++;
                }
            }
            answer = Math.max(temp, answer);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i, count + 1);
                visited[i] = false;
            }
        }
    }
}
