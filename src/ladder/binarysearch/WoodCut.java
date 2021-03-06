package ladder.binarysearch;
/**
 * Given n pieces of wood with length L[i] (integer array). Cut them into small pieces
 * to guarantee you could have equal or more than k pieces with the same length.
 * What is the longest length you can get from the n pieces of wood?
 * Given L and k, return the maximum length of the small pieces.
 *
 * For L=[232, 124, 456], k=7, return 114.
 */

public class WoodCut {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
    	int max = 0;
    	for (int i = 0; i < L.length; i++) {
    		max = Math.max(max, L[i]);
    	}
    	// find the largest length that can cut more than k pieces of wood.
    	int start = 1;
    	int end = max;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (count(L, mid) == k) {
    			start = mid;
    		} else if (count(L, mid) < k) {
    			end = mid;
    		} else {
    			start = mid;
    		}
    	}
    	if (count(L, end) >= k) {
    		return end;
    	}
    	if (count(L, start) >= k) {
    		return start;
    	}
    	return 0;
    }

    private int count(int[] L, int length) {
    	int sum = 0;
    	for (int i = 0; i < L.length; i++) {
    		sum += L[i] / length;
    	}
    	return sum;
    }

    public static void main(String[] args) {
    	int[] L = {232, 124, 456};
        WoodCut sol = new WoodCut();
        System.out.println(sol.woodCut(L, 7));
    }
}
