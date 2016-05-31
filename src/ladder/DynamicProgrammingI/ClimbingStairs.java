package ladder.DynamicProgrammingI;
/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * return 3
 */
public class ClimbingStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        // f[i]表示跳到第i个位置的方案总数
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    // 优化 不必用数组
    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        int lastlast = 1;
        int last = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }

    public static void main(String[] args) {
    	ClimbingStairs sol = new ClimbingStairs();
    	System.out.println(sol.climbStairs(3));
    	System.out.println(sol.climbStairs2(3));
    }
}
