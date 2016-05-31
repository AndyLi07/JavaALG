package ladder.DynamicProgrammingI;
/**
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] steps = new int[A.length];
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && (A[j] + j >= i)) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[A.length - 1];
    }

    public static void main(String[] args) {
    	int[] A = {2, 3, 1, 1, 4};
    	JumpGameII sol = new JumpGameII();
    	System.out.println(sol.jump(A));
    }
}
