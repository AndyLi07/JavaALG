package ladder.binarysearch;
/**
 * Find the last position of a target number in a sorted array. 
 * Return -1 if target does not exist.
 * 
 * Given [1, 2, 2, 4, 5, 5].
 * For target = 2, return 2. For target = 5, return 5. For target = 6, return -1.
 */

public class LastPositionOfTarget {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int lastPosition(int[] A, int target) {
    	if (A == null || A.length == 0) {
    		return -1;
    	}
    	if (A[0] > target || A[A.length - 1] < target) {
    		return -1;
    	}

    	int start = 0, end = A.length - 1;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (A[mid] == target) {
    			start = mid;
    		} else if (A[mid] > target) {
    			end = mid;
    		} else {
    			start = mid;
    		}
    	}
    	if (A[end] == target) {
    		return end;
    	}
    	if (A[start] == target) {
    		return start;
    	}
    	return -1;
    }

    public static void main(String[] args) {
    	int[] A = new int[] {1, 2, 2, 4, 5, 5};
    	LastPositionOfTarget sol = new LastPositionOfTarget();
    	System.out.println(sol.lastPosition(A, 2));
    }
}
