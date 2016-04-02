package leetcode;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example, [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
import java.util.*;

public class PermutationsWithDuplicates {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums== null || nums.length==0){
    		return result;
    	}

    	Arrays.sort(nums);
    	boolean[] visited = new boolean[nums.length];

    	List<Integer> list = new ArrayList<Integer>();

    	helper(result, list, nums, visited);

    	return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
    	if(list.size()==nums.length) {
    		result.add(new ArrayList<Integer>(list));
    		return;
    	}

    	for(int i=0; i<nums.length; i++) {
    		// for duplicates, only select consecutively
    		// e.g [1, 2, 3, 3, 3, 5], can only permute as 3, 33, 333
    		// if select the second 3 without the first 3, it will skip this, enter next loop
    		if(visited[i] || (i!=0 && nums[i]==nums[i-1] && !visited[i-1])) {
    			continue;
    		}

    		visited[i] = true;
    		list.add(nums[i]);
    		helper(result, list, nums, visited);
    		list.remove(list.size()-1);
    		visited[i] = false;
    	}
    }

    public static void main(String[] args) {
    	int[] nums = {1, 1, 1, 2, 3};
    	System.out.println(Arrays.toString(nums));

    	PermutationsWithDuplicates sol = new PermutationsWithDuplicates();
    	System.out.println(sol.permuteUnique(nums));
    }
}
