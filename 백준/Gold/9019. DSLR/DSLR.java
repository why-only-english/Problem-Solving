import java.io.*;
import java.util.*;

// 땡큐 문제
// 근데 DSLR 계산법 잘 작성해야됨
// 1. bfs 탐색을 위한 queue
// 2. 방문 여부 체크 boolean array
// 3. 정답 확인 string array
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000];  // bfs 탐색의 방문 여부 체크
            String[] command = new String[10000];

            q.add(start);  // 초기 값 큐에 담기
            visited[start] = true;  // 방문 표시
            Arrays.fill(command, "");

            while (!q.isEmpty() && !visited[end]) {
                int now = q.poll();  // 큐에서 값을 뺌 == 현재 탐색 위치

                // DSLR 계산법
                int D = (2 * now) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (!visited[D]) {
                    q.add(D);  // 큐에 넣고
                    visited[D] = true;  // 방문 처리
                    command[D] = command[now] + "D";  // 명령어 추가
                }

                if (!visited[S]) {
                    q.add(S);  // 큐에 넣고
                    visited[S] = true;  // 방문 처리
                    command[S] = command[now] + "S";  // 명령어 추가
                }

                if (!visited[L]) {
                    q.add(L);  // 큐에 넣고
                    visited[L] = true;  // 방문 처리
                    command[L] = command[now] + "L";  // 명령어 추가
                }

                if (!visited[R]) {
                    q.add(R);  // 큐에 넣고
                    visited[R] = true;  // 방문 처리
                    command[R] = command[now] + "R";  // 명령어 추가
                }
            }
            System.out.println(command[end]);
        }
    }
}
