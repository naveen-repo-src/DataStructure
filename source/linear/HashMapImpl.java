package linear;

public class HashMapImpl {

	Node[] bucket = new Node[16];

	static class Node {

		String key;
		String value;
		Node next;

		public Node(String key, String value) {
			this.key = key;
			this.value = value;
			next = null;
		}

		public int hashCode() {
			return key.length();
		}

		public boolean equals(Object object) {
			if (object instanceof String) {
				return key.equals(object.toString());
			}
			return false;
		}
	}

	public void put(String key, String value) {
		Node node = new Node(key, value);
		if (bucket[node.hashCode()] != null) {
			Node head = bucket[node.hashCode()];
			head.next = add(head.next, node);
			bucket[node.hashCode()] =head;
		} else {
			bucket[node.hashCode()] = node;
		}
	}

	public Node add(Node head, Node tail) {
		if (head == null) {
			head = tail;
		} else {
			head.next = add(head.next, tail);
		}
		return head;
	}

	public String get(String key) {
		Node node = new Node(key, null);
		if(bucket[node.hashCode()] != null)
		{
			Node head = bucket[node.hashCode()];
			while(head.next != null) {
				if(head.equals(key)) {
					return head.value;
				}
				head = head.next;
			}
			return head.value;
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapImpl mapImpl = new HashMapImpl();
		mapImpl.put("Hai", "Hello");
		mapImpl.put("Yes", "World");
		mapImpl.put("Yis", "World");
		mapImpl.put("World", "tour");
		System.out.println(mapImpl.get("Yes"));
		System.out.println(mapImpl.get("World"));
		System.out.println(mapImpl.get("random"));
	}

}
