import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _2457 {
    
	public static int[] finalDay = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        INFO[] list = new INFO[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            list[i] = new INFO(startMonth, startDay, endMonth, endDay);
        }

        Arrays.sort(list);

        int covered = 300; //3월 1일
        int maxCover = 0, count = 0, idx = 0;
        boolean isPossible = false;

        for (int i = 0; i < N ; i++) {
        	if(covered >= 1101) break;
            boolean updated = false;
            while (idx < N && list[idx].start <= covered + 1) {
                if (list[idx].end > maxCover) {
                    maxCover = list[idx].end;
                    updated = true;
                    isPossible = true;
                }
                idx++;
            }
            if (updated) {
                covered = maxCover;
                count++;
            } else {
                break;
            }
        }

        if (covered < 1130) isPossible = false;

        System.out.println(isPossible ? count : 0);
    }
    static class INFO implements Comparable<INFO> {
        int start, end;
        
        public INFO(int startMonth, int startDay, int endMonth, int endDay) {
            // 시작 날짜는 그대로 사용
            this.start = startMonth * 100 + startDay;
            // 종료 날짜를 하루 앞당겨 조정
            if (endDay == 1) {
                if (endMonth == 1) {
                    this.end = 1231;
                } else {
                    endMonth--;
                    this.end = endMonth * 100 + finalDay[endMonth];
                }
            } else {
                this.end = endMonth * 100 + (endDay - 1);
            }
        }

        @Override
        public int compareTo(INFO o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
