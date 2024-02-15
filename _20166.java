import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20166 {
	public static int N, M, K;
	public static char[][] map = new char[10][10];
	public static int find(String input) {
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i= 0; i < N;i++) {
			String input = br.readLine();
			for(int j =0; j < N;j++) {
				map[i][j] = input.charAt(j);
			}
		}
		for(int i = 0 ; i < K;i++) {
			String input = br.readLine();
			find(input);
		}
	}
}
