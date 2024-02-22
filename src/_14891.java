import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _14891 {
	public static int[][] saw = new int[5][8];
	public static List<Boolean> visited = new ArrayList<>();

	public static void move(int sawNum, int dir) {
		if (visited.get(sawNum))
			return;
		// System.out.printf("move(%d,%d)\n", sawNum, dir);
		int[] newArr = new int[8];
		for (int i = 0; i < 8; i++) {
			newArr[i] = saw[sawNum][(i - dir + 8) % 8];
		}

		visited.set(sawNum, true);
		int leftSawNum = sawNum - 1;
		int rightSawNum = sawNum + 1;
		if (leftSawNum >= 1 && saw[sawNum][6] != saw[leftSawNum][2]) {
			move(leftSawNum, dir * (-1));
		}

		if (rightSawNum <= 4 && saw[sawNum][2] != saw[rightSawNum][6]) {
			move(rightSawNum, dir * (-1));
		}

		saw[sawNum] = newArr; // 얕은 복사

	}

	public static int getNum() {
		int cnt = 0;
		int weight = 1;
		for (int i = 1; i <= 4; i++) {
			cnt += saw[i][0] * (weight);
			weight *= 2;
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 4; i++) {
			String input = br.readLine();
			for (int j = 0; j < 8; j++) {
				saw[i][j] = input.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sawNum = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			visited = Arrays.asList(false, false, false, false, false);
			move(sawNum, dir);
		}

		System.out.println(getNum());

	}
}
