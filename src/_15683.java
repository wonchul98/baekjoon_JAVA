import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15683 {
	public static class INFO<I,X,Y>{
		public I i;
		public X x;
		public Y y;
		public INFO(I i, X x, Y y) {
			this.i = i;
			this.x = x;
			this.y = y;
		}
	}
	public static int N,M, min = Integer.MAX_VALUE;
	public static int[][] map = new int[8][8];
	public static List<INFO<Integer, Integer,Integer>> CCTVList = new ArrayList<>();
	public static List<Integer> list = new ArrayList<>();
	public static int[] caseNum = {0,4,2,4,4,1};
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static boolean inRange(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	public static int count() {
		//map에서 0의 수(감시 공백) 세기
		int cnt = 0;
		for(int i = 0;i<N;i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	public static void paint(INFO info, int num) {
		switch((int)info.i) {
		case 1:{
			go((int)info.x, (int)info.y, num);
			break;
		}
		case 2:{
			go((int)info.x, (int)info.y, num);
			go((int)info.x, (int)info.y, (num+2)%4);
			break;
		}
		case 3:{
			go((int)info.x, (int)info.y, num);
			go((int)info.x, (int)info.y, (num+1)%4);
			break;
		}
		case 4:{
			go((int)info.x, (int)info.y, num);
			go((int)info.x, (int)info.y, (num+1)%4);
			go((int)info.x, (int)info.y, (num+3)%4);
			break;
		}
		case 5:{
			go((int)info.x, (int)info.y, num);
			go((int)info.x, (int)info.y, (num+1)%4);
			go((int)info.x, (int)info.y, (num+2)%4);
			go((int)info.x, (int)info.y, (num+3)%4);
			break;
		}
		}
	}
	public static void draw() {
		//list를 이용해 go명령어 사용
		for(int i = 1; i < list.size();i++) {
			paint(CCTVList.get(i-1), list.get(i));
		}
	}
	public static void go(int x, int y, int dir) {
		map[x][y] = 9;
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(inRange(nx, ny) && (map[nx][ny] == 0 || map[nx][ny] == 9 || (map[nx][ny] >= 1 && map[nx][ny] <= 5)))
			go(nx, ny, dir);
	}
	public static void DFS(int depth, int pushNum) {
		list.add(pushNum);
		
		if(depth == CCTVList.size()) {
			//System.out.println(list);
			// 그리기
			draw();
			// 계산
			min = Math.min(min,count());
			clearMap();
			list.remove(list.size()-1);
			return;
		}
		else {
			for(int i = 0;i < caseNum[CCTVList.get(depth).i];i++) {
				DFS(depth+1, i);				
			}
		}
		list.remove(list.size()-1);
		
	}
	public static void clearMap() {
		for(int i= 0;i<N;i++) {
			for(int j = 0;j < M;j++) {
				if(map[i][j] == 9) map[i][j] = 0; // 9 는 '#'역할
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					CCTVList.add(new INFO(map[i][j],i,j));
				}
			}
		}
		DFS(0,0);
		System.out.println(min);
		
	}
}