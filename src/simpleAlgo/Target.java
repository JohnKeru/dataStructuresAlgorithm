package simpleAlgo;

import java.util.Arrays;

public class Target {

	public static int[] closestSumPair(int[] a1, int[] a2, int target) {
		int[] a1Sorted = Arrays.copyOf(a1, a1.length);
		Arrays.sort(a1Sorted);
		int[] a2Sorted = Arrays.copyOf(a2, a2.length);
		Arrays.sort(a2Sorted);

		int i = 0;
		int j = a2Sorted.length - 1;
		int smallestDiff = Math.abs(a1Sorted[0] + a2Sorted[0] - target);
		int[] closestPair = { a1Sorted[0], a2Sorted[0] };

		while (i < a1Sorted.length && j >= 0) {
			int v1 = a1Sorted[i];
			int v2 = a2Sorted[j];
			int currentDiff = v1 + v2 - target;
			if (Math.abs(currentDiff) < smallestDiff) {
				smallestDiff = Math.abs(currentDiff);
				closestPair[0] = v1;
				closestPair[1] = v2;
			}

			if (currentDiff == 0) {
				return closestPair;
			} else if (currentDiff < 0) {
				i += 1;
			} else {
				j -= 1;
			}
		}

		return closestPair;
	}
}
