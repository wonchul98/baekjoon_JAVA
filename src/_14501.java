import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501 {
	public static int N, maxNum = 0;
	public static int[] T = new int[16];
	public static int[] P = new int[16];
	public static boolean forDebug = false;
	public static boolean[][] visited = new boolean[16][2];
	public static int[][] Memo = new int[16][2];

	public static int recur(int idx, boolean work) {
		if(idx > N) return 0;
		if(forDebug) System.out.printf("recur(%d,%b)\n", idx, work);
		if(visited[idx][work?1:0]) return Memo[idx][work?1:0];
		int num = 0;
		
		if(work) {
			num += P[idx];
			if(idx+ T[idx] > N + 1) {
				return 0;
			}
			int num1 = num + recur(idx + T[idx], true);
			int num2 = num + recur(idx + T[idx], false);
			if(forDebug) System.out.println("num1: " + num1 + " num2: " + num2);
			num = Math.max(num1, num2);
			if(forDebug) System.out.println("num: " +  num);
		} else {
			int num1 = recur(idx + 1, true);
			int num2 = recur(idx + 1, false);
			if(forDebug) System.out.println("num1: " + num1 + " num2: " + num2);
			num += Math.max(num1, num2);
			if(forDebug) System.out.println("num: " +  num);
		}
		visited[idx][work?1:0] = true;
		Memo[idx][work?1:0] = num;
		return num;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 1;i <= N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());			
		}
		maxNum = Math.max(recur(1,true), recur(1,false));
		System.out.println(maxNum);
	}
}
