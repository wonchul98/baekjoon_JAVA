import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1330 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(n>k) System.out.println(">");
        else if(n == k) System.out.println("==");
        else System.out.println("<");
    }
}
