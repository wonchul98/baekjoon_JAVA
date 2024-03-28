import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class _3055 {
	public static int N, M, dx, dy,sx, sy;
	public static char[][] map;
	public static ArrayList<Pair> list = new ArrayList<Pair>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i =0; i < N;i++) {
			String input = br.readLine();
			for(int j =0; j < M;j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'D') {
					dx = i;
					dy = j;
				}else if(map[i][j] == 'S') {
					sx = i;
					dy = j;
				} else if(map[i][j] == '*') {
					list.add(new Pair(i,j));
					
				}
				
			}
		}
		WaterBFS();
	}
	private static void WaterBFS() {
		// TODO Auto-generated method stub
		
	}
	public class Pair{
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "pair [x=" + x + ", y=" + y + "]";
		}
		
	}
}
