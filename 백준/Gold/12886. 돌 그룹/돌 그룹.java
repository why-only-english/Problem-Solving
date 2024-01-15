import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        // 돌을 같은 개수로 만들 수 있으면 1을, 아니면 0을 출력
        System.out.println(bfs(A, B, C) ? 1 : 0);
    }

    private static boolean bfs(int a, int b, int c) {

        // X+X = Y-X
        // 3X = Y
        if((a+b+c) % 3 != 0) return false;

        // Queue에 초기 상태 삽입
        Queue<Stone> q = new LinkedList<>();
        boolean[][] isChecked = new boolean[1501][1501];

        q.add(new Stone(a, b, c));
        isChecked[a][b] = true;

        while (!q.isEmpty()) {
            Stone s = q.poll();

            a = s.a;
            b = s.b;
            c = s.c;

            // 3개 모두 같아지면 true
            if (a == b & b == c) return true;

            // 2개씩 뽑아서 연산
            // 새로운 a, b, c -> na, nb. nc
            if(a != b) {
                int na = a > b ? a - b : a + a;
                int nb = a > b ? b + b : b - a;

                if(!isChecked[na][nb]) {
                    q.add(new Stone(na, nb, c));
                    isChecked[na][nb] = true;
                }
            }
            if(b != c) {
                int nb = b > c ? b - c : b + b;
                int nc = b > c ? c + c : c - b;

                if(!isChecked[nb][nc]) {
                    q.add(new Stone(a, nb, nc));
                    isChecked[nb][nc] = true;
                }
            }
            if(a != c) {
    			int na = a > c ? a-c : a+a;
    			int nc = a > c ? c+c : c-a;
    			
    			if(!isChecked[na][nc]) {
    				q.add(new Stone(na, b, nc));
    				isChecked[na][nc] = true;
    			}
    		}
        }

        // 연산 다 끝나도 3개 모두 같아지는 경우가 없으면 false
        return false;
    }

    static class Stone {
        int a, b, c;

        Stone(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
