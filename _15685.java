import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
// 반시계 : 1
// 시계  : -1

public class _15685 {
	public static int N, M, x, y, d, g;
	
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static boolean[][] vertex = new boolean[101][101];
	
	public static List<Integer> list = new ArrayList<>();
	
	public static int count() {
		int cnt = 0;
		for(int i = 0 ; i < 100;i++) {
			for(int j = 0; j < 100;j++) {
				if(vertex[i][j] && vertex[i+1][j] && vertex[i][j+1] && vertex[i+1][j+1]) cnt++;
			}
		}
		return cnt;
	}
	public static void draw() {
		for(int i = 0; i <= list.size();i++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			//System.out.printf("x : %d, y : %d, nx : %d, ny : %d, d : %d\n", x, y, nx, ny, d);
			vertex[x][y] = true;
			vertex[nx][ny] = true;
			x = nx;
			y = ny;
			if(i == list.size()) break;
			d = (d + list.get(i) + 4) % 4;
		}
	}
	public static void Turn(int idx) {
		if(idx == g) {
			return;
		} else {
			List<Integer> newList = new ArrayList<>(list);
			newList.add(1);
			Collections.reverse(list);
			for(int i = 0; i < list.size();i++) {
				list.set(i, list.get(i) * (-1));
			}
			newList.addAll(list);
			list = newList; // 얕 복
			Turn(idx+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			Turn(0);
			//System.out.println(list.toString());
			draw();
		}
		System.out.println(count());
	}
}