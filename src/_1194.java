package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1194 {
	public static int N, M;
	public static boolean visited[][][];
	public static char map[][];
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][65];
		int sx = 0, sy = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == '0') {
					sx = i;
					sy = j; 
				}
			}
		}
		System.out.println(BFS(sx,sy));
	}
	private static boolean inRange(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y  >= M) return false;
		return true;
	}
	private static int BFS(int sx, int sy) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(sx, sy, 0, 0));
		while(!q.isEmpty()) {
			Info cur = q.poll();
			if(map[cur.x][cur.y] == '1') return cur.day;
			for(int i = 0;i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nextKey = cur.key;
				int nextDay = cur.day+1;
				if(!inRange(nx,ny) || map[nx][ny] == '#') continue;
				if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') { //열쇠를 줍는 경우
					nextKey |= 1 << (map[nx][ny] - 'a'); // 비트 설정
				} else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') { // 문을 만난 경우
				    if((nextKey & (1 << (map[nx][ny] - 'A'))) == 0) continue; // 해당 키가 없는 경우
				}
				if(visited[nx][ny][nextKey]) continue;
				visited[nx][ny][nextKey] = true;
				q.add(new Info(nx, ny, nextDay, nextKey));
			}
		}
		return -1;
	}
	public static class Info{
		int x, y, day, key;

		public Info(int x, int y, int day, int key) {
			this.x = x;
			this.y = y;
			this.day = day;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", day=" + day + ", key=" + key + "]";
		}
	}
}