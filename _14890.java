import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _14890 {
	public static int N, L;
	public static int[][] map = new int[100][100];
	public static void printList(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	public static List<List<Integer>> getList() {
		List<List<Integer>> LL = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			List<Integer> L1 = new ArrayList<>();
			List<Integer> L2 = new ArrayList<>();
			for(int j = 0;j < N;j++) {
				L1.add(map[i][j]);
				L2.add(map[j][i]);
			}
			LL.add(L1);
			LL.add(L2);
		}
		return LL;
	}
	public static boolean isAble(List<Integer> list) {
		//printList(list);
		boolean rst = true;
		int curIdx = 0; 
		int curNum = list.get(curIdx);
		int length = 1;
		while(curIdx < N - 1 && rst) {
			if(list.get(curIdx+1) == curNum) {
				length += 1;
				curIdx += 1;
			} else if(list.get(curIdx+1) == curNum + 1){
				if(length >= L) {
					length = 1;
					curIdx++;
					curNum = list.get(curIdx);
				} else {
					rst = false;
				}
			}else if(list.get(curIdx+1) == curNum - 1) {
				if(curIdx + L > N-1) {
					rst = false;
				} else {
					int movingIdx;
					for(movingIdx = curIdx+1;movingIdx <= curIdx+L;movingIdx++) {
						if(list.get(movingIdx)!=curNum - 1) {
							rst = false;
							break;
						}
					}
					if(!rst) break;
					
					curIdx+=L;
					length = 0;
					if(curIdx <= N - 1) {
						curNum = list.get(curIdx);
					}
				}
			}else {
				rst = false;
			}
		}
		
//		if(rst) {
//			printList(list);
//		}
		return rst;
	}
	public static int solution() {
		int cnt = 0;
		List<List<Integer>> LL = getList();
		for(List<Integer> list : LL) {
			if(isAble(list)) cnt+=1;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solution());
	}
}
