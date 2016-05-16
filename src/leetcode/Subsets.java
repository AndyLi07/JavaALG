package leetcode;

/**
 * Given a set of distinct integers, return all possible subsets.
 *
 * Note: 
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 */

import java.util.*;

public class Subsets {
	// recursive
    public List<List<Integer>> subsets_recursive(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums.length == 0 || nums == null) {
    		return result;
    	}
    	Arrays.sort(nums);
    	List<Integer> list = new ArrayList<Integer>();

    	helper(result, list, nums, 0);

    	return result;
    }

    // 找到以list开头的所有subsets
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
    	
        result.add(new ArrayList<Integer>(list));
    	
        for(int i=index; i<nums.length; i++) {

    		list.add(nums[i]);
            // only add number greater than the last one, to keep the result unique
    		helper(result, list, nums, i+1);
    		list.remove(list.size()-1);
    	}
    }

    // non-recursive: using bit string
    public List<List<Integer>> subsets_non_recursive(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums.length == 0 || nums == null) {
    		return result;
    	}
    	int n = nums.length;
    	Arrays.sort(nums);

    	// 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1,2,3]
        for(int i=0; i<(1<<n); i++) {
        	List<Integer> subset = new ArrayList<Integer>();
        	for(int j=0; j<n; j++) {
        		// check whether the jth digit in i's binary representation is 1
        		if((i&(1<<j)) != 0) {
        			subset.add(nums[j]);
        		}
        	}

        	result.add(subset);
        }

    	return result;
    }

    public static void main(String[] args) {
    	int[] arr = {1, 2, 3};
    	Subsets sol = new Subsets();
    	System.out.println(sol.subsets_recursive(arr));
    	System.out.println();

    	int[] arr2 = {1, 2, 3, 4};
    	System.out.println(sol.subsets_non_recursive(arr2));
    }
}
