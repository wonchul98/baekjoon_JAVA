import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int N,M;
	public static boolean[][] visited = new boolean[1000][1000];
	public static int[][] map = new int[1000][1000];
	public static Queue<Pair> q= new LinkedList<>();
	public static boolean filled() {
		for(int i = 0; i < N;i++) {
			for(int j = 0; j < M;j++) {
				if(map[i][j] ==0) return false;
			}
		}
		return true;
	}
	public static boolean inRange(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	public static class Pair<F,S>{
		private F X;
		private S Y;
		public Pair(F x, S y) {
			super();
			X = x;
			Y = y;
		}
		public F getX() {
			return X;
		}
		public void setX(F x) {
			X = x;
		}
		public S getY() {
			return Y;
		}
		public void setY(S y) {
			Y = y;
		}
		@Override
		public String toString() {
			return "( " + X + " , " + Y + " )";
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new Pair(i,j));
					visited[i][j] = true;
				}
			}
		}
		q.add(new Pair(1000,1000));
		int cnt= 0;
		while(true) {
			Queue<Pair> tq = new LinkedList<>();
			while(!q.isEmpty()) {
				Pair cur = q.poll();
				if((Integer)cur.getX() == 1000) {
					cnt++;
					continue;
				}
				for(int i = 0;i<4;i++) {
					int nx = (Integer)cur.getX() + dx[i];
					int ny = (Integer)cur.getY() + dy[i];
					if(inRange(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						map[nx][ny] = 1;
						tq.add(new Pair(nx,ny));
					}
				}
			}
			
			if(tq.isEmpty()) break;
			while(!tq.isEmpty()) {
				q.add(tq.poll());
			}
			q.add(new Pair(1000,1000));
			
		}
		
		if(filled()) System.out.println(cnt-1);
		else System.out.println(-1);
	}
}
