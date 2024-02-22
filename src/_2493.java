import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493 {
	public static class Pair {
		int x;
		int y;
		Pair(int x, int y){
			this.x = x; // key
			this.y = y; // value
		}
		@Override
		public String toString() {
			return "( " + x + " , " + y + ")";
		}
	}
	public static void main(String[] args) throws IOException {
		Stack<Pair> s = new Stack<>();
		int[] ans = new int[500000];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < N;i++) {
			int target = Integer.parseInt(st.nextToken());
			while(!s.isEmpty() && s.peek().y <= target) s.pop();
			if(s.isEmpty()) ans[i] = 0;
			else ans[i] = s.peek().x + 1;
			s.push(new Pair(i, target));
		}
		for(int i = 0;i < N;i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
}
