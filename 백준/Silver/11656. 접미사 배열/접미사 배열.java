import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 접미사 배열 만들기
        // 2. 사전순 정렬(Arrays.sort 사용)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        String arr[] = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i,s.length());
        }

        // 배열 사전순으로 정리
        Arrays.sort(arr);

        for (int i = 0; i < s.length(); i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }
}
