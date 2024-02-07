import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865_2 {
	public static class Pair{
		public int W;
		public int V;
		public Pair(int w, int v) {
			W = w;
			V = v;
		}
		
	}
	public static int N, K;
	public static Pair[] arr = new Pair[102];	
	public static int[][] dp = new int[102][100001];	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N;i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(W,V);
		}
		for(int i =1; i <= N;i++) {
			for(int j = 0; j <= K;j++) {
				if(j - arr[i].W < 0) dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i].W] + arr[i].V);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
