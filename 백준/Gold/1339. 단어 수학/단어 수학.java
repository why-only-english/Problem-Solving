import java.io.*;
import java.util.*;

// 완전 탐색 -> 시간 초과 뜸
// 높은 값부터 9~0씩 곱하기
// ex) ACDFE -> 10000A, 1000C, 100D, 10F, 1E
// 곱해진 값(alpha[x])과 바꾸는 수(x-16)를 곱해서 ans에 ++
public class Main {

    public static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int x = 0; x < N; x++) {
            
            String line = br.readLine();
            int size = line.length();
            int base = (int) Math.pow(10, size - 1);
            
            for (int y = 0; y < size; y++) {
                alpha[line.charAt(y) - 'A'] += base;
                base /= 10;
            }
        }

        Arrays.sort(alpha);

        int ans = 0;

        for (int x = 25; x >= 17; x--) {
            ans += alpha[x] * (x - 16);
        }

        System.out.println(ans);
    }
}
