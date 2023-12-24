import java.io.*;
import java.util.*;


// 동전 2개 좌표 계산해서 그래프
public class Main {
    static class Coin {
        int x;
        int y;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return ""+x+y;
        }
    }

    static String[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] metaData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new String[metaData[0]][metaData[1]];
        Coin coin1 = null;
        Coin coin2 = null;
        
        // map 통해 동전의 초기 위치 찾기
        for (int row = 0; row < map.length; row++) {
            map[row] = br.readLine().split("");
            for (int col = 0; col < map[0].length; col++){
                if (map[row][col].equals("o")){
                    if (coin1 == null) coin1 = new Coin(col, row);
                    else coin2 = new Coin(col, row);
                }
            }
        }

        System.out.printf("%d", bfs(coin1, coin2));
    }

    public static int bfs(Coin coin1, Coin coin2){
        Queue<Coin[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        queue.offer(new Coin[]{coin1, coin2});
        visited.add(coin1.toString()+coin2.toString());

        int depth = 1;
        while (!queue.isEmpty()){
            // 10 초과하면 -1 return
            if (depth > 10) return -1;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Coin[] coins = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx1 = coins[0].x + dx[j];
                    int ny1 = coins[0].y + dy[j];
                    int nx2 = coins[1].x + dx[j];
                    int ny2 = coins[1].y + dy[j];

                    // 한 개만 벽 밖으로 나갔는지
                    if (!isOutOfMap(nx1, ny1) && isOutOfMap(nx2, ny2) || isOutOfMap(nx1, ny1) && !isOutOfMap(nx2, ny2)) {
                        // 성공 조건 -> depth 값 return
                        return depth;
                    }
                    // 둘 다 맵 벗어난 경우 -> 다음 반복으로 이동
                    if (isOutOfMap(nx1, ny1) && isOutOfMap(nx2, ny2)) {
                        continue;
                    }
                    // 동전이 벽에 닿은 경우 -> 위치 되돌리기
                    if (isWall(nx1,ny1)){
                        nx1 -= dx[j];
                        ny1 -= dy[j];
                    }
                    if (isWall(nx2, ny2)) {
                        nx2 -= dx[j];
                        ny2 -= dy[j];
                    }
                    // 동전 겹칠 경우 -> 다음 반복으로 이동
                    if (nx1 == nx2 && ny1 == ny2) {
                        continue;
                    }

                    // 이미 방문한 경우 건너뛰기
                    String visitMark = "" + nx1 + ny1 + nx2 + ny2;
                    if (visited.contains(visitMark)) {
                        continue;
                    }
                    // 정상적인 이동
                    visited.add(visitMark);
                    queue.offer(new Coin[]{new Coin(nx1,ny1),new Coin(nx2,ny2)});
                }
            }
            depth++;
        }
        // 무한 루프에 빠지면 여기에 도착함
        // 계속 벽에 닿거나
        // 이미 방문한 곳을 계속 가거나
        // 같이 떨어지는 경우밖에 없거나
        return -1;
    }
    public static boolean isOutOfMap(int x, int y) {
        return (x < 0 || x > map[0].length - 1 || y < 0 || y > map.length - 1);
    }

    public static boolean isWall(int x, int y) {
        return map[y][x].equals("#");
    }
}
