package ladder.DynamicProgrammingII;
/**
 * Given n distinct positive integers, integer k (k <= n) and a number target.
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * 
 * Given [1,2,3,4], k = 2, target = 5. There are 2 solutions: [1,4] and [2,3].
 * Return 2
 */
public class kSum {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
    	// 从前i个数选出j个的数的和是t 有多少种方案
        int[][][] f = new int[A.length + 1][k + 1][target + 1];
        for (int i = 0; i <= A.length; i++) {
            f[i][0][0] = 1;
        }
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    // initialize
                    f[i][j][t] = 0;
                    // function
                    if (t >= A[i - 1]) {
                        f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];
                    }
                    f[i][j][t] += f[i - 1][j][t];
                }
            }
        }
        return f[A.length][k][target];
    }
}
