import java.io.*;
import java.util.StringTokenizer;
public class _3190 {
	static int N, K, L;
	static int h_x = 1,h_y =1, t_x = 1, t_y = 1;
	static int[] dx = { 0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0};
	static int dir = 0;
	static char[][] map = new char[102][102];
	static int[] seconds = new int[101];
	static char[] turns = new char[101];
	public static void print_map() {
		for(int i = 1; i <= N;i++) {
			for(int j = 1; j <= N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void initialize() {
		for(int i = 1; i <= N;i++) {
			for(int j = 1; j <= N;j++) {
				map[i][j] = 'E';
			}
		}
		map[1][1] = 'S';
	}
	public static void changeDir(char C) {
		if (C == 'L') {
	        dir = (dir + 3) % 4;
	    } else if (C == 'D') {
	        dir = (dir + 1) % 4;
	    }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		N = Integer.parseInt(br.readLine()); //map의 크기
		K = Integer.parseInt(br.readLine()); //사과 개수
		initialize();
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = 'A';
		}
		L = Integer.parseInt(br.readLine());
		int last_second = 0;
		int idx = 0;
		for(int i = 0; i < L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			char turn = st.nextToken().charAt(0);
			seconds[idx] = second;
			turns[idx++] = turn;
			//last_second = second;
		}
		int movingIdx = 0;
		int[] dirs = new int[10001];
		int tailDirIdx = 0;
		for(int curTime = 0; curTime <= 10000;curTime++) {
			//System.out.println("curTime: " + curTime);
			
			boolean appleActive = false;
			
			if(curTime == seconds[movingIdx]) {
				// 방향 바꾸는 코드
				//System.out.println("change!!");
				changeDir(turns[movingIdx]);
				movingIdx++;
			}
			dirs[curTime] = dir; //현재 머리의 이동 방향을 배열에 저장
			//1. 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
			int nx = h_x + dx[dir];
			int ny = h_y + dy[dir];
			//System.out.println("nx: " + nx + " ny: " + ny + " map: " + map[nx][ny] + " dir: " + dir);
			//2. 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
			if(map[nx][ny] == 'S' || nx <= 0 || nx > N || ny <= 0 || ny > N) { //벽이나 몸에 부딪히는 경우
				System.out.println(curTime + 1);
				return;
			}
			else if(map[nx][ny] == 'A') { //사과가 있는 경우
				//System.out.println("active");
				appleActive = true;
			}
			map[nx][ny] = 'S'; // 머리 이동
			h_x = nx;
			h_y = ny;
	
			//3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
			if(appleActive) {
				tailDirIdx -=1;
			}
			//4. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
			else {
				map[t_x][t_y] = 'E'; //꼬리 이동
				t_x += dx[dirs[tailDirIdx]];
				t_y += dy[dirs[tailDirIdx]];
			}
			//System.out.println("t_x: " + t_x + " t_y: " + t_y + " tailIdx: " + tailDirIdx);
			tailDirIdx++;
			//print_map();
		} //end of for
		System.out.println(10001);
		
	} // end of main
}
