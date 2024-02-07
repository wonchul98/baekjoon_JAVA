import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _2457 {
	public static int N;
	public static INFO[] list;
	public static int[] finalDay = {31,31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new INFO[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			list[i] = new INFO(startMonth, startDay, endMonth, endDay);
		}
		Arrays.sort(list);
		int flag = list[0].endMonth;
		List<INFO> newL = new ArrayList<>();
		int idx = 1;
		do {
			if(list[idx].startMonth <= flag) {
				newL.add(list[idx]);
				idx++;
				Collections.sort(newL, new Comparator<INFO>() {
					@Override
					public int compare(INFO o1, INFO o2) {
							return o2.endMonth - o1.endMonth; // 내림차순
					}
				});
			}
		} while(!newL.isEmpty());
		
	}
	public static class INFO implements Comparable<INFO>{
		int startMonth;
		int startDay;
		int endMonth;
		int endDay;
		public INFO(int startMonth, int startDay, int endMonth, int endDay) {
			if(endDay == 1) {
				if(endMonth == 1) endMonth = 12;
				else endMonth-=1;
				endDay = finalDay[endMonth];
			}
			endDay -= 1;
			this.startMonth = startMonth;
			this.startDay = startDay;
			this.endMonth = endMonth;
			this.endDay = endDay;
		}
		@Override
		public int compareTo(INFO o) {
			if(this.startMonth == o.startMonth) {
				if(this.endMonth == o.endMonth) return o.endDay - this.endDay;
				return o.endMonth - this.endMonth;
			}
			return this.startMonth - o.startMonth;
		}
		@Override
		public String toString() {
			return "INFO [startMonth=" + startMonth + ", startDay=" + startDay + ", endMonth=" + endMonth + ", endDay="
					+ endDay + "]";
		}
		
	}
}
