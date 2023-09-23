import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 후위 표기식2를 먼저 풀어서 비슷하게 해결
        // stack에 연산자만 넣어서 처리하는 방식
        // 인줄 알고 쉽게 봤는데 오래 걸려서 블로그 보고 풀었음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack =new Stack<>();

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            switch (c) {
                // '(' 만나면 일단 스택에 넣기
                case '(':
                    stack.push(c);
                    break;
                // ')' 만나면 '('가 앞에 나온 모든 연산자 출력
                case ')':
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                // 곱하기이랑 나누기일 때 더하기 빼기 출력하지 않고 곱하기 나누기만 출력
                case '*':
                case '/':
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                // 더하기 빼기는 직전의 연산자 모두 출력
                // '('가 나오면 멈추고 case '('에서 처리
                case '+':
                case '-':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                // 피연산자일 때는 그대로 출력
                default:
                    sb.append(c);
                    break;
            }
        }

        // 남은 연산자 있으면 모두 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
