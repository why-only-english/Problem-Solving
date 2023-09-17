import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 1. '(' : stack에 push
        // 2. ')' : 앞에 있는 값이 '(' 일 때는 레이저니까 스택의 길이만큼 더하기
        // 3. ')' : 앞에 있는 값이 ')' 일 때는 막대기니까 + 1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        Stack<Character> stack = new Stack<>();

        int sum = 0;

        for (int i = 0; i < S.length(); i++) {
            // 1번 경우
            if (S.charAt(i) == '(') {
                stack.push('(');
            }
            else {
                // 2번 경우
                if (S.charAt(i - 1) == '(') {
                    stack.pop();
                    sum += stack.size();
                }
                // 3번 경우
                else  {
                    stack.pop();
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
