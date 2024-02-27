import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _12738 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		
		for(int i = 0; i < N;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(list.size()==0) {
				list.add(a);
				continue;
			}
			if(list.get(list.size()-1) < a) {
				list.add(a);
				continue;
			}
			int idx = binarySearch(a, list);
			if(list.get(idx) > a) {
				list.set(idx, a);
			}
		}
		System.out.println(list.size());
	}
	public static int binarySearch(int key, ArrayList<Integer> list) {
		int low = 0;
        int high = list.size()-1;
        int mid = (low + high) >>> 1;

        while (low <= high) {
            mid = (low + high) >>> 1;
            int cmp = list.get(mid) - key;

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        if(list.get(mid) < key) return mid + 1;
        return mid;  // key not found
	}
}
