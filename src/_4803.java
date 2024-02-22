import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _4803 {
	public static int[] p;
	public static boolean[] deleteList;

	public static void Union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == -1 && rootB == -1) return;
		if(rootA == -1) {
			p[rootB] = -1;
			return;
		}
		else if(rootB == -1) {
			p[rootA] = -1;
			return;
		}
		if(rootA == rootB){
			p[rootA] = -1;
			return;
		}
		p[rootA] = rootB;
	}
	public static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	public static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); //노드 수 
			M = Integer.parseInt(st.nextToken()); //간선 수
			if(N == 0) break;
			p = new int[N+1];
			Arrays.setAll(p, x->x);
			
			for(int i = 0; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				Union(a, b);
			}
			int cnt = 0;
			for(int i= 1; i <= N;i++) {
				if(p[i]==i) cnt++;
			}
			if(cnt == 1) sb.append("Case ").append(test_case++).append(":").append(" There is one tree.").append("\n");
			else if(cnt == 0) sb.append("Case ").append(test_case++).append(":").append(" No trees.").append("\n");
			else sb.append("Case ").append(test_case++).append(":").append(" A forest of ").append(cnt).append(" trees.").append("\n");
		}
		System.out.println(sb);
	}
}
