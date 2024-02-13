import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1799 {
	public static int N, ans = 0;
	public static boolean[][] map = new boolean[10][10];
	public static boolean[] plus = new boolean[20];
	public static boolean[] minus = new boolean[20];
	public static List<Pair> list = new ArrayList<>();
	public static List<Pair> list2 = new ArrayList<>();
	public static void recur(int index, boolean get, int cnt) {
		//System.out.printf("recur(%d,%b,%d)\n", index, get, cnt);
		if(index == list.size()) { //마지막 원소
			if(get) ans = Math.max(ans, cnt - 1);
			else ans = Math.max(ans, cnt);
			return;
		}
		int row = list.get(index).x;
		int col = list.get(index).y;
		if(get && (plus[row + col] || minus[row - col + N])) {
			return; //비숍을 놓을 수 없는 경우 리턴
		}
		if(get) { //현재 칸에 놓는 경우
			plus[row + col] = true;
			minus[row - col + N]  = true;
		}
		//다음 칸에 놓는 경우
		recur(index + 1, true, cnt + 1);
		//다음 칸에 안놓은 경우
		recur(index + 1, false, cnt);
		if(get) { // 현재 칸에 놓지 않는 경우
			plus[row + col] = false;
			minus[row - col + N]  = false;			
		}

	} 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N;j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					if((i + j) % 2 == 0)list.add(new Pair(i,j));
					else list2.add(new Pair(i,j));
				}
			}
		}
		recur(0,true,1);
		recur(0,false,0);
		int save = ans;
		ans = 0;
		list = list2;
		recur(0,true,1);
		recur(0,false,0);
		System.out.println(ans + save);
	}
	public static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
