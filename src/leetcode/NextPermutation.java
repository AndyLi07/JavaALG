package leetcode;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Examples: 1,2,3 → 1,3,2	3,2,1 → 1,2,3	1,1,5 → 1,5,1
 */
import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if(nums==null || nums.length<2)
			return;

    	// From the tail to find the first index that decrease
    	// e.g 124321 -> [1]
		int dropIndex = -1;
		for(int i=nums.length-2; i>=0; i--) {
			if(nums[i]<nums[i+1]) {
				dropIndex = i;
				break;
			}
		}

    	// no next permutation exist
		if(dropIndex==-1){
			Arrays.sort(nums);
			return;
		}

    	// From the tail to find the first element that greater than the [dropIndex]
    	// and swap these two.
    	// e.g 124321 -> 134221
		for(int j = nums.length - 1; j>dropIndex; j--) {
			if(nums[j] > nums[dropIndex]) {
				swap(nums, dropIndex, j);
				break;
			}
		}

    	// reverse the tail
    	// e.g 134221 -> 131224
		int left = dropIndex + 1;
		int right = nums.length - 1;
		while(left<right){
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 2, 4, 1};
		System.out.print(Arrays.toString(nums));

		NextPermutation sol = new NextPermutation();
		sol.nextPermutation(nums);
		System.out.println(" -> " + Arrays.toString(nums));
	}
}
