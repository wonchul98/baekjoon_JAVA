import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1167 {
	public static int N, distance[][];
	public static Node[] nodeArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 nodeArr = new Node[N+1];
		 for(int i = 1; i <= N;i++) {
			 nodeArr[i] = new Node(i, 0, new ArrayList<>());
		 }
		 distance = new int[N+1][N+1];
		 PriorityQueue<Node> pq = new PriorityQueue<>();
		 for(int i =0; i < N;i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int nodeNum = Integer.parseInt(st.nextToken());
			 int nextNode, dist;
			 do {
				 nextNode = Integer.parseInt(st.nextToken());
				 if(nextNode == -1) break;
				 dist = Integer.parseInt(st.nextToken());
				 distance[nodeNum][nextNode] = dist;
				 nodeArr[nodeNum].list.add(nodeArr[nextNode]);
			 }while(true);
			 pq.add(nodeArr[nodeNum]);
		 }
		 while(pq.size() > 1) {
			 Node cur = pq.poll(); //아마 하나만 연결되어 있음
			 System.out.println("curNode: " + cur.num);
			 Node next = cur.list.get(0);
			 next.value = Math.max(next.value, cur.value + distance[cur.num][next.num]);
			 next.deleteNode(cur);
		 }
		 System.out.println(pq.poll().value);
	}
	public static class Node implements Comparable<Node> {
		int num;
		int value;
		ArrayList<Node> list;
		public Node(int num, int value, ArrayList<Node> list) {
			this.num = num;
			this.value = value;
			this.list = list;
		}
		public void deleteNode(Node n) {
			this.list.remove(n);
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.list.size(), o.list.size());
		}
	}
}
