import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992 {
	public static int[][] map = new int[64][64];
	public static String recur(int row, int col, int size) { 	
		StringBuilder sb = new StringBuilder();
		if(size == 1) return Integer.toString(map[row][col]);
		int nextSize = size/2;
		String one = recur(row, col, nextSize);
		String two = recur(row, col + nextSize, nextSize);
		String three = recur(row + nextSize, col, nextSize);
		String four = recur(row + nextSize, col + nextSize, nextSize);
		if(one.equals("0") && two.equals("0") && three.equals("0") && four.equals("0")){
			return "0";
		}
		else if(one.equals("1") && two.equals("1") && three.equals("1") && four.equals("1")){
			return "1";
		}else {
			sb.append("(").append(one).append(two).append(three).append(four).append(")");
			return sb.toString();
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		System.out.println(recur(0,0,N));
	}
}
