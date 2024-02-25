import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		boolean flag = false; 
		int cnt = 0;
		for(int i = 0;i <= N / 5;i++) {
			if ((N - i*5) % 3 == 0) {
				cnt = i + (N - i*5) / 3;
				flag = true;
			}
		}
		if(flag) System.out.println(cnt);
		else System.out.println(-1);
	}
}
