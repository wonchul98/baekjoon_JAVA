import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2239 {
	public static int[][] map = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0; i < 9;i++) {
			String input = br.readLine();
			for(int j = 0; j < 9;j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		dfs();
		for(int i =0; i < 9;i++) {
			for(int j = 0; j < 9;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean dfs() {
		boolean flag = false;
		int x = 0, y = 0;
		for(int i = 0 ; i < 9;i++) {
			for(int j = 0; j < 9;j++) {
				if(map[i][j] == 0) {
					flag = true;
					x = i;
					y = j;
				}
				if(flag)break;
			}
			if(flag) break;
		}
		if(!flag) return true;
		flag = false;
		//System.out.printf("dfs(%d,%d)\n", x, y);
		
		for(int k = 1; k <= 9 ; k++) {
			//System.out.println("k:" + k);
			if(!check(x, y, k)) continue;
			flag = true;
			map[x][y] = k;
			if(dfs()) return true;
		}
		map[x][y] = 0;
		return false;
		
	}

	private static boolean check(int x, int y, int k) {
		for(int i = 0; i < 9;i++) {
			if(map[x][i] == k) return false;
		}
		for(int i = 0; i < 9;i++) {
			if(map[i][y] == k) return false;
		}
		int r = x / 3;
		int c = y / 3;
		for(int i = r * 3 ; i < r * 3 + 3;i++) {
			for(int j = c * 3; j < c * 3 + 3 ; j++) {
				if(map[i][j] == k) return false;
			}
		}
		return true;
		
	}
	
}