package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] ability = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] arr = new int[N];
        for(int i = 0; i < N/2; i++) {
            arr[i] = 0;
        }
        for(int i = N/2; i < N; i++) {
            arr[i] = 1;
        }

        int minDiff = Integer.MAX_VALUE;
        do {
            int startTeam = 0, linkTeam = 0;
            for(int i = 0; i < N - 1; i++) {
                for(int j = i + 1; j < N; j++) {
                    if(arr[i] == 0 && arr[j] == 0) { // 1팀
                        startTeam += (ability[i][j] + ability[j][i]);
                    } else if(arr[i] == 1 && arr[j] == 1) { // 2팀
                        linkTeam += (ability[i][j] + ability[j][i]);
                    }
                }
            }
            int diff = Math.abs(startTeam - linkTeam);
            minDiff = Math.min(minDiff, diff);
        } while(nextPermutation(arr));

        System.out.println(minDiff);
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean nextPermutation(int[] a) {
        int i = a.length-1;
        while(i > 0 && a[i] <= a[i-1]) i--;
        if(i<=0) return false;
        int j = a.length-1;
        while(a[j] <= a[i-1]) j--;
        swap(a, j, i-1);
        int k = a.length-1;
        while(i < k) swap(a, i++, k--);
        return true;
    }
}
