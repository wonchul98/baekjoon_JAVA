import java.io.*;
import java.util.*;
public class _1520 {

    static int[][] map;
    static boolean[][] visited;
    static int[][] able;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int M, N, cnt;
    static int DFS(int x, int y){
        if(able[x][y]!=-1) return able[x][y];
        int rst = 0;
        //System.out.println("DFS(" + x  + "," + y + ")");
        if(x==M-1 && y == N-1) {
            able[x][y] = 1;
            return 1;
        }
        int cur = map[x][y];
        for(int i = 0; i < 4;i++){
            int n_x = x + dx[i];
            int n_y = y + dy[i];
            if(n_x< 0 || n_x >= M || n_y < 0 || n_y >= N || visited[n_x][n_y]) continue;
            if(map[n_x][n_y] < map[x][y]){
                visited[n_x][n_y] = true;
                int r_d = DFS(n_x, n_y);
                if(r_d!=-1) {
                    rst += r_d;
                }
                visited[n_x][n_y] = false;
            }

        }
        able[x][y] = rst;
        return rst;
    }
    public static void main(String[] args)throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cnt = 0;
        //System.out.println(M + " " + N);
        map = new int[M][N];
        visited = new boolean[M][N];
        able = new int[M][N];
        for(boolean[] a:visited){
            Arrays.fill(a,false);
        }
        for(int[] a:able){
            Arrays.fill(a,-1);
        }
        for(int i = 0; i < M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //System.out.print(map[i][j]);
            }
            //System.out.print("\n");
        }
        visited[0][0] = true;

        bw.write(String.valueOf(DFS(0,0)));
        bw.flush();
        bw.close();
        br.close();
    }
}
