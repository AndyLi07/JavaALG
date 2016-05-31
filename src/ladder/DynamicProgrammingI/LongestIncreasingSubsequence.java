package ladder.DynamicProgrammingI;
/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 * LIS problem is to find a subsequence of a given sequence in which the subsequence's elements 
 * are in sorted order, lowest to highest, and in which the subsequence is as long as possible. 
 * This subsequence is not necessarily contiguous, or unique.
 *
 * For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
 */
public class LongestIncreasingSubsequence {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // state: f[i] (从任意某个木桩)跳到第i个木桩,最多踩过多少根木桩
        int[] f = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
        	// initialize
            f[i] = 1;
            // function
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    if (f[i] <= f[j] + 1) {
                        f[i] = f[j] + 1;
                    }
                }
            }
            // get the result
            if (f[i] > maxLen) {
                maxLen = f[i];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
    	int[] nums = {4, 2, 4, 5, 3, 7};
    	LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
    	System.out.println(sol.longestIncreasingSubsequence(nums));
    }
}
