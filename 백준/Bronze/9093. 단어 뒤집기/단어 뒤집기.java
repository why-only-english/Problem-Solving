import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] words = br.readLine().split(" ");

            for (String word : words) {
                StringBuilder sb = new StringBuilder(word);
                System.out.print(sb.reverse().toString() + " ");
            }
            System.out.println();
        }
        br.close();
    }
}
