
import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.IOException;
import java.util.Stack;

public class _6198 {

	public static Stack<Integer> stack = new Stack<>();
	public static long ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			int height = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty()) {
				
				if(stack.peek() <= height) {
					// i번째 빌딩보다 낮거나 같은 빌딩
					stack.pop();
				}
				else break;
			}
			ans += stack.size(); 
			stack.push(height); 
		}
		System.out.println(ans);
	}
}
