package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16234 {
	public static int N, L, R, cnt, map[][];
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static boolean moved, visited[][];
	public static ArrayList<Pair> list;
	public static void printMap() {
		for(int i =0;i < N;i++) {
			for(int j = 0; j < N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static boolean inRange(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	public static void DFS(int x, int y) {
		visited[x][y] = true;
		list.add(new Pair(x, y));
		cnt += map[x][y];
		for(int i= 0;i < 4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(inRange(nx, ny) && !visited[nx][ny] && Math.abs(map[x][y] - map[nx][ny]) >= L && Math.abs(map[x][y] - map[nx][ny]) <= R ) {
				moved = true;
				DFS(nx, ny);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int moveNum = 0;
		do {
			moved = false;
			visited = new boolean[N][N];
			for(int i = 0; i < N;i++) {
				for(int j = 0; j < N;j++) {
					if(!visited[i][j]) {
						cnt = 0;
						list = new ArrayList<>();
						DFS(i, j);
						for(int k = 0; k < list.size() ; k++) {
							map[list.get(k).x][list.get(k).y] = cnt/list.size();
						}
					}
				}
			}
			//printMap();
			if(moved) moveNum++;
		}while(moved);
		System.out.println(moveNum);
	}
	public static class Pair{
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
