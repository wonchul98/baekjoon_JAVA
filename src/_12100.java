import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12100 {
	static int N;
	static int[][] map = new int[20][20];
	static int maxNum = 0;
	//방향은 왼쪽부터 시계방향
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	
	public static void calMax(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxNum = Math.max(map[i][j], maxNum);
			}
		}
	}
	public static void move(int dir) {
		// startPoint 설정
		int s_x, s_y;
		if(dir == 0) {
			s_x = 0;
			s_y = 0;
		}
		else if(dir == 1) {
			s_x = 0;
			s_y = N-1;
		}
		else if(dir == 2) {
			s_x = N-1;
			s_y = N-1;
		}
		else {
			s_x = N-1;
			s_y = 0;
		}
		int movingDir = (dir+3)%4; //Dir기준 반시계 방향 90도  
		int curNum;
		Queue<Integer> Q = new LinkedList<>(); // 결과값을 저장할 Queue
		for (int i = 0; i < N; i++) { // s_x , s_y위치 조정
			if(i!= 0) { 
				s_x += (dx[movingDir]);
				s_y += (dy[movingDir]);
			}
			int c_x = s_x;
			int c_y = s_y;
			int pastNum = 0; 
			for(int j = 0; j < N;j++) { //각 줄에 대해서

				curNum = map[c_x][c_y];
				if(curNum == 0) {
					c_x -= dx[dir];
					c_y -= dy[dir];
					continue;
				}
				else if(pastNum == 0) pastNum = curNum;
				else if(pastNum == curNum) { //합쳐지는 경우
					Q.offer(pastNum * 2);
					pastNum = 0;
				}
				else { // pastNum , curNum 모두 0이 아니고 다른 수 인 경우
					Q.offer(pastNum);
					pastNum = curNum;
				}
				c_x -= dx[dir];
				c_y -= dy[dir];
			} //end of for
			if(pastNum != 0)Q.offer(pastNum); //마지막에 Q에 push가 안되는 경우 방지
			int cnt = 0;
			while(!Q.isEmpty()) { //Q에서 차례대로 map에 뿌리기
				map[s_x-dx[dir]*(cnt)][s_y-dy[dir]*(cnt++)] = Q.poll();
			}
			for(int k = cnt; k < N;k++) { //나머지는 0으로
				map[s_x-dx[dir]*(k)][s_y-dy[dir]*(k)] = 0;
			}
		}// end of for
	}

	public static void restoreMap(int[][] savedMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = savedMap[i][j];
			}
		}
	}
	public static void DFS(int cnt, int dir) {
		int[][] savedMap = new int[20][20]; // 백트래킹을 위한 배열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				savedMap[i][j] = map[i][j];
			}
		}

		if(cnt != 0) { //처음 오는 경우는 움직이지 않는다
			move(dir); 
		}
		
		if(cnt==5) {
			calMax();
			restoreMap(savedMap);
			return;
		}
		for(int i = 0; i < 4;i++) {
			DFS(cnt+1, i);
		}
		restoreMap(savedMap);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0,0);
		System.out.println(maxNum);
	}
}
