import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5373 {
	public static void move(char side, char dir) {
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1;test_case <= T;test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i <N;i++) {
				String command = st.nextToken();
				move(command.charAt(0), command.charAt(1));
			}
		}
	}
}
