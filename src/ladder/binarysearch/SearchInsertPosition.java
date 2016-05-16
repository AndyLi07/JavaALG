package ladder.binarysearch;
/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume NO duplicates in the array.
 *
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */

public class SearchInsertPosition {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
    	if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
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
    	int[] A = {1,3,5,6};
    	SearchInsertPosition sol = new SearchInsertPosition();
    	System.out.println(sol.searchInsert(A, 5));
    	System.out.println(sol.searchInsert(A, 7));
    	System.out.println(sol.searchInsert(A, -3));
    }
}
