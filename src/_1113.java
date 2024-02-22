import java.io.*;
import java.util.*;
import java.lang.NullPointerException;
public class _1113 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N, M;
    static int[][] map, calc;
    static boolean[][] visited;
    static void DFS(int x, int y, int w){
        //System.out.println("DFS(" + x + "," + y + "," + w + ")");
        visited[x][y] = true;
        if(calc[x][y] ==-1) calc[x][y] = w - map[x][y];
        for(int i = 0 ; i < 4;i++){
            int n_x = x + dx[i];
            int n_y = y + dy[i];
            if(n_x < 0 || n_x > N+1 || n_y < 0 || n_y > M+1 || visited[n_x][n_y] || map[n_x][n_y] > w) continue;
            DFS(n_x, n_y, w);
        }
    }
    public static void main(String[] args)throws Exception, NullPointerException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        calc = new int[N+2][M+2];

        for(int i = 0; i < N+2; i++) {
            Arrays.fill(map[i], 1);
            Arrays.fill(calc[i], -1);
        }

        for(int i = 1; i <= N;i++){
            String line = br.readLine();
            for(int j = 1;j <= M;j++){
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        for(int i = 1; i <=9;i++){
            visited = new boolean[N+2][M+2];
            DFS(0,0,i);
        }
        int cnt = 0;
        for(int i = 1; i <= N;i++){
            for(int j = 1;j <= M;j++){
                //System.out.print(calc[i][j] +" ");
                cnt += calc[i][j];
            }
            //System.out.print("\n");
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
