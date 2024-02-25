import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2457_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		INFO[] list = new INFO[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			list[i] = new INFO(sm, sd, em, ed);
		}
		Arrays.sort(list);
		int idx = 0;
		int Covered = 301; //이 날짜 전까지는 다 꽃이 있다. 
		boolean updated = false;
		boolean isAble = false;
		int maxCover = 0;
		int cnt = 0;
		for(int i =0; i < N;i++) {
			updated = false;
			if(Covered > 1130) break;
			while(idx < N && list[idx].start <= Covered) {
				if(maxCover < list[idx].end) {
					maxCover = list[idx].end;
					isAble = true;
					updated = true;
				}
				idx++;
			}
			if(updated) {
				Covered = maxCover;
				cnt++;
			}else {
				break;
			}
		}
		if(Covered <= 1130) isAble = false;
		System.out.println(isAble ? cnt : 0);
	}
	public static class INFO implements Comparable<INFO>{
		int start;
		int end;
		INFO(int sm, int sd, int em, int ed){
			this.start = sm * 100 + sd;
			this.end = em * 100 + ed;
		}
		@Override
		public int compareTo(INFO o){
			if(this.start == o.start) return this.end - o.end;
			return this.start - o.start;
		}
	}
}
