import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class _1759 {
	public static int L, C;
	public static char[] arr;
	public static int[] vowels, consonants;
	public static List<String> l = new ArrayList<>();
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static boolean nextPermutation(int[] arr) {
		int i = arr.length - 1;
		while(i > 0 && arr[i] <= arr[i-1]) i--;
		if(i == 0) return false;
		int j = arr.length - 1;
		while(arr[j] <= arr[i-1]) j--;
		swap(arr, i-1, j);
		int k = arr.length - 1;
		while(i < k) {
			swap(arr, i++, k--);
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		StringBuilder sb;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		int vowCnt = 0, conCnt =0;
		vowels = new int[C];
		consonants = new int[C];
		for(int i = 0; i < C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);

		for(int i = 0; i < C;i++) {
			if(arr[i] == 'a' || arr[i] == 'e' ||arr[i] == 'i' ||arr[i] == 'o' ||arr[i] == 'u') {
				vowels[vowCnt++] = i;
			}else {
				consonants[conCnt++] = i;
			}
		}

		for(int vowPick = 1; vowPick <= Math.min(vowCnt, L); vowPick++) {
			int conPick = L - vowPick;
			if(conPick < 2 || conPick > conCnt) continue;
			//System.out.println("모음: " + vowPick);
			//System.out.println("자음: " + conPick);
			int[] vowIdxArr = new int[vowCnt];
			int[] conIdxArr = new int[conCnt];
			for(int i = 0; i < vowPick;i++) {
				vowIdxArr[i] = 0;
			}
			for(int i = vowPick; i < vowCnt;i++) {
				vowIdxArr[i] = 1;
			}
			for(int i = 0; i < conPick;i++) {
				conIdxArr[i] = 0;
			}
			for(int i = conPick; i < conCnt;i++) {
				conIdxArr[i] = 1;
			}
			Arrays.sort(vowIdxArr);
			do {
				Arrays.sort(conIdxArr);
				do {					
					sb = new StringBuilder();
					boolean[] picked = new boolean[C];
					for(int i = 0; i < vowIdxArr.length;i++) {
						if(vowIdxArr[i] == 0) picked[vowels[i]] = true;
					}
					for(int i = 0; i < conIdxArr.length;i++) {
						if(conIdxArr[i] == 0) picked[consonants[i]] = true;
					}
					for(int i = 0; i < picked.length;i++) {
						if(picked[i] == true) sb.append(arr[i]);
					}
					l.add(sb.toString());
				}while(nextPermutation(conIdxArr));
			}while(nextPermutation(vowIdxArr));
		} // end of for
		Collections.sort(l);
		sb = new StringBuilder();
		for(int i = 0; i < l.size();i++) sb.append(l.get(i)).append("\n");
		System.out.println(sb);
	}// end of main
	
}
