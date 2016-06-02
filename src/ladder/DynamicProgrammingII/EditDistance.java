package ladder.DynamicProgrammingII;
/**
 * Given two words word1 and word2, find the minimum number of steps required 
 * to convert word1 to word2. (each operation is counted as 1 step.)
 * 3 operations permitted on a word: 
 * Insert a character, Delete a character, Replace a character
 *
 * Given word1 = "mart" and word2 = "karma", return 3.
 */


// 如果操作的cost不一样，怎么选min cost
public class EditDistance {
    /**
     * @param word1 and word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            f[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1));
                } else {
                    f[i][j] = 1 + Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1]));
                }
            }
        }
        return f[m][n];
    }

    public static void main(String[] args) {
    	String word1 = "intention";
    	String word2 = "execution";
    	EditDistance sol = new EditDistance();
    	System.out.println(sol.minDistance(word1, word2));
    }
}
