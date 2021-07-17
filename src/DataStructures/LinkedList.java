package DataStructures;

import java.util.NoSuchElementException;

public class LinkedList {

	private class Node {
		private int value;
		private Node next;

		private Node(int value) {
			this.value = value;
		}
	}

	private Node head;
	private Node tail;
	public int size;

	private boolean isEmpty() {
		return head == null;
	}

	public void add(int item) {
		addLast(item);
	}

	public void addLast(int item) {
		size++;
		var node = new Node(item);
		if (isEmpty())
			head = tail = node;
		else {
			tail.next = node;
			tail = node;
		}
	}

	public void addFirst(int item) {
		size++;
		var node = new Node(item);
		if (isEmpty())
			head = tail = node;
		else {
			node.next = head;
			head = node;
		}
	}

	public int indexOf(int item) {
		int index = 0;
		var current = head;
		while (!isEmpty()) {
			if (current.value == item)
				return index;
			index++;
			current = current.next;
		}
		return -1;
	}

	public boolean contains(int item) {
		return indexOf(item) != -1;
	}

	private void noSuchElement() {
		if (isEmpty())
			throw new NoSuchElementException();

		if (head == tail) {
			head = tail = null;
			return;
		}
	}

	public void remove(int index) {
		size--;
		noSuchElement();
		if (index == 0)
			removeFirst();
		else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) 
				current = current.next;
			Node holder = current.next;
			current.next = holder.next;
			holder.next = holder = null;
		}
	}

	public void removeFirst() {
		size--;
		noSuchElement();
		var first = head;
		head = head.next;
		first.next = null;
	}

	public void removeLast() {
		size--;
		noSuchElement();
		var data = getPrevious(tail);
		data.next = null;
		tail = data;
	}

	private Node getPrevious(Node node) {
		var current = head;
		while (!isEmpty()) {
			if (current.next == node)
				return current;
			current = current.next;
		}
		return null;
	}

	public void show() {
		while (!isEmpty()) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
}
