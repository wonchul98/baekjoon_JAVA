import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class _14502 {
	static class Pair {
		private int first;
		private int second;
		Pair(int first, int second){
			this.first = first;
			this.second = second;
		}
	}
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static List<Pair> twos = new ArrayList<Pair>();
	public static List<Pair> zeros = new ArrayList<Pair>();
	public static int N,M;
	public static int map[][] = new int[8][8];
	public static boolean[][] visited = new boolean[8][8]; 
	public static int maxNum = 0;
	public static List<Integer> forPer = new ArrayList<>();
	public static int virusCnt = 0;

	static void dfs(int x, int y) {
		if(visited[x][y]) return;
		//System.out.printf("DFS(%d,%d)\n", x, y);
	    visited[x][y] = true;
	    virusCnt += 1;
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        if(nx <0 || nx >= N || ny <0||ny>=M||visited[nx][ny]||map[nx][ny]==1) continue;
	        dfs(nx, ny); 	        
	    }
	}
	public static Pair[] get3loc() {
		int cnt = 0, idx = 0;
		Pair[] retPair = new Pair[3];
		while(cnt < 3) {
			if(forPer.get(idx)==1) {
				//System.out.println("idx: " + idx);
				retPair[cnt++] =new Pair(zeros.get(idx).first, zeros.get(idx).second);
				
			}
			idx++;
		}
		return retPair;
	}
	public static boolean nextPermutation() {
		int i = forPer.size() - 1;
		while(i > 0 && forPer.get(i-1) >= forPer.get(i)) 
			i--;
		if(i == 0) return false;
		int j = forPer.size()-1;
		while(forPer.get(i-1) >= forPer.get(j)) //오른쪽 시작 i-1 보다 처음으로 큰 j
			j--;
		Collections.swap(forPer, i-1, j); //i-1과 j 스왑
		int k = forPer.size()-1;
		while(i < k) { // i 부터 끝까지 reverse
			Collections.swap(forPer, i, k);
			i++;
			k--;
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) twos.add(new Pair(i,j));
				else if(map[i][j] == 0) zeros.add(new Pair(i,j));
			}
		}
		for (int i = 0; i < zeros.size()-3; i++) {
		    forPer.add(0);
		}
		for (int i = 0; i < 3; i++) {
		    forPer.add(1);
		}
		
		do {
			Pair[] zeroPairs = get3loc();
			for(int i = 0;i < 3;i++) {
				map[zeroPairs[i].first][zeroPairs[i].second] = 1;
			}
			for (int i = 0; i < N; i++) {
			    Arrays.fill(visited[i], false);
			}
			//DFS 
			for (Pair virus : twos) {
			    dfs(virus.first, virus.second);
			}
			//maxNum 최신화 
			maxNum = Math.max(maxNum, zeros.size() + twos.size() - 3 - virusCnt );
			//visited 배열 / virusCnt 초기화
			
			virusCnt =0;
			for(int i = 0;i < 3;i++) {
				map[zeroPairs[i].first][zeroPairs[i].second] = 0;
			}
		}while(nextPermutation()); //다음 1로 만들 0 좌표 3개 선정
		System.out.println(maxNum);
	}
}
