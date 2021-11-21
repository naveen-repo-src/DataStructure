package non_linear.problems;

import java.util.LinkedList;
import java.util.Queue;

/* 
 * 		   6
 * 		  / \
 * 		 4   8
 *      / \  / \
 *     3  5  7  9
 */
public class LevelOrderTravesal {
	static Node head;

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void add(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			head = add(head, data);
		}
	}

	public Node add(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (node.data > data) {
				node.left = add(node.left, data);
			} else if (node.data < data) {
				node.right = add(node.right, data);
			} else {
				return node;
			}
		}
		return node;
	}
	
	public void breadthFirstSearch(Node node) {
		if (node == null) {
			return;
		} else {
			Queue<Node> nodes = new LinkedList<Node>();
			nodes.add(node);
			breadthFirstSearch(nodes, 0);
		}
	}

	public void breadthFirstSearch(Queue<Node> nodes,int level) {
		if (nodes.isEmpty()) {
			return;
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			while (!nodes.isEmpty()) {
				Node leaf = nodes.remove();
				System.out.print(leaf.data + " ");
				if (leaf.left != null) {
					queue.add(leaf.left);
				}
				if (leaf.right != null) {
					queue.add(leaf.right);
				}
			}
			System.out.println("");
			breadthFirstSearch(queue,level+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrderTravesal travesal = new LevelOrderTravesal();
		travesal.add(6);
		travesal.add(4);
		travesal.add(8);
		travesal.add(3);
		travesal.add(5);
		travesal.add(7);
		travesal.add(9);
		travesal.breadthFirstSearch(head);
	}

}
