
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class _2615 {
	public static int[][] map = new int[20][20];
	public static boolean[][][] visited = new boolean[20][20][4]; //행 / 열 / 방향
	public static int[] dx = {-1,0,1,1};
	public static int[] dy = {1,1,1,0};
	public static boolean inRange(int x, int y) { //범위 체크
		if(x < 1 || x > 19 || y < 1 || y > 19)return false;
		return true;
	}
	public static boolean go(int x, int y, int dir, int cnt, int color) { //재귀 함수
		//System.out.printf("go(%d,%d,%d,%d,%d)\n", x, y, dir, cnt, color);
		visited[x][y][dir] = true;
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(inRange(nx,ny) && map[nx][ny] == color && !visited[nx][ny][dir]) { // 다음 갈 곳이 범위 안에 있음 -> 색깔 같음 -> 해당 좌표가 해당 방향으로 탐색한 적 없음
			return go(nx,ny,dir,cnt+1, color);
		}
		//위 조선에 안맞는 경우 false를 리턴함
		if(cnt==5) return true;
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("Test5.txt"));
		//여기에 코드를 작성하세요.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1;i<20;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int j = 1;j<20;j++) {
			for (int i = 1; i < 20; i++) {
				for(int k = 0;k<4;k++) {
					if(map[i][j]!=0 && !visited[i][j][k] && go(i,j,k,1, map[i][j])) { //0이 아니고, 방문한 적 없으면 재귀 호출
						//찾은 경우 (승부가 결정된 경우) 실행
						System.out.println(map[i][j]); 
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		//승부가 결정되지 않은 경우
		System.out.println(0);
	}
}


