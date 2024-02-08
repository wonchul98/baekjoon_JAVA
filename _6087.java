import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6087 {
	public static int s_x = 100, s_y, e_x, e_y;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static Queue<INFO> q = new LinkedList<>();
	public static int[][][] MEMO = new int[100][100][4];
	public static int W, H; 
	public static char[][] map = new char[100][100];
	public static boolean arrived = false;
	public static int minCnt = Integer.MAX_VALUE;
	public static void printMemo() {
		for(int i = 0; i < H; i++) {
			for(int j =0 ; j < W;j++) {
				int min = Integer.MAX_VALUE;
				for(int k =0; k < 4;k++) min = Math.min(MEMO[i][j][k], min);
				System.out.printf("%4d ", min);
			}
			System.out.println();
		}
	}
	public static void initialize() {
		for(int i = 0; i < H;i++) {
			for(int j =0; j < W;j++) {
				for(int k = 0; k < 4;k++) {
					MEMO[i][j][k] = 9999;
				}
			}
		}
	}
	public static boolean inRange(int x, int y) {
		if(x >= H || x < 0 || y >= W || y < 0) return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		initialize();
		for (int i = 0; i < H; i++) {
			String input = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'C') {
					if(s_x == 100) {
						s_x = i;
						s_y = j;
						for(int k =0; k < 4;k++) {
							q.add(new INFO(s_x + dx[k], s_y + dy[k], k, 0));
						}
					}else {
						e_x = i;
						e_y = j;
					}
				}
			}
		}
		while(!q.isEmpty()) {
			INFO curInfo = q.poll();
			if(!inRange(curInfo.x, curInfo.y) || map[curInfo.x][curInfo.y] == '*') continue;
			//System.out.println(curInfo.toString());
			if(curInfo.x == e_x && curInfo.y == e_y) { //도착 여부 판단
				arrived = true;
				minCnt = Math.min(minCnt, curInfo.cnt);
				continue;
			}
			if(arrived && curInfo.cnt >= minCnt) continue; //가지치기 1
			if(MEMO[curInfo.x][curInfo.y][curInfo.dir] <= curInfo.cnt) continue; //가지치기2
			MEMO[curInfo.x][curInfo.y][curInfo.dir] = curInfo.cnt;
			for (int i = 0; i < 4; i++) {
				int nx = curInfo.x + dx[i];
				int ny = curInfo.y + dy[i];
				if(!inRange(nx, ny) || MEMO[nx][ny][i] <= curInfo.cnt) continue;
				if(curInfo.dir == i) { // 같은방향 진행
					q.add(new INFO(nx, ny, i, curInfo.cnt));					
				}else { // 다른 방향 진행
					q.add(new INFO(nx, ny, i, curInfo.cnt + 1));										
				}
			}
			//printMemo();
		}
		System.out.println(minCnt);
	}
	public static class INFO{
		int x, y, dir, cnt;
		public INFO(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "INFO [x=" + x + ", y=" + y + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
		
	}
}
