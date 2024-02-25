import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _11729 {
	public static int cnt = 0;
	public static StringBuilder sb = new StringBuilder();
	public static void hanoi(int size, int from, int mid, int to) {
		if(size==1) {
			cnt++;
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		hanoi(size-1, from, to, mid);
		sb.append(from).append(" ").append(to).append("\n");
		cnt++;
		hanoi(size-1, mid, from, to);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}
}
