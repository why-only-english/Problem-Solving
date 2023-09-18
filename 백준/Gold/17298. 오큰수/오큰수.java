import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            // 1. 스택이 비어있을 때까지 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
            // stack의 원소를 pop 하면서 해당 인덱스의 값을 현재 원소로 바꿔줌
            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                input[stack.pop()] = input[i];
            }

            stack.push(i);
        }

        // 2. 스택에 있는 모든 요소를 pop 하면서 -1로 초기화
        while (!stack.isEmpty()) {
            input[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(input[i]).append(' ');
        }

        System.out.println(sb);
    }
}
