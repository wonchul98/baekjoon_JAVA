package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class _2800 {
	static List<Pair> brackets;
	static Set<String> result;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String line = br.readLine();
	    brackets = new ArrayList<>();
	    Stack<Integer> s = new Stack<>();
	    for(int i = 0; i < line.length(); i++) {
	        char c = line.charAt(i);
	        if(c == '(') {
	            s.push(i);
	        } else if(c == ')'){
	            brackets.add(new Pair(s.pop(), i));
	        }
	    }
	    check = new boolean[line.length()];
	    result = new TreeSet<>();
	    comb(0, line.toCharArray());

	    // 결과 출력
	    for(String res : result) {
	        System.out.println(res);
	    }
	}

	private static void comb(int depth, char[] str) {
		if(depth == brackets.size()) { // 종료 조건
			boolean flag = false; // 괄호가 하나도 안빠짐
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i <str.length;i++) {
				if(!check[i]) {
					sb.append(str[i]);
				}else flag = true; // 괄호가 하나라도 빠짐
			}
			if(flag) {
				result.add(sb.toString());
			}
			return;			
		}
		comb(depth+1, str); // 체크 안하고 (괄호 유지) 재귀
		
		Pair bracket = brackets.get(depth);
		check[bracket.x] = true;
		check[bracket.y] = true;
		comb(depth+1, str); // 체크 하고 (괄호 제거) 재귀
		check[bracket.x] = false;
		check[bracket.y] = false;
	}
	public static class Pair {
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
