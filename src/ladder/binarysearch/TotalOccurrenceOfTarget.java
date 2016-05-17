package ladder.binarysearch;
/**
 * Given a target number and an integer array sorted in ascending order. 
 * Find the total number of occurrences of target in the array.
 *
 * Given [1, 3, 3, 4, 5] and target = 3, return 2
 * Given [1, 2, 3, 4, 5] and target = 6, return 0
 */

public class TotalOccurrenceOfTarget {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
    	if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        int left = -1;
        int right = -1;
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
        if (A[start] == target) {
            left = start;
        } else if (A[end] == target) {
            left = end;
        } else {
            return 0;
        }
        
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            right = end;
        } else if (A[start] == target) {
            right = start;
        } 
        return right - left + 1;
    }

    public static void main(String[] args) {
    	int[] A = {1, 3, 3, 4, 5};
    	TotalOccurrenceOfTarget sol = new TotalOccurrenceOfTarget();
    	System.out.println(sol.totalOccurrence(A, 3));
    	System.out.println(sol.totalOccurrence(A, 4));
    	System.out.println(sol.totalOccurrence(A, 6));
    }
}
