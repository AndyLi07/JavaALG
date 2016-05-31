package ladder.DynamicProgrammingI;
/**
 * Given an array of non-negative integers, you are initially positioned at 
 * the first index of the array. Each element in the array represents 
 * your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 */
public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    // Dynamic Programming method is O(n^2).
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        boolean[] reachable = new boolean[A.length];
        reachable[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (reachable[j] && (A[j] + j >= i)) {
                    reachable[i] = true;
                    break;
                }
            }
        }
        return reachable[A.length - 1];
    }

    public static void main(String[] args) {
    	int[] A = {2, 3, 1, 1, 4};
    	JumpGame sol = new JumpGame();
    	System.out.println(sol.canJump(A));
    }
}
