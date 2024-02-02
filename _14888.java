import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _14888 {
	public static int N;
	public static int[] A = new int[11];
	public static int[] op = new int[4]; // + - * /
	public static List<Integer> L = new ArrayList<>();
	public static int calc() {
		int idx = 0, num = A[0];
		while(idx <= L.size()-1) {
			switch(L.get(idx++)) {
			case 0: {
				num += A[idx];
				break;
			}
			case 1 :{
				num-=A[idx];
				break;
			}
			case 2 : {
				num*=A[idx];
				break;
			}
			case 3 : {
				if(num >= 0) {
					num /= A[idx];
					break;
				} else {
					num *= -1;
					num /= A[idx];
					num *= -1;
					break;
				}
				
			}
			}
		}
		return num;
	}
	public static boolean nextPermutation(){
		//System.out.println(L.toString());
		int i = L.size() - 1;
		while (i > 0 && L.get(i - 1) >= L.get(i))
            --i;
		if(i==0) return false;
		int j = L.size()-1;
		while(L.get(j) <= L.get(i-1)) 
			--j;
		Collections.swap(L, i-1, j);
		int idx = L.size()-1;
		while(i < idx) {
			Collections.swap(L, i, idx);
			i++;
			idx--;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < 4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
			
		}
		for(int i = 0;i < 4; i++) {
			for(int j = 0; j < op[i];j++) {
				L.add(i);
			}			
		}
		int maxAns = 0;
		int minAns = Integer.MAX_VALUE;
		do {
			maxAns = Math.max(maxAns,  calc());
			minAns = Math.min(minAns,  calc());
		}while(nextPermutation());
		System.out.println(maxAns);
		System.out.println(minAns);
	}
}
