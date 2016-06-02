package ladder.DynamicProgrammingII;
/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. 
 * How full you can fill this backpack? 
 * You function should return the max size we can fill in the given backpack.
 */
public class Backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
    	// f[i][j] 表示前i个物品，取出一些能否组成重量和为j的背包
        boolean[][] f = new boolean[A.length + 1][m + 1];
        // initialize
        for (int i = 0; i <= A.length; i++) {
            f[i][0] = true;
        }
        for (int j = 1; j <= m; j++) {
            f[0][j] = false;
        }
        // f[i][j] = f[i-1][j - A[i - 1]] or f[i-1][j] (A[i -1]表示第i个物品的大小)
        // 1. f[i-1][j - A[i-1]] 放入第i个物品，并且前i-1个物品能否取出一些组成和为j-A[i-1]大小的背包
        // 2. f[i-1][j] 不放入第i个物品， 并且前i-1个物品能否取出一些组成和为j大小的背包。
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j] || (j >= A[i - 1] && f[i - 1][j - A[i - 1]]);
            }
        }
        // 寻找使f[n][i] 值为true的最大的S
        int maxWeight = 0;
        for (int i = 1; i <= m; i++) {
            if (f[A.length][i]) {
                maxWeight = Math.max(i, maxWeight);
            }
        }
        return maxWeight;
    }

    // 优化 O(m) memory
	public int backPackV2(int m, int[] A) {
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = f[j - A[i]] || f[j];
            }
        }
        for (int i = m; i >= 0; i--) {
            if (f[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
    	int[] A = {3,4,8,5};
    	int m = 10;
    	Backpack sol = new Backpack();
    	System.out.println(sol.backPack(m, A));
    	System.out.println(sol.backPackV2(m, A));
    }
}
