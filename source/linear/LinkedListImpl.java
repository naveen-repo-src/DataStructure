package linear;

public class LinkedListImpl {

	Node head;
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	public void add(int data) {
		if(head == null) {
			head = new Node(data);
		}else {
			head.next = add(head.next, data);
		}
	}
	
	public Node add(Node node, int data) {
		if(node == null) {
			node = new Node(data);
		}else {
			node.next = add(node.next, data);
		}
		return node;
	}
	
	public void getAll() {
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public void get(int index) {
		Node current = head;
		int counter = 0;
		while(current != null) {
			if(counter == index) {
				System.out.println(current.data);
				return;
			}
			counter++;
			current = current.next;
		}
	}
	
	public void remove(int index) {
		if(index == 0) {
			head = head.next;
		}else {
			head.next = remove(head.next ,index, 1);
		}
	}
	
	public Node remove(Node node, int index, int counter) {
		if(counter==index) {
			return node.next;
		}else {
			node.next = remove(node.next, index, counter+1);
		}
		return node;
	}
	
	public void insert(int index, int data) {
		if(index == 0) {
			Node temp = head;
			head = new Node(data);
			head.next = temp;
		}else {
			head.next = insert(head.next, data,index, 1);
		}
	}
	
	public Node insert(Node node, int data, int index, int counter) {
		if(counter==index) {
			Node temp = node;
			node = new Node(data);
			node.next = temp;
			return node;
		}else {
			node.next = insert(node.next, data, index, counter+1);
		}
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListImpl impl = new LinkedListImpl();
		impl.add(1);
		impl.add(2);
		impl.add(3);
		impl.add(4);
		impl.add(5);
		impl.getAll();
		System.out.println("------------------------");
		impl.get(2);
		System.out.println("------------------------");
		impl.remove(2);
		impl.getAll();
		System.out.println("------------------------");
		impl.insert(0, 0);
		impl.getAll();
		System.out.println("------------------------");
		impl.insert(2, 6);
		impl.getAll();
	}

}
