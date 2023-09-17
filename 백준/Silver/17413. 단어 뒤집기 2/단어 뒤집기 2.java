import java.io.*;
import java.util.*;

// 단어를 기준으로 문자열 뒤집기. (공백이 기준)
// <> 인 경우에는 문자열을 뒤집지 않는다.
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 문자열 S 입력
        String str = br.readLine();

        boolean flag = false; // '<'와 '>'를 판별하기 위해 사용

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
            }
            else if (str.charAt(i) == '>') {
                flag = false;
                sb.append(str.charAt(i));
                continue;
            }

            // flag가 true('<')일 경우, '>'을 만나기 전까지 그대로 입력
            if (flag == true) {
                sb.append(str.charAt(i));
            }
            // flag가 false('>')일 경우, 괄호 이외의 문자를 처리
            else if (flag == false) {
                // 문자가 공백일 떄, 모든 원소를 pop 후 공백 추가
                if (str.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                }
                // 그 외의 경우, stack에 문자 추가
                // [A, B, C] -> [C, B, A] stack 성질 이용
                else {
                    stack.push(str.charAt(i));
                }
            }

            // 반복문이 마지막 횟수일 때, 스택이 비어있지 않는다면 원소 추가
            if (i == str.length() -1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb);
    }
}
