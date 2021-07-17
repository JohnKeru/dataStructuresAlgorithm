package DataStructures.Sort;

public class RadixSort {
	int RANGE = 9;

	private void countsort(int[] arr, int length, int d) {
		int[] output = new int[length];
		int[] count = new int[RANGE + 1];

		for (int i = 0; i < length; i++)
			count[arr[i] / d % 10] += 1;

		for (int i = 1; i <= RANGE; i++)
			count[i] += count[i - 1];

		for (int i = length - 1; i >= 0; i--) {
			output[count[arr[i] / d % 10] - 1] = arr[i];
			count[arr[i] / d % 10] -= 1;
		}

		for (int i = 0; i < length; i++)
			arr[i] = output[i];
	}

	private void radixsort(int[] arr, int length) {
		int max = getMax(arr, length);

		for (int d = 1; max / d > 0; d *= 10)
			countsort(arr, length, d);
	}

	public void sort(int[] arr) {
		radixsort(arr, arr.length);
	}
	
	private int getMax(int[] arr, int length) {
		int max = arr[0];

		for (int i = 1; i < length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}
}
