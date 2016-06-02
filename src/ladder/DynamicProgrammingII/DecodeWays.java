package ladder.DynamicProgrammingII;
/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * Given encoded message 12, it could be decoded as AB (1 2) or L (12).
 * The number of ways decoding 12 is 2.
 */
public class DecodeWays {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // f[i]: 前i个字符一共多少种解码方式
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = (s.charAt(0) == '0') ? 0 : 1; // input "0" output 0 

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                f[i] = f[i] + f[i - 2];
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args) {
    	String s = "12215";
    	DecodeWays sol = new DecodeWays();
    	System.out.println(sol.numDecodings(s));
    }
}
