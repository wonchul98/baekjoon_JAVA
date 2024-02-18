import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _20166 {
    static int N,M,K;
    static char [][] map;
    static Map<String,Integer> hm;
    static int [] dx = {-1,-1,0,1,1,1,0,-1}; // 상부터 시계방향
    static int [] dy = {0,1,1,1,0,-1,-1,-1};
    static int maxLen = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        hm = new HashMap<>();

        for(int i = 0; i < N; ++i)
        {
            String input = br.readLine();
            for(int j = 0; j < M; ++j)
            {
                map[i][j] = input.charAt(j);
            }
        }

        String [] keys = new String[K];
        for(int i = 0; i < K; ++i)
        {
            // 좋아하는 문자열 해시맵에 0카운트로 put
            String input = br.readLine();
            //정답 출력을 위해 담아두기
            keys[i] = input;
            maxLen = Math.max(maxLen,input.length());
            hm.put(input,0);
        }

        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                makeString(i,j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : keys)
        {
            sb.append(hm.get(s)).append("\n");
        }
        System.out.print(sb);
    }
    static void makeString(int x, int y)
    {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y,1,map[x][y]+""));

        while(!q.isEmpty())
        {
            Point cur = q.poll();

            //주어진 문자열 중 최대길이보다 길면 탐색중지
            if(cur.len > maxLen) continue;
            //일치하면 카운트 ++
            if(hm.containsKey(cur.str))
            {
                hm.put(cur.str,hm.get(cur.str)+1);
            }

            for(int idx = 0; idx < 8; ++idx)
            {
                int mx = (cur.x + dx[idx]) % N;
                int my = (cur.y + dy[idx]) % M;

                if(mx < 0) mx += N;
                if(my < 0) my += M;

                q.add(new Point(mx,my,cur.len+1,cur.str+map[mx][my]));
            }
        }
    }
    public static class Point
    {
    	int x,y,len;
    	String str;
    	
    	public Point(int x, int y, int len, String str) {
    		this.x = x;
    		this.y = y;
    		this.len = len;
    		this.str = str;
    	}
    }

}
