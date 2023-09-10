import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(sol(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String sol(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // '('일 경우 스택에 push
            if (c == '(') {
                stack.push(c);
            }

            // ')'일 경우
            // 스택이 비어 있을때 ')'면 오류
            else if (stack.empty()) {
                return "NO";
            }

            // 그 외의 경우 stack 원소를 pop
            else {
                stack.pop();
            }
        }

        // 스택에 비어있으면 "YES", 요소가 남아 있으면 "NO"

        if (stack.empty()) {
            return "YES";
        }
        else {
            return "NO";
        }
    }
}
