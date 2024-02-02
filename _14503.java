import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14503 {
	public static int N, M, x, y, d;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int[][] map = new int[50][50];
	public static int cleanCnt = 0;
	public static boolean move() {
		System.out.println(x + " : " + y);
		if(map[x][y]==0) { //청소가 안되어 있는 경우
			map[x][y] = 2; // 2는 cleaned
			cleanCnt++;
		}
		boolean notCleaned = false;
		for(int i = 0; i < 4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			System.out.println(nx + " : " + ny + " : " + map[nx][ny]);
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(map[nx][ny] == 0) { //청소되지 않은 빈칸 -> 0
				notCleaned = true;
				break;
			}
		}
		System.out.println(notCleaned);
		int nx, ny;
		if(notCleaned) { //청소되지 않은 빈 칸이 있는 경우
			d = (d+3)%4; // 반 시계 방향 회전
			nx = x + dx[d];
			ny = y + dy[d];
			if(map[nx][ny]==0) { //바라보는 방향이 청소되지 않은 빈 칸인 경우
				x = nx; //전진
				y = ny;
			}
			return true; //1번으로 돌아가기
		}else {  //청소되지 않은 빈 칸이 없는 경우
			nx = x - dx[d];
			ny = y - dy[d];
			if(map[nx][ny] == 1) return false;
			x = nx;
			y = ny;
			return true;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()); 
		y = Integer.parseInt(st.nextToken()); 
		d = Integer.parseInt(st.nextToken()); 
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(move());
		System.out.println(cleanCnt);
	}
}
