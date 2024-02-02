import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _4256 {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static class Node{
		
		private int value;
		private Node left;
		private Node right;	
		Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		@Override
		public String toString() {
			return Integer.toString(value);
		}
		
	}
	public static List<Integer> pre_arr = new ArrayList<>();
	public static List<Integer> in_arr = new ArrayList<>();
	public static int N;
	public static int idx = 0;
	public static List<Integer> ans = new ArrayList<>();
	public static int getParent() {
		return pre_arr.get(idx++);
	}
	public static Node setNode(List<Integer> arr, int parent) {
//		System.out.printf("setNode(%d)\n", parent);
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.print(arr.get(i) + " ");
//		}
//		System.out.println();
		
		if(arr.size() == 0) return null; //
		if(arr.size() == 1) return new Node(parent); //
		List<Integer> arr1 = new ArrayList<>();
		List<Integer> arr2 = new ArrayList<>();
		boolean found = false;
		for(int num : arr) {
			if(num == parent) {
				found = true;
				continue;
			}
			if(found) arr2.add(num);
			else arr1.add(num);
		}
		
		Node n = new Node(parent);
		if(arr1.size() == 0) n.setLeft(null);
		else n.setLeft(setNode(arr1, getParent()));
		if(arr2.size() == 0) n.setRight(null);
		else n.setRight(setNode(arr2, getParent()));
		return n;
	}
	public static void postOrder(Node node) throws IOException{
		if(node.left != null) {
			postOrder(node.left);
		}
		if(node.right!=null) {
			postOrder(node.right);
		}
		ans.add(node.getValue());
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T = Integer.parseInt(br.readLine());
		 for(int test_case = 1; test_case <= T;test_case++) {
			 N = Integer.parseInt(br.readLine());
			 idx = 0;
			 in_arr.clear();
			 pre_arr.clear();
			 ans.clear();
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 for(int i = 0;i < N;i++) {
				 pre_arr.add(Integer.parseInt(st.nextToken()));
			 }
			 st = new StringTokenizer(br.readLine());
			 for(int i = 0;i < N;i++) {
				 in_arr.add(Integer.parseInt(st.nextToken()));
			 }
			 Node root = setNode(in_arr, getParent());
			 postOrder(root);
			 for(int i = 0; i < ans.size();i++) {
				 if(i == ans.size()-1) bw.write(Integer.toString(ans.get(i))+"\n");
				 else bw.write(Integer.toString(ans.get(i)) + " ");
		
			 }
		 }
		 bw.flush();
		 bw.close();
		 br.close();
	}
}
