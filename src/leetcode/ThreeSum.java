package leetcode;

/* 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array 
 * which gives the sum of zero.
 *
 * Note:
 * 1. Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * 2. The solution set must not contain duplicate triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
    	// Should not initialize as ArrayList<ArrayList<Integer>> ()
    	// because if you had a List<List<Integer>> then you'd be able to add 
    	// a LinkedList<Integer> to it. But you can't do this for an 
    	// ArrayList<ArrayList<Integer>>, so the latter can't possibly be 
    	// a type of List<List<Integer>>.
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length<3)
            return res;
            
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++) {

            if(i!=0 && nums[i]==nums[i-1]){
				continue;
			}

            int left = i + 1;
            int right = nums.length-1;
            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0) {
                	List<Integer> tmp = new ArrayList<>();
                	tmp.add(nums[i]);
                	tmp.add(nums[left]);
                	tmp.add(nums[right]);
                    res.add(tmp);
                    left++;
                    right--;

                    while(left<right && nums[left]==nums[left-1]) {
                        left++;
                    }

                    while(left<right && nums[right]==nums[right+1]) {
                        right--;
                    }
                }else if(sum<0) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    	int[] nums = {-1, 0, 1, 2, -1, -4};
    	ThreeSum sol = new ThreeSum();
    	for(List<Integer> triplet : sol.threeSum(nums)){
    		System.out.println(triplet.toString());
    	}
    }
}
