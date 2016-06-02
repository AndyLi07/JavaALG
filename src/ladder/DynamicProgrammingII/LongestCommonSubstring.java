package ladder.DynamicProgrammingII;
/**
 * Given two strings, find the longest common substring.
 * Return the length of it.
 *
 * Given A = "ABCD", B = "CBCE", return 2.
 */
public class LongestCommonSubstring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] f = new int[m + 1][n + 1];
        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = 0;
                }
                maxLen = Math.max(maxLen, f[i][j]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
    	String A = "ABABC";
    	String B = "BABCA";
    	LongestCommonSubstring sol = new LongestCommonSubstring();
    	System.out.println(sol.longestCommonSubstring(A, B));
    }
}
