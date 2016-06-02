package ladder.DynamicProgrammingII;
/** 
 * Given a string s, cut s into some substrings such that every substring is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 */
public class PalindromePartitioningII {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        boolean[][] isPalindrome = getIsPalindrome(s);
        
        int[] f = new int[s.length() + 1];
        f[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            f[i] = i;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()] - 1;
    }

    private boolean[][] getIsPalindrome(String s) {
        // 区间型动规
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        // initialize
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        // function
        // 区间型 递增的是区间长度
        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length] = isPalindrome[start + 1][start + length - 1] && (s.charAt(start) == s.charAt(start + length));
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        PalindromePartitioningII sol = new PalindromePartitioningII();
        System.out.println(sol.minCut(s));
    }
}
