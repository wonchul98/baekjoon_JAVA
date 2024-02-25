

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1456 {
	public static int MAX = 10000001;
	public static long A, B;
	public static boolean[] isPrime = new boolean[MAX];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		for(int i = 2 ; i < MAX;i++) {
			isPrime[i] = true;
		}
		for(int i =2; i * i < MAX ; i++) {
			if(isPrime[i]) {
				for(int j = i * i; j < MAX ; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int count = 0;
		for(int i=2; i <= Math.sqrt(B); i++) {
			for(int square=2; square<=Math.log(B)/Math.log(i); square++) {
				if(isPrime[i]) {
					long num = (long)Math.pow(i,square);
					if(num >= A && num <= B) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
