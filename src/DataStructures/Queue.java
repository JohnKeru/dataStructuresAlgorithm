package DataStructures;

public class Queue {
	private int queue[] = new int[5];
	public int size;
	private int rear;
	private int front;

	public void enqueue(int data) {
		if (size == 5)
			System.out.println("Size is full, cannot insert " + data + " anymore!");
		else {
			queue[rear] = data;
			rear = (rear + 1) % 5;
			size++;
		}
	}

	// Telusko worst implimentation
	public int dequeues() {
		int data = queue[front];
		front = (front + 1) % 5;
		size--;
		return data;
	}

	// My better implimentation
	public void dequeue() {
		for(int i = 0; i<size; i++) 
			queue[i] = queue[i+1];
		size--;
	}

	public void show() {
		for (int i = 0; i < size; i++)
			System.out.print(queue[(front + i) % 5] + " ");
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size >= 5;
	}
}
