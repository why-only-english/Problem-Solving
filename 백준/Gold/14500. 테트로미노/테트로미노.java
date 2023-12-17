import java.io.*;
import java.util.*;

public class Main {

	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int N, M;
	static boolean[][] visit;
	static int[][] d;
	static int answer=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		d=new int[N][M];
		visit=new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				d[i][j]=Integer.parseInt(st.nextToken());
			}
		}
        
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visit[i][j]=true;
				dfs(i, j, 1, d[i][j]);
				visit[i][j]=false;
			}
		}
        
		System.out.println(answer);
	}
	
	static void dfs(int x, int y, int cnt, int sum) {
		if(cnt==4) {
			answer=Math.max(answer, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(visit[nx][ny]) continue;
			
			visit[nx][ny]=true;
			
			if(cnt==2) dfs(x,y,cnt+1,sum+d[nx][ny]);
			dfs(nx, ny, cnt+1, sum+d[nx][ny]);
			visit[nx][ny]=false;
		}
	}
}