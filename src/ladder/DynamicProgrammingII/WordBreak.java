package ladder.DynamicProgrammingII;
/**
 * Given a string s and a dictionary of words dict, determine if s can be break into 
 * a space-separated sequence of one or more dictionary words.
 *
 * Given s = "leetcode", dict = ["leet", "code"].
 * Return true because "lintcode" can be break as "lint code".
 */ 
public class WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean[] isWord = new boolean[s.length() + 1];
        isWord[0] = true;
        int maxLen = getMaxLength(dict);
        for (int i = 1; i <= s.length(); i++) {
            isWord[i] = false;
            // 通常word不会很长，只取到最长的word长度即可
            for (int wordLength = 1; wordLength <= maxLen && wordLength <= i; wordLength++) {
            	// if f[j] == false, 不用取substring
                if (!isWord[i - wordLength]) {
                    continue;
                }
                String word = s.substring(i - wordLength, i);
                // 找到一个true，直接break
                if (dict.contains(word)) {
                    isWord[i] = true;
                    break;
                }
            }
        }
        return isWord[s.length()];
    }

    private int getMaxLength(Set<String> dict) {
        int max = 0;
        for (String word : dict) {
            if (word.length() > max) {
                max = word.length();
            }
        }
        return max;
    }
}
