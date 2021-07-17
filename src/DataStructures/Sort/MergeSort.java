package DataStructures.Sort;

public class MergeSort {
	
	public void mergesort(int arr[]) {
		int n = arr.length;
		if (n < 2)
			return;
		
		int mid = n / 2;
		int left[] = new int[mid];
		int right[] = new int[n - mid];

		for (int i = 0; i < mid; i++)
			left[i] = arr[i];
		
		for (int i = mid; i < n; i++)
			right[i - mid] = arr[i];

		mergesort(left);
		mergesort(right);
		merge(arr, left, right);
	}

	private void merge(int arr[], int left[], int right[]) {
		int L = left.length;
		int R = right.length;
		int i = 0, j = 0, k = 0;
		while (i < L && j < R) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < L) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < R) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
}