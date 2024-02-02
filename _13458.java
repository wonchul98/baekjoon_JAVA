import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class _13458 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long ans = 0L;
		int[] A = new int[1000000];
		for(int i = 0;i < N;i++) {
			A[i] = Integer.parseInt(st.nextToken());		
		}
		int B, C;
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		for(int i = 0;i < N;i++) {
			if(A[i] <= B) {
				ans+=1;
				continue;
			}
			int r = (A[i] - B) / C;
			int q = (A[i] - B) % C;
			if(q==0) {
				ans = ans + r + 1;
			} else {
				ans = ans + r + 2;
			}
		}
		System.out.println(ans);
	}
}
