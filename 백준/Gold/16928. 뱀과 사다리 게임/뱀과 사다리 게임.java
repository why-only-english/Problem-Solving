import java.io.*;
import java.util.*;

// 주사위 1~6
// 10*10 보드판 배열 1차원으로 생각
public class Main {

    static int[] board;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());  // 사다리
        int M = Integer.parseInt(st.nextToken());  // 뱀

        board = new int[101];   // 10*10 ,1~100

        // 인덱스 번호를 원소 값으로
        for (int i = 1; i < board.length; i++) {
            board[i] = i;
        }

        // 주어진 입력에 맞게 사다리와 뱀 배치
        while ((N-- > 0) || (M-- > 0)) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 사다리나 뱀의 도착지 설정 (여긴 겹칠 수도 있음)
            board[x] = y;
        }

        int result = bfs(1);
        System.out.println(result);
    }

    private static int bfs(int startNode) {

        int[] check = new int[101];  // 방문 순서 기록할 배열

        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);  // 인덱스 1부터 시작
        check[startNode] = 0;

        while (true) {
            int visitedNum = q.poll();

            // 주사위 돌리기
            for (int i = 1; i < 7; i++) {
                int newNode = visitedNum + i;

                if (newNode > 100) {   // board 범위 넘어가면 무시
                    continue;
                }
                
                if (check[board[newNode]] == 0) {
                    q.offer(board[newNode]);
                    // visitedNum에서 주사위 굴리면 newNode로 이동
                    // 이동 횟수니까 +1
                    check[board[newNode]] = check[visitedNum] + 1;
                }

                if (board[newNode] == 100) {  // 100에 도착하면 종료
                    return check[100];
                }
            }
        }
    }
}
