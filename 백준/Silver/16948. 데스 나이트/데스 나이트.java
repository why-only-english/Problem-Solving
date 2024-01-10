import java.util.*;
import java.io.*;

public class Main {

    static int N, r2, c2;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int r1 = Integer.parseInt(st.nextToken());     // 이동하기 전 x좌표
//        int c1 = Integer.parseInt(st.nextToken());     // 이동하기 전 y좌표
//
//        st = new StringTokenizer(br.readLine());
//        r2 = Integer.parseInt(st.nextToken());         // 목표 x좌표
//        c2 = Integer.parseInt(st.nextToken());         // 목표 y좌표
//
//        System.out.println(bfs(new int[]{r1, c1}));
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        System.out.println(bfs(new int[] {r1,c1}));
    }

    public static int bfs(int[] start) {
        boolean[][] v = new boolean[N][N];
        v[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(start);
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (--size >= 0) {
                int[] now = q.poll();
                // 목적지에 도달한 경우
                if (now[0] == r2 && now[1] == c2) {
                    return cnt - 1;   // 시작점 0으로 카운트 했으니까 cnt - 1
                }
                // 이동할 수 있는 6방향 탐색
                for (int d = 0; d < 6; d++) {
                    int nx = dx[d] + now[0];
                    int ny = dy[d] + now[1];
                    // 범위 내에 있고 아직 방문 하지 않은 경우
                    if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
                        v[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 목적지에 도달하지 못하는 경우
        return -1;
    }
}


// import java.util.*;
//        import java.io.*;
//
//public class sol_16948 {
//
//    static int N, r2, c2;
//    static int[] dx = {-2, -2, 0, 0, 2, 2};
//    static int[] dy = {-1, 1, -2, 2, -1, 1};
//
////    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////
////        N = Integer.parseInt(br.readLine());
////
////        StringTokenizer st = new StringTokenizer(br.readLine());
////        int r1 = Integer.parseInt(st.nextToken());     // 이동하기 전 x좌표
////        int c1 = Integer.parseInt(st.nextToken());     // 이동하기 전 y좌표
////
////        st = new StringTokenizer(br.readLine());
////        r2 = Integer.parseInt(st.nextToken());         // 목표 x좌표
////        c2 = Integer.parseInt(st.nextToken());         // 목표 y좌표
////
////        System.out.println(bfs(new int[]{r1, c1}));
////    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        int r1 = sc.nextInt();
//        int c1 = sc.nextInt();
//        r2 = sc.nextInt();
//        c2 = sc.nextInt();
//        System.out.println(bfs(new int[] {r1,c1}));
//    }
//
//    public static int bfs(int[] start) {
//        boolean[][] v = new boolean[N][N];
//        v[start[0]][start[1]] = true;
//        Queue<int[]> q = new LinkedList<int[]>();
//        q.add(start);
//        int cnt = 0;
//        while (!q.isEmpty()) {
//            int size = q.size();
//            cnt++;
//            while (--size >= 0) {
//                int[] now = q.poll();
//                // 목적지에 도달한 경우
//                if (now[0] == r2 && now[1] == c2) {
//                    return cnt - 1;   // 시작점 0으로 카운트 했으니까 cnt - 1
//                }
//                // 이동할 수 있는 6방향 탐색
//                for (int d = 0; d < 6; d++) {
//                    int nx = dx[d] + now[0];
//                    int ny = dy[d] + now[1];
//                    // 범위 내에 있고 아직 방문 하지 않은 경우
//                    if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
//                        v[nx][ny] = true;
//                        q.add(new int[]{nx, ny});
//                    }
//                }
//            }
//        }
//
//        // 목적지에 도달하지 못하는 경우
//        return -1;
//    }
//}
//import java.util.*;
//        import java.io.*;
//
//public class sol_16948 {
//
//    static int N, r2, c2;
//    static int[] dx = {-2, -2, 0, 0, 2, 2};
//    static int[] dy = {-1, 1, -2, 2, -1, 1};
//
////    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////
////        N = Integer.parseInt(br.readLine());
////
////        StringTokenizer st = new StringTokenizer(br.readLine());
////        int r1 = Integer.parseInt(st.nextToken());     // 이동하기 전 x좌표
////        int c1 = Integer.parseInt(st.nextToken());     // 이동하기 전 y좌표
////
////        st = new StringTokenizer(br.readLine());
////        r2 = Integer.parseInt(st.nextToken());         // 목표 x좌표
////        c2 = Integer.parseInt(st.nextToken());         // 목표 y좌표
////
////        System.out.println(bfs(new int[]{r1, c1}));
////    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        int r1 = sc.nextInt();
//        int c1 = sc.nextInt();
//        r2 = sc.nextInt();
//        c2 = sc.nextInt();
//        System.out.println(bfs(new int[] {r1,c1}));
//    }
//
//    public static int bfs(int[] start) {
//        boolean[][] v = new boolean[N][N];
//        v[start[0]][start[1]] = true;
//        Queue<int[]> q = new LinkedList<int[]>();
//        q.add(start);
//        int cnt = 0;
//        while (!q.isEmpty()) {
//            int size = q.size();
//            cnt++;
//            while (--size >= 0) {
//                int[] now = q.poll();
//                // 목적지에 도달한 경우
//                if (now[0] == r2 && now[1] == c2) {
//                    return cnt - 1;   // 시작점 0으로 카운트 했으니까 cnt - 1
//                }
//                // 이동할 수 있는 6방향 탐색
//                for (int d = 0; d < 6; d++) {
//                    int nx = dx[d] + now[0];
//                    int ny = dy[d] + now[1];
//                    // 범위 내에 있고 아직 방문 하지 않은 경우
//                    if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
//                        v[nx][ny] = true;
//                        q.add(new int[]{nx, ny});
//                    }
//                }
//            }
//        }
//
//        // 목적지에 도달하지 못하는 경우
//        return -1;
//    }
//}




