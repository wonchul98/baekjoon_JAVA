import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3109 {
	public static boolean[][] visited = new boolean[10000][500];
	public static int[][] map = new int[10000][500];
	public static int[] dx = {-1,0,1};
	public static int[] dy = {1,1,1};
	public static boolean check;
	public static int cnt =0;
	public static int R, C;
	
	public static void dfs(int a, int b) {
		visited[a][b] =true;
		if(b == C-1){
			cnt++;
			check = true;
			return;
		}
		for(int i = 0 ; i < 3 ; i++) {
			int nextX = a + dx[i];
			int nextY = b + dy[i];
			if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
				if(!visited[nextX][nextY] && map[nextX][nextY]!=1) {
					dfs(nextX, nextY);
					if(check) return;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++)
			{
				char c = input.charAt(j);
				if (c == 'x') map[i][j] = 1;
				else map[i][j] = 0;
			}
		}

		for (int i = 0; i < R; i++)
		{
			check = false;
			dfs(i, 0);
		}
		System.out.println(cnt);
	}
}
