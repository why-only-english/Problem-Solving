import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 피연산자 : stack에 push
        // 연산자 : stack에서 값 2개 꺼내 연산한 값 다시 push

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 개수 입력받음
        int N = Integer.parseInt(br.readLine());

        // 숫자 배열 초기화
        double[] arr = new double[N];

        // 수식 입력받음
        String s = br.readLine();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<Double>();

        double result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+') {
                double num2 = stack.pop();
                double num1 = stack.pop();
                double num3 = num1 + num2;
                stack.add(num3);
            } else if (c == '-') {
                double num2 = stack.pop();
                double num1 = stack.pop();
                double num3 = num1 - num2;
                stack.add(num3);
            } else if (c == '*') {
                double num2 = stack.pop();
                double num1 = stack.pop();
                double num3 = num1 * num2;
                stack.add(num3);
            } else if (c == '/') {
                double num2 = stack.pop();
                double num1 = stack.pop();
                double num3 = num1 / num2;
                stack.add(num3);
            } else {
                // 문자가 알파벳인 경우, 배열에서 해당 알파벳에 대응하는 숫자를 스택에 추가
                int idx = c - 'A';
                stack.add((double) arr[idx]);
            }
        }

        // 스택에서 꺼내 출력
        double ans = stack.pop();
        System.out.printf("%.2f\n" ,ans);
    }
}

