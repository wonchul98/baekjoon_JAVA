import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _15961 {
	public static HashMap<Integer, Integer> map;
	public static int N, d, k, c;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		arr = new int[N + k - 1];
		for (int i = 1; i <= d; i++) {
			map.put(i, 0);
		}
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N + k - 1; i++) {
			arr[i] = arr[i - N];
		}
		//System.out.println(Arrays.toString(arr));
		int cnt = 0;
		int plus = 0;
		for(int i = 0; i < k;i++) {
			if(map.get(arr[i]) == 0) cnt++;
			map.put(arr[i], map.get(arr[i])+1);
		}
		
		if(map.get(c) == 0) plus = 1;
		int maxCnt = cnt + plus;
		//System.out.println("maxCnt: " + maxCnt);
		int s = 0;
		int e = k;
		while(e < N + k - 1) {
			//System.out.println("------------------------");
			//System.out.println("s: " + s + " e: " + e);
			//System.out.println("arr[s]: " + arr[s] + " arr[e]: " + arr[e]);
			plus=0;
			map.put(arr[s], map.get(arr[s]) - 1);
			if(map.get(arr[s]) == 0) cnt--; // 삭제돼서 개수가 0인 경우
			map.put(arr[e], map.get(arr[e]) + 1);
			if(map.get(arr[e]) == 1) cnt++; // 추가돼서 개수가 1인 경우				
			
//			map.forEach((key, value) -> {
//				if(value != 0) System.out.println("key: " + key + " value: " + value);
//			});
			
			if(map.get(c) == 0) plus = 1; //쿠폰 종류가 포함이 안된 경우
			//System.out.println("cnt: " + cnt + " plus: " + plus);
			s++;
			e++;
			maxCnt = Math.max(cnt + plus, maxCnt);
			//System.out.println("cnt + plus: " + (cnt + plus) + " maxCnt: " + maxCnt);
		}
		System.out.println(maxCnt);
	}
}
