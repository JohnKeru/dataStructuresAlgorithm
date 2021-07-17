package DataStructures;

@SuppressWarnings("unchecked")
public class Stack<T> {

	private T[] stack;
	private int top;
	private int capacity;

	public Stack(int capacity) {
		stack = (T[]) new Object[capacity];
		this.capacity = capacity;
	}

	public Stack() {
		stack = (T[]) new Object[10];
		this.capacity = 10;
	}

	public T push(T data) {
		if (top == capacity)
			expand();
		return stack[top++] = data;
	}

	private void expand() {
		T[] expandStack = (T[]) new Object[capacity * 2];
		for (int i = 0; i < stack.length; i++)
			expandStack[i] = stack[i];
		stack = expandStack;
	}

	public T pop() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty");
		top--;
		T tops = stack[top];
		stack[top] = null;
		return tops;
	}

	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty");
		return stack[top - 1];
	}

	public void show() {
		for (int i = 0; i < top; i++)
			System.out.print(stack[i] + " ");
	}

	public boolean isEmpty() {
		return top == 0;
	}

}
