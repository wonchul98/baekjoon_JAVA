import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2230 {
	public static int N, M;
	public static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int s = 0;
		int e = 1;
		int min = Integer.MAX_VALUE;
		while(s <= e && e < N) {
			//System.out.println("s: " + s + " e: " + e);
			if(arr[e] - arr[s] < M) {
				e++;
			}
			else if (arr[e] - arr[s] > M){
				min = Math.min(min, arr[e] - arr[s]);
				s++;
			}
			else { // arr[e] - arr[s] == M
				System.out.println(M);
				return;
			}
		}
		System.out.println(min);
	}
}
