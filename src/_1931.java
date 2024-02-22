
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _1931 {
	public static class Pair<F, S> {
	    private F first;
	    private S second;

	    public Pair(F first, S second) {
	        this.first = first;
	        this.second = second;
	    }

	    public F getFirst() {
	        return first;
	    }

	    public S getSecond() {
	        return second;
	    }
	}

    static class TimeComparator implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
            if (a.getSecond().equals(b.getSecond())) {
                return a.getFirst().compareTo(b.getFirst());
            }
            return a.getSecond().compareTo(b.getSecond());
        }
    }

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
        List<Pair<Integer, Integer>> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Pair<>(start, end));
        }

        Collections.sort(meetings, new TimeComparator());
        int endTime = meetings.get(0).getSecond();
        int count = 1;

        for (int i = 1; i < meetings.size(); i++) {
            if (endTime <= meetings.get(i).getFirst()) {
                endTime = meetings.get(i).getSecond();
                count++;
            }
        }

        System.out.println(count);
    }
}
