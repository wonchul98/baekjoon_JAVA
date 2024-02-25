import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _15686 {
	public static int N, M, minDist = Integer.MAX_VALUE;
	public static int[][] map;
	public static int[] arr;
	public static List<Pair> chickenList = new ArrayList<>();
	public static List<Pair> houseList = new ArrayList<>();
	

	public static int getTownChickenDist(List<Integer> chicken) {
		int rst = 0;
		for(int i = 0; i < houseList.size();i++) {
			int minD = Integer.MAX_VALUE;
			for (int j = 0; j < chicken.size(); j++) {
				int dist = (Math.abs(chickenList.get(chicken.get(j)).x - houseList.get(i).x) + Math.abs(chickenList.get(chicken.get(j)).y - houseList.get(i).y));
				minD = Math.min(minD, dist);
			}
			rst += minD;
		}
		return rst;
	}
	public static void swap(int a, int b) {
		int temp =arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static boolean nextPermutation() {
		int i = arr.length - 1;
		while(i > 0 && arr[i] <= arr[i-1]) i--;
		if(i==0) return false;
		int j = arr.length - 1;
		while(arr[j] <= arr[i-1]) j--;
		swap(i-1, j);
		int k = arr.length - 1;
		while(i < k) {
			swap(i++, k--);
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++ ) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int token = Integer.parseInt(st.nextToken());
				if(token == 1) {
					houseList.add(new Pair(i, j));
				}
				if(token == 2) {
					chickenList.add(new Pair(i, j));
				}

			}
		}
		arr = new int[chickenList.size()];
		for(int i = 0 ; i < chickenList.size() ; i++) {
			if(i < M) arr[i] = 1;
			else arr[i] = 0;
		}
		Arrays.sort(arr);
		do {
			//System.out.println(Arrays.toString(arr));
			int dist = 0;
			List<Integer> chicken = new ArrayList<>();
			for(int i = 0; i < arr.length;i++) 
				if(arr[i] == 1) chicken.add(i);
			minDist = Math.min(getTownChickenDist(chicken), minDist);
		}while(nextPermutation());
		System.out.println(minDist);
	}
	public static class Pair{
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
