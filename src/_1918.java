import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<>();
		String input = br.readLine();
		for(int i = 0; i < input.length();i++) {
			Character curChar = new Character(input.charAt(i));
			if(curChar >= ('A'- 0) && curChar <= ('Z' - 0)) {
				sb.append(curChar);
			}
			else {
				if(curChar == '+' || curChar == '-') {
					while(!s.isEmpty() && s.peek() != '(') {
						sb.append(s.pop());
					}
					s.add(curChar);
				}else if(curChar == '/' || curChar == '*') {
					while(!s.isEmpty() && (s.peek() == '/' || s.peek() == '*')) {
						sb.append(s.pop());
					}
					s.add(curChar);
				} else if(curChar == '(') {
					s.add(curChar);
				} else {
					while(s.peek()!='(') {
						sb.append(s.pop());
					}
					s.pop();
				}
			}
		}// end of for
		while(!s.isEmpty())sb.append(s.pop());
		System.out.println(sb);
	}
	
}
