

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class _14865 {
	public static int N;
	public static ArrayList<Integer> list2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Pair> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		Pair[] arr= new Pair[N];
		for(int i = 0;i < N;i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			 //시작 좌표의 y좌표가 0보다 작은 경우
			arr[i] = new Pair(a, b);			
		}//end of for
		int idx = 0;
		Pair min = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
		for(int i = 0;i < N;i++) { 
			Pair cur = arr[i];
			if(min.end >= cur.end && min.start >= cur.start) {
				min = cur;
				idx = i;
			}
		}//end of for
		ArrayList<Pair> input = new ArrayList<>();
		for(int i = idx;i < N;i++) {
			input.add(arr[i]);
		}
		for(int i = 0; i < idx;i++) {
			input.add(arr[i]);
		}
		
		int prevB = 0;
		int startPair = 0;

		for(int i = 0;i < N;i++) { 
			int a = input.get(i).start;
			int b = input.get(i).end;
			if(b > 0 && prevB < 0) startPair = a;
			if(b < 0 && prevB > 0) {
				if(a < startPair) {
					list.add(new Pair(a, startPair));
				}else {
					list.add(new Pair(startPair, a));
				}
			}
			prevB = b;
		}

		Collections.sort(list);
		//System.out.println(list.toString());
		int end = list.get(0).end;
		int cnt1 = 1;
		for(int i= 1; i < list.size();i++) {
			if(list.get(i).start > end) {
				end = list.get(i).end; 
				cnt1++;
			}
		}
		
		ArrayList<Pair> pairList = new ArrayList<>();
		idx = 0;
		for(int i = 0;i < list.size();i++) {
			pairList.add(new Pair(list.get(i).start, idx));
			pairList.add(new Pair(list.get(i).end, idx++));
		}
		Collections.sort(pairList);
		int prev = pairList.get(0).end;
		int cnt2 = 0;
		//System.out.println(pairList.toString());
		for(int i = 1; i < pairList.size();i++) {
			int cur = pairList.get(i).end;
			if(prev == cur) cnt2++;
			prev = cur;
		}

		System.out.println(cnt1 + " " + cnt2);
	}
	
	public static class Pair implements Comparable<Pair>{
		int start;
		int end;
		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.start, o.start);
		}
		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
		
		
	}
}
