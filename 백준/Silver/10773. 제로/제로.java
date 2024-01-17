import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> nct = new Stack<>();

        for (int i = 0; i < K; i++) {
            int M = Integer.parseInt(br.readLine());   // 넣을 숫자들 입력

            if (M == 0) { nct.pop(); }
            else { nct.push(M); }
        }

        int sum = 0;
        for (int num : nct) {
            sum += num;
        }
        System.out.println(sum);
//        System.out.println(nct);
    }
}
