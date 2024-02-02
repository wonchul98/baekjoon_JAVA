
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class _2217 {

	public static void main(String[] args) throws IOException {
		HashMap<Integer, Integer> m = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0;i < N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(m.get(num) == null) m.put(num, 1);
			else m.put(num, m.get(num)+1);
		}
		List<Integer> keySet = new ArrayList<>(m.keySet());
		Collections.sort(keySet);
		
		int rest = N;
		int max = 0;
		for(int i = 0;i < keySet.size();i++) {
			int key = keySet.get(i);
			int num = m.get(key);
			max = Math.max(key * rest, max);
			rest -= num;
		}
		System.out.println(max);
		
	}
}

