import java.io.*;
import java.util.*;
public class _7579 {
    public static final int INF = 987654321;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]m = new int[N+1];
        int[]c = new int[N+1];
        int max_c = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N;i++){
            m[i] = Integer.parseInt(st.nextToken());

        }
        //System.out.println("max_m: " + max_m);
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N;i++){
            c[i] = Integer.parseInt(st.nextToken());
            max_c += c[i];
        }
        int[][]dp = new int[N+1][max_c+1];
        int min_j = INF;
        for(int[] a:dp){
            Arrays.fill(a,0);
        }

        for(int i = 1;i<=N;i++){
            //System.out.println("i: " + i);
            boolean flag = false;
            int cur_m = m[i];
            int cur_cost = c[i];
            for(int j = 0; j <= max_c; j++){
                if(j - c[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j-c[i]] + m[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] >= M) {
                    min_j = Math.min(j, min_j);
                }
            }

        }
        bw.write(String.valueOf(min_j));
        bw.flush();
        bw.close();
        br.close();
    }
}
