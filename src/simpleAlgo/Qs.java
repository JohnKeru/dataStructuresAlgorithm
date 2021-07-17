package simpleAlgo;

public class Qs {
	static void quicksort(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    static void qs(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);

        qs(arr, l, p - 1);
        qs(arr, p + 1, r);
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i += 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }

    // Helper function for checking if the two given arrays
    // are equal or not.
    static boolean arrayEquals(int[] a1, int[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for(int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}
