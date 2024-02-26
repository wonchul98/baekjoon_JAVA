import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3197 {	
	public static int R, C, s_x, s_y, minCnt = Integer.MAX_VALUE, prt = 0;
	public static char[][] map;
	public static int[][] wMap;
	public static boolean[][] visited;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	
	public static int BFS() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(s_x, s_y));
		q.add(new Pair(-1,-1));
		int todayMin = Integer.MAX_VALUE;
		int rst = 0;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			System.out.println("cur: " + cur);
			if(cur.x == -1) {
				if(q.isEmpty()) break;
				rst = Math.max(rst, todayMin);
				System.out.println("rst: " + rst);
				todayMin = Integer.MAX_VALUE;
				boolean update = false;
				q.add(new Pair(-1, -1));
			}
			for(int i = 0; i < 4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(inRange(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Pair(nx, ny));
					if(wMap[nx][ny]!= 0)
						todayMin = Math.min(todayMin, wMap[nx][ny]);
				}
			}
		}
		return rst;
	}
	public static boolean inRange(int x, int y) {
		if(x < 0 || y < 0 || x >= R || y >= C) return false;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		wMap = new int[R][C];
		visited = new boolean[R][C];
		for(int i= 0;i < R;i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'L') {
					s_x = i;
					s_y = j;
				}
			}
		}
		Queue<Pair> q= new LinkedList<>();	
		for(int i= 0;i < R;i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.' || map[i][j] == 'L') {
					for(int k= 0;k < 4;k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(inRange(nx, ny) && !visited[nx][ny] && map[nx][ny]=='X') {
							q.add(new Pair(nx, ny));
							visited[nx][ny] = true;
							wMap[nx][ny] = 1;
						}
					}
				}
			}
		}
		q.add(new Pair(-1,-1));
		int day = 2;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			if(cur.x == -1) {
				day++;
				if(q.isEmpty()) break;
				q.add(new Pair(-1,-1));
			}
			for(int i = 0; i < 4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(inRange(nx, ny) && !visited[nx][ny] && map[nx][ny]=='X') {
					q.add(new Pair(nx, ny));
					visited[nx][ny] = true;
					wMap[nx][ny] = day;
				}
			}
		}
		printMap();
		visited = new boolean[R][C];
		visited[s_x][s_y] = true;
		System.out.println(BFS());
		
	}
	public static void printMap() {
		for(int i= 0; i < R;i++) {
			for(int j = 0; j < C;j++) {
				System.out.print(wMap[i][j] + " ");
			}
			System.out.println();
		}
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
