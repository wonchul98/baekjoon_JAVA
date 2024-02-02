import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1019 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ans = new int[10];
        int N = Integer.parseInt(br.readLine());
        long div = 1; // div 타입 long

        while (div <= N) { // div가 N을 초과하면 반복을 중단
            div *= 10;
            int remainder = (int) (N / div); // 형변환 
            int quotient = (int) (N % div); // 형변환

            for (int i = 0; i < 10; i++) {
                ans[i] += remainder * (div / 10);
            }

            int q1 = quotient / (int) (div / 10); // 형변환
            int q2 = quotient % (int) (div / 10); // 형변환 

            for (int i = 0; i < q1; i++) {
                ans[i] += (div / 10);
            }

            ans[q1] += (q2 + 1);
            ans[0] -= div / 10;
        }

        for (int i = 0; i < 9; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.print(ans[9]);
    }//end of main
}//end of class
