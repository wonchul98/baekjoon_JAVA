import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



public class _2660 {	
	public static int[][] map;
	public static boolean[][] visited;
	public static int N;
	public static List<Pair> ans = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		List<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0; i <= N;i++) list.add(new ArrayList<Integer>());
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			if(to == -1) break;
			list.get(from).add(to);
			list.get(to).add(from);
		}
		//System.out.println(list.toString());
		for(int i = 1;i <= N;i++) {
			int level = 0;
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			q.add(-1);
			while(!q.isEmpty()) {
				int cur = q.poll();
				//System.out.println("cur: " + cur);
				if(cur == -1) {
					level++;
					if(q.isEmpty()) break;
					q.add(-1);
					continue;
				}
				for(int j = 0 ; j < list.get(cur).size();j++) {
					int next = list.get(cur).get(j);
					//System.out.println("next: " + next);
					if(next == i) continue;
					if(!visited[i][next]) {
						q.add(next);
						visited[i][next] = true;
					}
				}
			}
			ans.add(new Pair(i, level - 1));
		}
		Collections.sort(ans);
		//System.out.println(ans.toString());
		int ansLevel = ans.get(0).y;
		int num = 0;
		for(int i = 0; i < N;i++) {
			if(ans.get(i).y == ansLevel) num += 1;
			else break;
		}
		System.out.println(ansLevel + " "+ num);
		for(int i = 0; i < num;i++) System.out.print(ans.get(i).x + " ");
	}
	public static class Pair implements Comparable<Pair>{
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}


		@Override
		public int compareTo(Pair o) {
			if(this.y == o.y) return this.x - o.x;
			return this.y - o.y;
		}


		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
		
	}
}
