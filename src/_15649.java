
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15649 {
	public static int N,M;
	public static List<Integer> list = new ArrayList<>();
	public static boolean visited[] = new boolean[9];
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void printList() throws IOException{
		for(int i = 0;i < M;i++) {
			bw.write("" + list.get(i));
			if(i!=M-1)bw.write(" ");
			else bw.write("\n");
		}
	}
	public static void recur(int a) throws IOException {
		//System.out.println("recur : " + a);
		
		visited[a] = true;
		list.add(a);
		//System.out.println(list);
		if(list.size() == M) {
			printList();
			list.remove(list.size()-1);
			visited[a] = false;
			return;
		}
		for(int i = 1;i<=N;i++) {
			if(!visited[i]) {
				recur(i);
			}
		}
		list.remove(list.size()-1);
		visited[a] = false;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N; i++) recur(i);
		bw.flush();
	}
}