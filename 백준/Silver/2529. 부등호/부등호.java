import java.io.*;
import java.util.*;

// 숫자 0부터 기준을 잡고
// 부등호와 모든 숫자에 대해 비교
public class Main {

    static int N;              // 부등호 개수
    static int[] numbers;      // 0~9 숫자 배열
    static char[] arr;         // 부등호 배열
    static boolean[] visited;  // 숫자 사용 여부 체크 배열
    
    // 부등호를 만족하는 순열 저장하는 리스트
    static ArrayList<String> answer = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) + 1;
        arr = new char[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 부등호 배열에 저장
        for (int i = 0; i < N-1; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        // 0~9 숫자 배열 생성
        numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }

        // 0~9 숫자를 시작점으로 하여 DFS 수행
        for (int i = 0; i < 10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            dfs(i,0, i+"");
            visited[i] = false;
        }

        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));
    }

    private static void dfs(int start, int cnt, String word) {
        if (word.length() == N) {  // 부등호의 모든 조건을 만족하면 종료
            answer.add(word);
            return;
        }

        // 0~9까지 숫자 탐색
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                char tmp = arr[cnt];
                if (tmp == '>') {     // '>'인 경우
                    if (start > i) {  // 시작 숫자보다 작은 숫자 찾아서 DFS 호출
                        visited[i] = true;
                        dfs(i, cnt + 1, word + i);
                        visited[i] = false;
                    }
                }
                else {                // '<'인 경우
                    if (start < i) {  // 시작 숫자보다 큰 숫자 찾아서 DFS 호출
                        visited[i] = true;
                        dfs(i, cnt + 1, word + i);
                        visited[i] = false;
                        }
                    }
                }
            }
        }
    }
