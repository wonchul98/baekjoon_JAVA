package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _18808 {
	public static int R, C, cnt = 0, map[][];
	public static void printMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void stick(INFO i) {
		for (int idx = 0; idx < 4; idx++) {
			boolean able = false;
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					if(j + i.N > R || k + i.M > C) continue;
					able = true;
					for(Pair p : i.list) {
						if(map[j + p.x][k + p.y] == 1) { //이미 붙은 곳
							able = false;
							break;
						}
					}
					if(able) {
						cnt += i.list.size();
						for(Pair p : i.list) {
							map[j + p.x][k + p.y] = 1;
						}
						//printMap();
					}
					if(able) break;
				}
				if(able) break;
			}
			if(able) break;
			i = turnLeft(i);
		}
	}

	public static INFO turnLeft(INFO i) {
		INFO newI = new INFO(i.M, i.N, new ArrayList<Pair>());
		for (Pair p : i.list) {
			newI.list.add(new Pair(p.y, i.N - p.x - 1));
		}
		return newI;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		INFO[] infoArr = new INFO[K];
		map = new int[R][C];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ArrayList<Pair> l = new ArrayList<>();
			for (int j = 0; j < a; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < b; k++) {
					if (Integer.parseInt(st.nextToken()) == 1)
						l.add(new Pair(j, k));
				}
			}
			infoArr[i] = new INFO(a, b, l);
		}
		for (int i = 0; i < K; i++) {
			stick(infoArr[i]);
		}
		System.out.println(cnt);
	}

	public static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}

	public static class INFO { // 스티커 정보
		int N, M;
		ArrayList<Pair> list;

		public INFO(int n, int m, ArrayList<Pair> list) {
			N = n;
			M = m;
			this.list = list;
		}

		@Override
		public String toString() {
			return "INFO [N=" + N + ", M=" + M + ", list=" + list + "]";
		}
		
	}
}
