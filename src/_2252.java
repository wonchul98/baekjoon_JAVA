import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2252 {
	public static int N, M;
	public static Pair[] pairList;
	public static List<Integer>[] LL;
	public static boolean[] visited;

	public static int getZeroIdx() {
		for (int i = 1; i < pairList.length; i++) {
			if (!visited[i] && pairList[i].s == 0)
				return pairList[i].f;
		}
		return -1; // 아마 -1을 리턴하진 않음
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1]; // false가 default
		LL = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			LL[i] = new ArrayList<>();
		}
		pairList = new Pair[N + 1];
		for (int i = 0; i <= N; i++) {
			pairList[i] = new Pair(i, 0);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			pairList[to].s += 1;
			LL[from].add(to);
		}

		for (int i = 0; i < N; i++) {
			int idx = getZeroIdx();
			visited[idx] = true;
			sb.append(idx).append(" ");
			for (int j = LL[idx].size() - 1; j >= 0; j--) {
				pairList[LL[idx].get(j)].s--;

			}
		}
		System.out.println(sb);
	}

	public static class Pair implements Comparable<Pair> {
		int f; // 학생 인덱스
		int s; // 연결 수

		Pair(int f, int s) {
			this.f = f;
			this.s = s;
		}

		@Override
		public int compareTo(Pair o) {
			return this.s - o.s;// 연결 수 기준 오름차순
		}
	}

}
