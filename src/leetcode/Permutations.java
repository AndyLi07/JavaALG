package leetcode;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example, [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]
 */
import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length==0) {
    		return result;
    	}

    	List<Integer> list = new ArrayList<Integer>();
    	helper(result, list, nums);

    	return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
    	if(list.size()==nums.length) {
    		result.add(new ArrayList<Integer>(list));
    		return;
    	}

    	for(int i=0; i<nums.length; i++) {
    		if(list.contains(nums[i])) {
    			continue;
    		}
    		list.add(nums[i]);
    		helper(result, list, nums);
    		list.remove(list.size()-1);
    	}
    }

    public static void main(String[] args) {
    	int[] nums = {1, 2, 3};
    	System.out.println(Arrays.toString(nums) + " 's permutations are: ");

    	Permutations sol = new Permutations();
    	System.out.println(sol.permute(nums));

    }
}
