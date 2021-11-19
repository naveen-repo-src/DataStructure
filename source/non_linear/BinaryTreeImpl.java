package non_linear;

import java.util.LinkedList;
import java.util.Queue;

/* binary tree vs binary search tree. Binary tree is not stored, binary search tree is sorted. Below implemened with binary search tree
 * 
 * 		   6
 * 		  / \
 * 		 4   8
 *      / \  / \
 *     3  5  7  9
 */
public class BinaryTreeImpl {

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

	/*
	 * Depth first search includes inOrder, preOrder and postOrder
	 */
	public void preOrderTravesal(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTravesal(node.left);
			preOrderTravesal(node.right);
		}
	}

	public void postOrderTravesal(Node node) {
		if (node != null) {
			postOrderTravesal(node.left);
			postOrderTravesal(node.right);
			System.out.print(node.data + " ");
		}
	}

	public void inOrderTravesal(Node node) {
		if (node != null) {
			inOrderTravesal(node.left);
			System.out.print(node.data + " ");
			inOrderTravesal(node.right);
		}
	}

	public void breadthFirstSearch(Node node) {
		if (node == null) {
			return;
		} else {
			Queue<Node> nodes = new LinkedList<Node>();
			nodes.add(node);
			while (!nodes.isEmpty()) {
				Node leaf = nodes.remove();
				System.out.print(leaf.data+" ");
				if(leaf.left!=null) {
					nodes.add(leaf.left);
				}
				if(leaf.right!=null) {
					nodes.add(leaf.right);
				}
			}
		}
	}
	
	public boolean containNodeUsingRecursive(Node node, int data) {
		if(node == null) {
			return false;
		}else if(node.data == data){
			return true;
		}
		return node.data>data?containNodeUsingRecursive(node.left, data):containNodeUsingRecursive(node.right, data);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeImpl treeImpl = new BinaryTreeImpl();
		treeImpl.add(6);
		treeImpl.add(4);
		treeImpl.add(8);
		treeImpl.add(3);
		treeImpl.add(5);
		treeImpl.add(7);
		treeImpl.add(9);
		
		System.out.println("--------------PreOrder-------------------");
		treeImpl.preOrderTravesal(head);
		System.out.println("");
		System.out.println("--------------PostOrder-------------------");
		treeImpl.postOrderTravesal(head);
		System.out.println("");
		System.out.println("--------------InOrder-------------------");
		treeImpl.inOrderTravesal(head);
		System.out.println("");
		System.out.println("--------------BreadthFirstSearch-------------------");
		System.out.println("");
		treeImpl.breadthFirstSearch(head);
		System.out.println("");
		System.out.println("--------------Find recursive---------------------------");
		System.out.println(treeImpl.containNodeUsingRecursive(head, 7));
		System.out.println(treeImpl.containNodeUsingRecursive(head, 0));
	}

}
