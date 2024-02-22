import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _13023 {
	public static int N, M;
	public static int[] MEMO;
	public static int[] maxVal;
	public static boolean[][] visited;
	public static List<Integer>[] LL;
	public static int DFS(int a) {
		if(MEMO[a] != 0) return MEMO[a];
		int max = 0;
		for(int i = 0; i < LL[a].size(); i++) {
			int next = LL[a].get(i);
			if(!visited[a][next]){
				visited[a][next] = true;
				visited[next][a] = true;				
				max = Math.max(max, DFS(next));
			}
		}
		return max;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		MEMO = new int[N];
		visited = new boolean[N][N];
		for(int i= 0;i < N;i++) {
			LL[i] = new ArrayList<>();
		}
		for(int i = 0; i < M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			LL[a].add(b);
			LL[b].add(a);
		}
		
	}
}
