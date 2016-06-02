package ladder.DynamicProgrammingII;
/**
 * Given an integer array, adjust each integers so that the difference of every adjacent 
 * integers are not greater than a given number target.
 * If the array before adjustment is A, the array after adjustment is B, 
 * you should minimize the sum of |A[i]-B[i]|
 */
import java.util.ArrayList;
public class MinimumAdjustmentCost {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        // f[i][j] 前i个数 第i个数调整为j, 满足相邻两数 <= target, 所需最小代价
        int[][] f = new int[A.size() + 1][101];
        for (int i = 0; i <= A.size(); i++) {
            for (int j = 0; j <= 100; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j <= 100; j++) {
            f[0][j] = 0;
        }

        for (int i = 1; i <= A.size(); i++) {
            for (int j = 0; j <= 100; j++) {
                if (f[i - 1][j] != Integer.MAX_VALUE) {
                    for (int k = 0; k <= 100; k++) {
                        if (Math.abs(j - k) <= target) {
                            if (f[i][k] > f[i - 1][j] + Math.abs(A.get(i - 1) - k)) {
                                f[i][k] = f[i - 1][j] + Math.abs(A.get(i - 1) - k);
                            }
                        }
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            result = Math.min(result, f[A.size()][i]);
        }
        return result;
    }

    public static void main(String[] args) {
    	ArrayList<Integer> A = new ArrayList<>();
    	A.add(1);
    	A.add(5);
    	A.add(8);
    	A.add(11);
    	MinimumAdjustmentCost sol = new MinimumAdjustmentCost();
    	System.out.println(sol.MinAdjustmentCost(A, 2));
    }
}
