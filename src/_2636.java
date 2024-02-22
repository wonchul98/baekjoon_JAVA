import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2636 {
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,-1,0,1};
	public static List<Pair> l;
	public static void melt() {
		for(int i = 0; i < l.size();i++) {
			map[l.get(i).x][l.get(i).y] = 0;
		}
	}
	public static boolean isRange(int x, int y) {
		if(x >= N || x < 0 || y >= M || y < 0) return false;
		return true;
	}
	public static int BFS() {
		l = new ArrayList<>();
		visited = new boolean[N][M];
		Queue<Pair> q = new LinkedList<>();
		int cz = 0;
		q.add(new Pair(0,0));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			//System.out.println(cur);
			int x = cur.x;
			int y = cur.y;
			for(int i = 0; i < 4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
					q.add(new Pair(nx, ny));
					visited[nx][ny] = true;
				} else if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					l.add(new Pair(nx, ny));
					visited[nx][ny] = true;
					cz++;
				}
			}			
		}
		return cz;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int cheezeNum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheezeNum++;
			}
		}
		int cheezeCnt = 0;
		int num = 0; //매 시간 몇개가 녹았는지 저장
		int passed = 0;
		while(cheezeCnt < cheezeNum) {
			passed++;
			num = BFS();
			cheezeCnt+=num;
			melt();
		}
		System.out.println(passed);
		System.out.println(num);
	}
	public static class Pair{
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
		
	}
}
