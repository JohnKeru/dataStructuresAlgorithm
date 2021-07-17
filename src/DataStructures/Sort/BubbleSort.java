package DataStructures.Sort;

public class BubbleSort {
	
	public void sort(int[] nums) {
		bs(nums, nums.length);
	}

	private void bs(int[] nums, int length) {
		if (length <= 1)
			return;

		for (int i = 0; i < length - 1; i++) {
			int j = i + 1;
			if (nums[i] >= nums[j]) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}

		bs(nums, length - 1);
	}
}
