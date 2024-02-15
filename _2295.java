import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _2295 {
	public static int N;
	public static int[] arr;
	public static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i = 0; i < N;i++) {
			for(int j = i ; j < N;j++) {
				int sum = arr[i] + arr[j];
				if(sum > arr[arr.length - 1]) continue;
				list.add(sum);
			}
		}
		Collections.sort(list);
		//System.out.println(Arrays.toString(arr));
		//System.out.println(list.toString());
		
		for(int i = N-1;i >= 0;i--) { //arr의 뒤에서 부터 탐색
			for(int j = 0;j < list.size();j++) {
				int minus = arr[i] - list.get(j);
				if(minus < 0) continue; // 가지치기
				int rst = Arrays.binarySearch(arr,minus);
				if(rst >= 0) {
					System.out.println(arr[i]);
					return;
				}
			}
		}
		
	}
}
