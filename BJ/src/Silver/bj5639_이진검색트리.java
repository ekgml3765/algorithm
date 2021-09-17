package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5639_이진검색트리 {
	static class Node{
		int num;
		Node left, right;
		public Node(int num) {
			this.num = num;
		}
		void insert(int num) {
			if(num < this.num) {
				if(this.left == null) {
					this.left = new Node(num);
				}else {
					this.left.insert(num);
				}
			}else {
				if(this.right == null) {
					this.right = new Node(num);
				}else {
					this.right.insert(num);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(in.readLine()));
		while(true) {
			String s = in.readLine();
			if(s == null)
				break;
			root.insert(Integer.parseInt(s));
		}
		postOrder(root);
	}
	private static void postOrder(Node node) {
		if(node.left != null)
			postOrder(node.left);
		if(node.right != null)
			postOrder(node.right);
		System.out.println(node.num);
	}
}
