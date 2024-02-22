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
//        for (int i = 0; i < list.length; i++) {
//			System.out.println(list[i]);
//		}
        int covered = 300; //3월 1일
        int maxCover = 0, count = 0, idx = 0;
        boolean isPossible = true;

        for (int i = 0; i <= N ; i++) {
            //System.out.println("covered: " + covered);
        	if(covered >= 1130) break;
            boolean updated = false;
            while (idx < N && list[idx].start <= covered+ 1) {
            	//System.out.println("idx: " + idx);
                if (list[idx].end > maxCover) {
                    maxCover = list[idx].end;
                    updated = true;
                    //isPossible = true; //한번이라도 선택이 되어야 함
                }
                idx++;
            }
            if (updated) {
            	//System.out.println("updated");
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
                    this.end = 100;
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

		@Override
		public String toString() {
			return "INFO [start=" + start + ", end=" + end + "]";
		}
        
    }
}
