package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _20055 {
	public static int N, K, cnt;
	public static ArrayList<Info> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		st = new StringTokenizer(br.readLine());
		arr.add(new Info(false, 0));
		for(int i =0; i < 2 * N;i++) {
			int a = Integer.parseInt(st.nextToken());
			Info put = new Info(false, a);
			arr.add(put);
		}
		int round = 0;
		while(cnt < K) {
			//System.out.println("cnt: " + cnt + " round: " + round);
			round++; 
			rotate();
			walk();
			Rput();
			//printArr();
		}
		System.out.println(round);
	}
	
	public static void rotate() {
		//System.out.println("rotate!!");
		Info temp = arr.get(2*N);
		for(int i = 2*N;i >= 2;i--) {
			arr.set(i, arr.get(i-1));
		}
		arr.set(1, temp);
		arr.get(N).robot = false; // 로봇이 온다면 유기
		//printArr();
	}
	public static void walk() {
		//System.out.println("walk!!");
		arr.get(N).robot = false;
		for(int i = N-1;i >= 1;i--) {
			Info next = arr.get(i+1);
			if(arr.get(i).robot && !next.robot && next.dur>0) {
				//로봇 다음칸으로 이동
				arr.get(i).robot = false; 
				next.robot = true;
				next.dur--;
				if(next.dur == 0) cnt++;
				
			}
		}
		arr.get(N).robot = false; // 로봇이 온다면 유기
		//printArr();
	}
	public static void Rput() {
		//System.out.println("put!!");
		if(arr.get(1).dur > 0) {
			arr.get(1).robot = true;
			arr.get(1).dur--;
			if(arr.get(1).dur==0) cnt++;
		}
		//printArr();
	}
	public static void printArr() {
		for(int i = 1; i <= N;i++) {
			System.out.print(arr.get(i).dur);
		}
		System.out.println();
		for(int i = 2*N; i >= N+1;i--) {
			System.out.print(arr.get(i).dur);
		}
		System.out.println();
		System.out.println("------------------------------");
		for(int i = 1; i <= N;i++) {
			char p = arr.get(i).robot ? 'O' : 'X';
			System.out.print(p);
		}
		System.out.println();
		for(int i = 2*N; i >= N+1;i--) {
			char p = arr.get(i).robot ? 'O' : 'X';
			System.out.print(p);
		}
		System.out.println();
	}
	public static class Info {
		boolean robot;
		int dur;

		public Info(boolean robot, int dur) {
			this.robot = robot;
			this.dur = dur;
		}

		@Override
		public String toString() {
			return "Info [robot=" + robot + ", dur=" + dur + "]";
		}
	}
}
