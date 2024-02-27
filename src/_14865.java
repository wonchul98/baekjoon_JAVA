

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
	public static void MakeList(ArrayList<Pair> list) {
		list2 = new ArrayList<>();
		Stack<Pair> s = new Stack<>();
		for(int i= 0; i < list.size();i++) {
			Pair cur = list.get(i);
			if(s.isEmpty()) {
				list2.add(cur.start);
				s.add(new Pair(cur.end, i));
			}
			else {
				if(cur.start < s.peek().start) {
					list2.add(cur.start);
					s.add(new Pair(cur.end, i));
				}
				else {
					list2.add(s.pop().end);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Pair> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());

		int prevB = 0;
		int startPair = 0;
		int saveA1 = 0;
		int saveA2 = 0;
		boolean mode1 = false;
		boolean saved = false;
		for(int i = 0;i < N;i++) { // 맨 처음 원소가 x좌표 아래에서 시작한다고 가정...
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(i == 0 && b > 0) {
				mode1 = true;
				saveA2 = a;
			}
			if(mode1) { // 시작 좌표의 y좌표가 0보다 큰 경우
				if(b > 0 && prevB < 0) { // down -> up
					startPair = a;
				}
				if(b < 0 && prevB > 0) { // up -> down
					if(!saved) {
						saved = true;
						saveA1 = a;
				
						prevB = b;
						continue;
					}
					if(a < startPair) {
						list.add(new Pair(a, startPair));
					}else {
						list.add(new Pair(startPair, a));
					}
				}
				prevB = b;				
			} else { //시작 좌표의 y좌표가 0보다 작은 경우
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
			
		}//end of for
		if(mode1) list.add(new Pair(saveA2, saveA1));
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
		int idx = 0;
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
