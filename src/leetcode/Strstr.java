package leetcode;
/** 
 * For a given source string and a target string, 
 * you should output the first index(from 0) of target string in source string.
 * If target does not exist in source, just return -1.
 *
 * If source = "source" and target = "target", return -1.
 * If source = "abcdabcdefg" and target = "bcd", return 1. 
 */

public class Strstr {
    public int strStr(String source, String target) {
    	if(source == null || target == null) {
    		return -1;
    	}

    	for(int i = 0; i < source.length() - target.length() + 1; i++) {
    		int j = 0;
    		for(j = 0; j<target.length(); j++) {
    			if(source.charAt(i+j) != target.charAt(j))
    				break;
    		}
    		if(j == target.length()) 
    			return i;
    	} 

    	return -1;
    }

    public static void main(String[] args) {
    	String source1 = "source";
    	String target1 = "target";

    	Strstr sol = new Strstr();
    	System.out.println(sol.strStr(source1, target1));

    	String source2 = "abcdabcdefg";
    	String target2 = "cda";
    	System.out.println(sol.strStr(source2, target2));
    }
}
