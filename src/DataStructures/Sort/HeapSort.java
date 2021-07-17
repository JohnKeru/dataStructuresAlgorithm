package DataStructures.Sort;

public class HeapSort {

	public void heapify(int arr[], int n, int index) {
		int max, child;
		child = 2 * index + 1;
		max = index;
		if (child < n)
			if (arr[child] > arr[max])
				max = child;
		if (child + 1 < n)
			if (arr[child + 1] > arr[max])
				max = child + 1;
		if (max != index) {
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
			heapify(arr, n, max);
		}
	}

	public void buildheap(int arr[]) {
		for (int index = arr.length / 2 - 1; index >= 0; index--)
			heapify(arr, arr.length, index);
	}

	public void heap(int arr[]) {
		buildheap(arr);
		for (int i = arr.length - 1; i >= 1; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}
}