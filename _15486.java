import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15486 {
	public static class Pair{
		int cost;
		int value;
		Pair(int cost, int value){
			this.cost = cost;
			this.value = value;
		}
	}
	public static void makeDp() {
		
	}
	public static Pair[] arr = new Pair[1500000]; 
	public static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i <N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		makeDp();
	}
}
