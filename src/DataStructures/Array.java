package DataStructures;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {

	private int count;
	private T[] arr;
	public int length;

	public Array(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + size);
		arr = (T[]) new Object[size];
	}

	public void show() {
		for (int i = 0; i < count; i++)
			System.out.println(arr[i]);
	}

	public void insert(T data) {
		length++;
		if (arr.length == count) {
			T[] newArr = (T[]) new Object[count * 2];
			for (int i = 0; i < count; i++)
				newArr[i] = arr[i];
			arr = newArr;
		}
		arr[count++] = data;
	}

	public T select(int index) {
		return arr[index];
	}

	public void deleteAt(int index) {
		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException("Index: " + index);
		for (int i = index; i < count; i++)
			arr[i] = arr[i + 1];
		count--;
	}

	public int indexOf(T value) {
		for (int i = 0; i < count; i++) {
			if (value == arr[i])
				return i;
		}
		return -1;
	}

	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	public void clear() {
		for (int i = 0; i < count; i++)
			arr[i] = null;
		length = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = 0;

			public boolean hasNext() {
				return index < count;
			}

			public T next() {
				return arr[index++];
			}
		};
	}

}
