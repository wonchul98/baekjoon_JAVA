import java.util.*;
import java.io.*;

public class _1202 {
    static class Pair {
        int first, second;
        Pair(int f, int s){
            this.first = f; //무게
            this.second = s; //가격
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return Integer.compare(o1.first, o2.first);
            }
        });//무게 기준 오름차순
        PriorityQueue<Integer> back = new PriorityQueue<Integer>(); //오름차순
        for(int i = 0; i < n;i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()); //무게
            int right = Integer.parseInt(st.nextToken()); //가격
            pq.add(new Pair(left, right));
        }
//        while(!pq.isEmpty()){
//            System.out.println(pq.peek().first + " " + pq.peek().second);
//            pq.remove();
//        }
        int f_big;
        int s_big;
        for(int i = 0; i < k;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken()); //무게
            back.add(weight);
        }
        long cnt = 0;
        Pair insert_p = new Pair(0,0);
        PriorityQueue<Pair> pq2 = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return Integer.compare(o2.second, o1.second);
            }
        });
        for(int i = 0 ; i < k;i++){
            int back_w = back.poll();

            while(!pq.isEmpty() && pq.peek().first <= back_w){
                pq2.add(pq.poll());
            }
            if(!pq2.isEmpty())cnt+=pq2.poll().second;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
