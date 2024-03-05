import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _11559 {
	public static boolean[][] visited;
	public static char[][] map;
	public static int dx[] = {-1,0,1,0};
	public static int dy[] = {0,1,0,-1};
	public static void printMap() {
		System.out.println("-----------------------------");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static boolean inRange(int x, int y) {
		if(x < 0 || x>=12 || y < 0 || y >=6) return false;
		return true;
	}
	public static ArrayList<Pair> BFS(int x, int y){
		ArrayList<Pair> list = new ArrayList<>();
		Queue<Pair> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Pair(x, y));
		char c = map[x][y];
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			list.add(cur);
			for(int i = 0 ; i < 4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] != c) continue;
				visited[nx][ny] = true;
				q.add(new Pair(nx, ny));
			}
		}
		return list;
	}
	public static boolean puyo() {
		boolean changed = false;
		visited = new boolean[12][6];
		for(int i = 0; i < 12;i++) {
			for(int j = 0; j < 6;j++) {
				if(map[i][j]!='.' && !visited[i][j]) {
					ArrayList<Pair> list = BFS(i,j);
					if(list.size() >= 4) {
						changed = true;
						for(Pair p : list) map[p.x][p.y] = '.';
					}
				}
			}
		}
		//printMap();
		if(changed) {
			for(int i = 0; i < 6;i++) {
				Queue<Character> q = new LinkedList<>();
				for(int j = 11; j >= 0;j--) {
					if(map[j][i]!='.') q.add(map[j][i]);
				}
				int size = q.size();
				for(int j = 11; j > 11-size;j--) {
					map[j][i] = q.poll();
				}
				for(int j = 11-size; j >= 0;j--) {
					map[j][i] = '.';
				}
			}
		}
		//printMap();
		return changed;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for(int i= 0; i < 12;i++) {
			String input = br.readLine();
			for(int j = 0 ; j < 6;j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		int cnt = 0;
		while(puyo()) {
			cnt++;
		}
		System.out.println(cnt);
	}
	public static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
