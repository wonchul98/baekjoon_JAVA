import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;

public class _14888 {
	public static int N;
	public static int[] A = new int[11];
	public static int[] op = new int[4]; // + - * /
	public static void calc() {};
	public static boolean nextPermutation(List<Character> L){
		while

	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < 4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
	}
}
