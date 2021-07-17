

public class LinkedListOrig {
	
	private class Node {
		private int data;
		private Node next;
	}

	private Node head;
	
	private boolean isEmpty() {
		return head == null;
	}
	
	public void insert(int data) {
		Node node = new Node();
		node.data = data;

		if (isEmpty())
			head = node;
		else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}

	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
	}

	public void insertAt(int index, int data) {
		Node node = new Node();
		node.data = data;
		if (index == 0)
			insertAtStart(data);
		else {
			Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	}

	public int getNode(int index) {
		if (size() <= index)
			return -1;

		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.data;
	}

	public void show() {
		Node node = head;
		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}

	public int size() {
		Node node = head;
		int size = 1;
		while (node.next != null) {
			size++;
			node = node.next;
		}
		return size;
	}

	public void delete(int index) {
		if (index == 0) 
			head = head.next;
		else {
			Node node = head;
			for (int i = 0; i < index - 1; i++) {
				node = node.next;
			}
			Node node2 = node.next;
			node.next = null;
			node.next = node2.next;
		}
	}

	public int indexOf(int data) {
		Node h = head;
		int index = 0;
		while (h.next != null) {
			if (h.data == data)
				return index;
			h = h.next;
			index++;
		}
		if (h.data == data) {
			return index;
		}
		return -1;
	}

	public boolean contains(int data) {
		return indexOf(data) != -1;
	}

}
