package ladder.DynamicProgrammingI;
/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * Given the following triangle:
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */

    // version 0: traverse method
    // time limit exceeded
    private int min;

    public int minimumTotal(int[][] triangle) {
    	min = Integer.MAX_VALUE;
        traverse(triangle, 0, 0, 0);
        return min;
    }

    // 从0，0走到x, y （不算x，y）的和是sum
    private void traverse(int[][] triangle, int x, int y, int sum) {
    	if ( x == triangle.length) { // same as root == null
    		min = Math.min(sum, min);
    		return;
    	}
    	traverse(triangle, x + 1, y, sum + triangle[x][y]);
    	traverse(triangle, x + 1, y + 1, sum + triangle[x][y]);
    }

    // version 1: divide and conquer
    public int minimumTotal(int[][] triangle) {
        return dfs(triangle, 0, 0);
    }

	// 从(x,y)出发，走到最底层的minimum path value
    private int dfs(int[][] triangle, int x, int y) {
    	if (x == triangle.length) {
    		return 0;
    	}

    	int left = dfs(triangle, x + 1, y);
    	int right = dfs(triangle, x + 1, y + 1);
    	return Math.min(left, right) + triangle[x][y];
    }

    // version 2: DC + Memorization 记忆化搜索
    public int minimumTotal(int[][] triangle) {
    	int n = triangle.length;
    	int[][] hash = new int[n][n];
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			hash[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	return dfs(triangle, hash, 0, 0);
    }

    private int dfs(int[][] triangle, int[][] hash, int x, int y) {
    	if (x == triangle.length) {
    		return 0;
    	}
    	if (hash[x][y] != Integer.MAX_VALUE) {
    		return hash[x][y];
    	}
    	int left = dfs(triangle, hash, x + 1, y);
    	int right = dfs(triangle, hash, x + 1, y + 1);
    	hash[x][y] = Math.min(left, right) + triangle[x][y];
    	return hash[x][y];
    }

    // version 3: 多重循环 bottom up
    public int minimumTotal(int[][] triangle) {
    	if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

    	int n = triangle.length;
        int[][] f = new int[n][n];
        // 先把最后一层的初始化
        for (int i = 0; i < n; i++) {
            f[n - 1][i] = triangle[n - 1][i];
        }
        // 从n-2层开始 逐层向上求解
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 每层计算：从左下或右下选最小值，+自己
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return f[0][0];
    }

    // version 4: 多重循环 top down
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        
        // state: f[x][y] = minimum path value from (0,0) to x,y
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        // initialize 
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0]; // 最左侧 没有左上，只能从右上来
            f[i][i] = f[i - 1][i - 1] + triangle[i][i]; // 最右，没有右上，只能从左上来
        }
        
        // top down, 依赖于左上(x-1, y-1)和右上(x-1, y)
        // 由于(x,y)的左上和右上不一定存在，所以要提前初始化好
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }
        
        // answer，可能在最底层任意位置
        int best = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, f[n - 1][i]);
        }
        return best;
    }
}
