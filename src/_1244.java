import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1244 {
	public static int N, K;
	public static List<Integer> arr = new ArrayList<>();
	public static void click(int student, int switchNum) {
		//System.out.printf("click(%d,%d)\n", student, switchNum);
		if(student == 1) { //남자
			int idx = switchNum-1;
			while(idx < N) {
				arr.set(idx, (arr.get(idx)+1)%2);
				idx += switchNum;
			}
		}
		else { //여자
			arr.set(switchNum-1, (arr.get(switchNum-1)+1)%2);
			int left = switchNum-1, right = switchNum-1;
			while(true) {
				left--;
				right++;
				if(left < 0 || right >= N) break;
				if(arr.get(left) == arr.get(right)) {
					arr.set(left, (arr.get(left)+1)%2);
					arr.set(right, (arr.get(right)+1)%2);
				}
				else break;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			int switchNum = Integer.parseInt(st.nextToken());
			click(student, switchNum);
		}
		for (int i = 0; i < N; i++) {
			if(i!=0 && i % 20 == 0) System.out.println();
			System.out.print(arr.get(i));
			if(i != N-1) System.out.print(" ");
		}
	}
}
