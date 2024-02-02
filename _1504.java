import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1504 {
	public static int N,E;
	public static int[][] dist = new int[801][801];
	public static boolean[][] visited = new boolean[801][801];
	public static int magicNumber = Integer.MAX_VALUE;
	public static void init() {
		for(int i = 1; i <= N;i++) {
			for(int j = 1;j <= N;j++) {
				if(i==j) dist[i][j] = 0;
				else {
					dist[i][j] = magicNumber ;
				}
			}
		}
	}
	public static int getSmallIndex(int a) {
		//System.out.println("getsmallindex: " + a);
		int index = 0;
		int min = magicNumber;
		for(int i = 1;i <=N;i++) {
			//System.out.printf("visited[%d][%d] : %b\n", a, i, visited[a][i]);
			//System.out.printf("dist[%d][%d] : %d\n", a, i, dist[a][i]);
			if(a != i && !visited[a][i] && dist[a][i] < min) { //방문 안한 노드 중 연결이 되어있는 경우
				index = i;
				min = dist[a][i];
			}
		}
		if (index != 0) {
			visited[a][index] = true;
			return index;
		}
		return N+1;
	}
	public static void dijkstra(int a) {
		//System.out.println("dist: " + a);
		int cnt = N;
		int nextNode = 0;
		while(cnt-- > 0) {
			nextNode = getSmallIndex(a); // 연결이 안된 인덱스는 안나옴
			if(nextNode == N+1) continue;
			//System.out.println("nextNode: " + nextNode);
			for(int i = 1; i <= N;i++) {
				if(dist[nextNode][i] < magicNumber) {
					dist[a][i] = Math.min(dist[a][nextNode] + dist[nextNode][i], dist[a][i]);
					dist[i][a] = Math.min(dist[a][nextNode] + dist[nextNode][i], dist[a][i]);
				}
				//System.out.println(dist[a][i]);
			}			
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		init();
		for(int i = 1;i <= E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			dist[first][second] = d;
			dist[second][first] = d;
		}
		st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		dijkstra(1);
		dijkstra(A);
		dijkstra(B);
		int aCourse, bCourse;
		if(dist[1][A] == magicNumber|| dist[A][B] == magicNumber || dist[B][N] == magicNumber) aCourse = magicNumber; 
		else aCourse = dist[1][A] + dist[A][B] +  dist[B][N];
		if(dist[1][B] == magicNumber|| dist[B][A] == magicNumber || dist[A][N] == magicNumber) bCourse = magicNumber; 
		else bCourse  = dist[1][B]+dist[B][A]+dist[A][N];
		if(aCourse == magicNumber && bCourse == magicNumber) System.out.println(-1);
		else {
			System.out.println(Math.min(aCourse, bCourse));
		}
		
	}
}
