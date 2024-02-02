import java.io.*;
import java.util.*;

public class _1753 {
    static ArrayList<PriorityQueue<Pair>> listOfPriorityQueues = new ArrayList<>();
    static int startNode;
    public static class Pair {
        int first, second;
        Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Comparator<Pair> pairComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.second, p2.second);
            }
        };
        int V, E;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            listOfPriorityQueues.add(new PriorityQueue<>(pairComparator));
        }

        for(int i = 0; i < E;i++){
            st = new StringTokenizer(br.readLine());
            int u,v,w;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            listOfPriorityQueues.get(u).add(new Pair(v, w));
        }
    }
    public static void dijkstra(){

        int nextNode;
        if(listOfPriorityQueues.get(startNode).isEmpty()) return;
        nextNode = listOfPriorityQueues.get(startNode).poll().first;
    }
}
