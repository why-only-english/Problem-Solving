import java.io.*;
import java.util.*;

// 연산자 끼워 넣기
// 최댓값 최솟값 구하기
// 4칼의 배열에 각각 연산자 개수 입력하고
// 반복문 안에서 재귀 호출
// 재귀 호출 때마다 해당 연산자 인덱슬 1 감소시켜 0이 될다면 다음 연산자로 넘어감
public class Main {
    public static int MAX = Integer.MIN_VALUE;  // 최댓값
    public static int MIN = Integer.MAX_VALUE;  // 최솟값
    public static int[] opretor = new int[4];   // 연산자 개수
    public static int N;                        // 숫자 개수
    public static int[] number;                 // 숫자

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        // N 만큼 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            opretor[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수 1개 이상
            if (opretor[i] > 0) {

                // 해당 연산자 1 감소
                opretor[i]--;

                switch (i) {

                    case 0 : dfs(num + number[idx], idx + 1); break;
                    case 1 : dfs(num - number[idx], idx + 1); break;
                    case 2 : dfs(num * number[idx], idx + 1); break;
                    case 3 : dfs(num / number[idx], idx + 1); break;
                }

                // 재귀 호출 종료 시 다시 해당 연산자 개수 복원
                opretor[i]++;
            }
        }
    }
}
