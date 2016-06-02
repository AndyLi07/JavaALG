package ladder.DynamicProgrammingII;
/**
 * Given two strings, find the longest common subsequence (LCS).
 * Your code should return the length of LCS.
 *
 * For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 * For "ABCD" and "EACB", the LCS is "AC", return 2.
 */
public class LongestCommonSubsequence {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int ABCDEFG(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            f[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                	f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[m][n];
    }

    public static void main(String[] args) {
    	String A = "ABCDEFG";
    	String B = "BCDGK";
    	LongestCommonSubsequence sol = new LongestCommonSubsequence();
    	System.out.println(sol.ABCDEFG(A, B));
    }
}
