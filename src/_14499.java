import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14499 {
	static int[] dice = {0,0,0,0,0,0,0};
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static int N,M,X,Y,K;
	static int[][] map = new int[20][20];

	public static int move(int dir) {
		int nx = X + dx[dir];
		int ny = Y + dy[dir];
		if(nx < 0 || nx >= N || ny < 0 || ny >= M) return 10;
		X = nx;
		Y = ny;
		int temp;
		if(map[X][Y] != 0) {
			if(dir == 1) { 
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
			}else if(dir == 2) {
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
			}else if(dir == 3) {
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
			}else {
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
			}
			dice[6] = map[X][Y]; //바닥면 -> 주사위 복사
			map[X][Y] = 0; //칸에 있는 수 0이 됨
		}else { //바닥면이 0인 경우
			if(dir == 1) { 
				temp = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
			}else if(dir == 2) {
				temp = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
			}else if(dir == 3) {
				temp = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
			}else {
				temp = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
			}
			dice[6] = temp; //바닥면
			map[X][Y] = temp; //바닥면 지도에 복사
		}
		return dice[1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine
					());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int val = move(dir);
			if(val != 10) bw.write(String.valueOf(val) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	} //end of main
} // end of class
