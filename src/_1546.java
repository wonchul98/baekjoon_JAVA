
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _1546 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        //System.out.println(n);
        float hap = 0;
        int maximum = 0;
        for(int i = 0; i < n;i++){

            int cur = Integer.parseInt(st.nextToken());
            //System.out.println(cur);
            maximum = Math.max(maximum, cur);
            hap += cur;
        }
        hap = hap / n;
        System.out.println(hap/maximum*100);
    }
}
