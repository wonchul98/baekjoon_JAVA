import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865 {
	public static class Pair{
		int w,v;
		Pair(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
	public static Pair[] obj = new Pair[101];
	public static int[][] dp = new int[101][100001]; // 인덱스 / 무게
	public static int N, K;
	public static void makeDp() {
		for(int idx = 0;idx <= N ; idx++) {
			for(int w = 0; w <= K ; w++) {
				if(idx == 0 || w == 0 ) {
					dp[idx][w] = 0;
					continue;
				}
				int wi = obj[idx].w;
				int vi = obj[idx].v;
				if(w < wi) dp[idx][w] = dp[idx-1][w];
				else {
					dp[idx][w] = Math.max(dp[idx-1][w-wi] + vi, dp[idx-1][w]);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int w, v;
		for(int i = 1;i <= N;i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			obj[i] = new Pair(w,v);
		}
		makeDp();
		System.out.println(dp[N][K]);
	}
}
