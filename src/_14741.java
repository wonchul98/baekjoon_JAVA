
import java.util.ArrayList;
import java.util.Scanner;

public class _14741 {
    static int N;
    static int[] c_amount = new int[11];
    static int[] city_elec = new int[11];
    static ArrayList<Integer>[] con_city = new ArrayList[11];
    static boolean[] visited = new boolean[11];
    static boolean print = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int min_citizen = 987654321;

        for (int i = 1; i <= N; i++) {
            c_amount[i] = scanner.nextInt();
            con_city[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int con = scanner.nextInt();
            for (int j = 0; j < con; j++) {
                int input = scanner.nextInt();
                con_city[i].add(input);
            }
        }

        boolean can_make = false;
        for (int i = 1; i <= (1 << N) - 2; i++) {
            for (int j = 1; j <= N; j++) visited[j] = false;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    city_elec[j + 1] = 1;
                } else {
                    city_elec[j + 1] = 0;
                }
            }

            boolean z_check = false;
            boolean o_check = false;
            int z_sum = 0;
            int o_sum = 0;
            for (int j = 1; j <= N; j++) {
                if (z_check && o_check) break;
                if (city_elec[j] == 0 && !z_check) {
                    z_check = true;
                    z_sum = dfs(j, 0);
                }
                if (city_elec[j] == 1 && !o_check) {
                    o_check = true;
                    o_sum = dfs(j, 1);
                }
            }

            boolean flag = true;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                can_make = true;
                min_citizen = Math.min(min_citizen, Math.abs(o_sum - z_sum));
            }
        }

        if (can_make) System.out.println(min_citizen);
        else System.out.println("-1");

        scanner.close();
    }

    public static int dfs(int city, int elec) {
        visited[city] = true;
        int rst = c_amount[city];
        for (int i = 0; i < con_city[city].size(); i++) {
            int next_city = con_city[city].get(i);
            if (city_elec[next_city] == elec && !visited[next_city]) {
                rst += dfs(next_city, elec);
            }
        }
        return rst;
    }
}