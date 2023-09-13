import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // int형 queue 선언, linkedlist 이용
        Queue<Integer> que = new LinkedList<Integer>();

        int last = 0;   // push X 일 때 정수 X를 저장하기 위한 변수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

                switch (S) {
                    case "push" :
                        last = Integer.parseInt(st.nextToken());
                        que.add(last);
                        // System.out.println(last);
                        break;
                    case "pop" :
                        if (que.isEmpty()) sb.append(-1).append("\n");
                        else sb.append(que.poll()).append("\n");
                        break;
                    case "size" :
                        sb.append(que.size()).append("\n");
                        break;
                    case "empty" :
                        if (que.isEmpty()) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;
                    case "front" :
                        if (que.isEmpty()) sb.append(-1).append("\n");
                        else sb.append(que.peek()).append("\n");
                        break;
                    case "back" :
                        if (que.isEmpty()) sb.append(-1).append("\n");
                        else sb.append(last).append("\n"); // push 명령에 있는 last 이용
                        break;
                }
        }
        System.out.println(sb);
    }
}
