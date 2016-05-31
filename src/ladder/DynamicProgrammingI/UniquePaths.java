package ladder.DynamicProgrammingI;
/**
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid.
 * How many possible unique paths are there?
 * 
 * m and n will be at most 100.
 */
public class UniquePaths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
    	UniquePaths sol = new UniquePaths();
    	int m = 2;
    	int n = 2;
    	System.out.println(sol.uniquePaths(m, n));
    }
}
