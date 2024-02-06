import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11401 {
	public static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int j = 1000000007;
		Long temp = 1L;
		Long up;
		for(int i = 0; i < K;i++) {
			temp *= (N - i);
			temp % = j;
		}
		up = temp;
		temp = 1L;
		for(int i = 0; i < K;i++) {
			temp *= i;
		}
	}
}
