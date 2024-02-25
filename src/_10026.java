import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10026 {
	public static boolean[][] visited;
	public static int N;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static char[][] map;
	public static char[][] map2;

	public static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;
		return true;
	}

	public static void DFS(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < 4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx, ny) && !visited[nx][ny] && map[x][y] == map[nx][ny]) DFS(nx, ny);

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		map2 = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
				map2[i][j] = input.charAt(j);
				if(input.charAt(j) == 'G') map2[i][j] = 'R';
				
			}
		}
		int cnt1 = 0;
		for(int i = 0; i < N;i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					DFS(i,j);
					cnt1++;
				}
			}
		}
		visited = new boolean[N][N];
		map = map2;
		int cnt2 = 0;
		for(int i = 0; i < N;i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					DFS(i,j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}
}
