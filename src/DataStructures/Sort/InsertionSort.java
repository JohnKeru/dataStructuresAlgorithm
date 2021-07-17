package DataStructures.Sort;

public class InsertionSort {

	public void sort(int[] r) {
		for (var i = 1; i < r.length; i++) {
			var current = r[i];
			var j = i - 1;
			while (j >= 0 && r[j] > current) {
				r[j + 1] = r[j];
				j--;
			}
			r[j + 1] = current;
		}
	}
}
