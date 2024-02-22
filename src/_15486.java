import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15486 {
    static int N; 
    static int[] T, P; 
    static int[] dp; 

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        T = new int[N + 2]; //time
        P = new int[N + 2]; // pay
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        // i일에 일을하는 경우 vs 넘기는 경우
        for (int i = N; i > 0; i--) {
            int nextDay = i + T[i]; 
            if (nextDay <= N + 1) {
                dp[i] = Math.max(P[i] + dp[nextDay], dp[i + 1]); 
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}
