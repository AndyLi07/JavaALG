package ladder.binarysearch;
/**
 * Given a target number and an integer array A sorted in ascending order,
 * find the index i in A such that A[i] is closest to the given target.
 *
 * Return -1 if there is no element in the array.
 *
 * Given [1, 2, 3] and target = 2, return 1
 * Given [1, 4, 6] and target = 3, return 1
 * Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2
 */

public class ClosestNumberInSortedArray {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
    	if (A == null || A.length == 0) {
            return -1;
        }
        int index = firstBiggerIndex(A, target);
        if (index == 0) {
            return 0;
        }
        if (index == A.length) {
            return index - 1;
        }
        if (A[index] - target > target - A[index - 1]){
            return index - 1;
        }
        return index;
    }

    private int firstBiggerIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }

    public static void main(String[] args) {
    	int[] A = {1, 3, 3, 4};
    	ClosestNumberInSortedArray sol = new ClosestNumberInSortedArray();
    	System.out.println(sol.closestNumber(A, 3));
    	System.out.println(sol.closestNumber(A, 5));
    	System.out.println(sol.closestNumber(A, 0));
    }
}
