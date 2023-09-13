import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        // 큐에 1~N까지 값을 offer
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 큐의 사이즈가 1일 때까지 반복
        // 먼저 옮기고 빼는 게 핵심 (queue는 가장 먼저 들어간 값부터 나오니까, K 번째를 뺄 수 없음 -> K 번째를 옮겨야 됨)
        while(q.size() != 1) {
            // K - 1번째까지는 처음에 있던 값을 맨 뒤로 보냄
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            // K번째 값은 poll한 후 출력
            sb.append(q.poll() + ", ");
        }

        // 큐의 사이즈가 1일 때는 poll
        sb.append(q.poll() + ">");

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
