import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2563 {
	public static int N;
	public static int[][] map = new int[100][100];
	public static int count() {
		int cnt = 0;
		for(int i = 0; i < 100;i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(map[i][j] == 1) cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i= 0; i <N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[x+j][y+k] = 1;
				}
			}
			map[x][y] = 1;
		}
		System.out.println(count());
	}
}
