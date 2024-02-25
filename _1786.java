import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *  j는 0 / i는 1로 시작
 *  가리키는 글자가 다른 경우 0 / i는 1 증가
 *  
 *  가리키는 글자가 같은 글자인 경우 i / j 같이 증가  j의 인덱스 값 table값으로 
 */

public class _1786 {
	public static ArrayList<Integer> list = new ArrayList<>();
	public static int[] makeTable(String pattern) {
		int patternSize = pattern.length();
		int[] arr =new int[patternSize];
		Arrays.fill(arr, 0);
		int j = 0;
		for(int i = 1; i < patternSize;i++) {
			while(j > 0 && pattern.charAt(j)!=pattern.charAt(i)) { //다르면 이전 j를 j의 이전 인덱스의 테이블 값으로
				j = arr[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j)) { // 같은 글자면 i에는 j+1값 삽입 / j + 1
				arr[i] = ++j;
			}
		}
		return arr;
	}
	public static void KMP(String parent, String pattern) {
		int[] table = makeTable(pattern);
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int j = 0;
		for(int i = 0; i < parentSize;i++) {
			while(j > 0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table[j-1];
			}
			if(parent.charAt(i) == pattern.charAt(j)) {
				if(j==patternSize - 1) {
					//System.out.println("founded: " + (i - patternSize + 2));
					j = table[j];
					list.add(i - patternSize + 2);
				}else {
					j++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String parent =br.readLine();
		String pattern = br.readLine();
		KMP(parent, pattern);
		System.out.println(list.size());
		for(int i = 0; i < list.size();i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
		
		
	}
}
