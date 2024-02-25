import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {
	public static void main(String[] args) throws IOException {
		int N, r, c;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		System.out.println(recur(r,c,N));
		
	}
	public static int recur(int x, int y, int level) {
		int size = (1 << level);
		if(size == 1) return 0;
		int nx =  (x >= size / 2 ? x - size/2 : x);
		int ny =  (y >= size / 2 ? y - size/2 : y);
		int plus =  (x >= size / 2 ? 2 * (size /2 ) * (size / 2) : 0) + (y >= size / 2 ? (size/2) * (size/2) : 0);
		return plus + recur(nx, ny, level-1);
	}
}
