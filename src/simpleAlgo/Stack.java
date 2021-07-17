package simpleAlgo;


public class Stack {
	private int capacity = 2;
	private int stack[] = new int[capacity];
	private int top = 0;

	public void push(int data) {
		if (size() == 2) {
			expand();
		}
		stack[top++] = data;
	}

	private void expand() {
		int length = size();
		int newStack[] = new int[capacity * 2];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
		capacity *= 2;
	}

	public int pop() {
		top--;
		int data = stack[top];
		stack[top] = 0;
		return data;
	}

	public int indexOf(int data) {
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == data)
				return i;
		}

		return -1;
	}

	public void show() {
		for (int i : stack) {
			System.out.print(i + " ");
		}
	}

	public int size() {
		return top;
	}

	public int peek() {
		return stack[top-1];
	}

	public boolean isEmpty() {
		return top == 0;
	}
}
