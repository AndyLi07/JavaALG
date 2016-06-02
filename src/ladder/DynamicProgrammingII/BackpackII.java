package ladder.DynamicProgrammingII;
/**
 * Given n items with size Ai and value Vi, and a backpack with size m. 
 * What's the maximum value can you put into the backpack?
 *
 * Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], 
 * and a backpack with size 10. The maximum value is 9. 
 */
public class BackpackII {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A, V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        int[][] f = new int[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            f[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            f[0][j] = 0;
        }
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= A[i - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        int maxValue = 0;
        for (int i = 1; i <= m; i++) {
            maxValue = Math.max(maxValue, f[A.length][i]);
        }
        return maxValue;
    }

    // 优化 O(m) 空间
    public int backPackIIV2(int m, int[] A, int V[]) {
        int[] f = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                if (f[j] < f[j - A[i]] + V[i]) {
                    f[j] = f[j - A[i]] + V[i];
                }
            }
        }
        return f[m];
    }

    public static void main(String[] args) {
    	int m = 10;
    	int[] A = {2, 3, 5, 7};
    	int[] V = {1, 5, 2, 4};
    	BackpackII sol = new BackpackII();
    	System.out.println(sol.backPackII(m, A, V));
    	System.out.println(sol.backPackIIV2(m, A, V));
    }
}
