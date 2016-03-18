package leetcode;

/* 18. 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target? Find all unique quadruplets
 * in the array which gives the sum of target.
 *
 * Note:
 * 1. Elements in a quadruplet (a,b,c,d) must be in non-descending order. 
 * 2. The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums==null || nums.length<4) {
			return res;
		}
		Arrays.sort(nums);
		for(int i=0; i<nums.length-3; i++) {
			if(i!=0 && nums[i] == nums[i-1]) {
				continue;
			}
			for(int j=i+1; j<nums.length-2; j++) {
				if(j!=i+1 && nums[j]==nums[j-1]) {
					continue;
				}
				int left = j+1;
				int right = nums.length-1;
				while(left<right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if(sum==target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;

						while(left<right && nums[left-1] == nums[left]) {
							left++;
						}
						while(left<right && nums[right+1] == nums[right]) {
							right--;
						}
					} else if(sum<target) {
						left++;
					} else {
						right--;
					}

					
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		FourSum sol = new FourSum();
		for(List<Integer> tmp : sol.fourSum(nums, target)){
			System.out.println(tmp.toString());
		}
	}
}
