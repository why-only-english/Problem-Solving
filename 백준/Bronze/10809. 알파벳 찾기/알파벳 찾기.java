import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳 개수 저장
        int[] arr = new int[26];

        // 모두 -1로 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 동일 문자가 포함된 경우 처음 나타난 위치
            // 원소 값이 -1인 경우에만 초기화
            if (arr[c - 97] == -1) {
                arr[c - 97] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
