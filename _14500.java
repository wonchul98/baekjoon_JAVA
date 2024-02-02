	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class _14500 {
		public static int N,M, maxNum = 0;
		public static int[][] map = new int[500][500];
		public static int[] dx = {0,0,1,0,-1};
		public static int[] dy = {0,1,0,-1,0};
		public static int[][] dirs = {
				{1,1,1},{2,2,2},
				{1,2,3},
				{1,1,2},{1,1,4},{2,2,1},{2,2,3},{3,3,2},{3,3,4},{4,4,1},{4,4,3},
				{2,1,2},{2,3,2},{1,2,1},{1,4,1},
				//////////
				{1,2,3},{1,3,4},{2,3,4},{1,2,4}
		};
		public static void getMax(int x, int y) {
			
			for(int i = 0; i < 15;i++) {
				//System.out.println("i: " + i);
				int num = map[x][y];
				int nx = x;
				int ny = y;
				//System.out.println(nx + " : " + ny);
				for (int j = 0; j < 3; j++) {
					//System.out.println(i + " : " + j);
					nx += dx[dirs[i][j]];
					ny += dy[dirs[i][j]];
					//System.out.println(nx + " : " + ny);
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					num += map[nx][ny];
				}
				maxNum = Math.max(num, maxNum);
			}
			for(int i = 15; i< 19;i++) {
				int num = map[x][y];
				for (int j = 0; j < 3; j++) {
					int nx = x + dx[dirs[i][j]];
					int ny = y + dy[dirs[i][j]];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					num += map[nx][ny];
				}
				maxNum = Math.max(num, maxNum);
			}
			
		}
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i =0;i<N;i++) {
				for(int j = 0;j<M;j++) {
					getMax(i,j);
				}
			}
			System.out.println(maxNum);
		}
	}
