package leetcode;

/**
 * Given a list of numbers that may has duplicate numbers, return all possible subsets
 *
 * If S = [1,2,2], a solution is:
 * [[2], [1], [1,2,2], [2,2], [1,2], []]
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SubsetsWithDuplicate {
    public List<List<Integer>> subsetsWithDupe(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();

    	if(nums == null || nums.length == 0) {
    		return result;
    	} 

    	Arrays.sort(nums);
    	subsetsHelper(result, list, nums, 0);

    	return result;
    }

    private void subsetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
    	result.add(new ArrayList<Integer>(list));
    	for(int i=pos; i<nums.length; i++) {
            // i != pos: 跳过了一个数
            // 如果现在的和跳过的值一样，continue
    		if(i!=pos && nums[i]==nums[i-1]) {
    			continue;
    		}
    		list.add(nums[i]);
    		subsetsHelper(result, list, nums, i+1);
    		list.remove(list.size()-1);
    	}
    }

    public static void main(String[] args) {
    	int[] nums = {3, 1, 3, 2, 2};
    	System.out.println("nums = " + Arrays.toString(nums));

    	SubsetsWithDuplicate sol = new SubsetsWithDuplicate();
    	System.out.println(sol.subsetsWithDupe(nums));
    }
}
