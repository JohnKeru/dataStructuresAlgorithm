package DataStructures.Sort;

public class MyQuickSort {

	public void quickSort(int[] arr) {
		qs(arr, 0, arr.length - 1);
	}

	private void qs(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int pivot = partition(arr, left, right);
		qs(arr, left, pivot - 1);
		qs(arr, pivot + 1, right);
	}

	private int partition(int[] arr, int left, int right) {
		
		int tempo = arr[right - 1];
		arr[right - 1] = arr[right];
		arr[right] = tempo;
		
		int pivot = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				int temp = arr[++i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = temp;
		return i + 1;
	}

}
