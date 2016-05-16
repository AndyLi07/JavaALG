package ladder.binarysearch;
/**
 * Find any position of a target number in a sorted array. Return -1 if target does not exist.
 * O(logn) time
 * 
 * Given [1, 2, 2, 4, 5, 5].
 * For target = 2, return 1 or 2.
 * For target = 6, return -1.
 */
public class ClassicBinarySearch {
	/**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
	public int findPosition(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		if (A[0] > target || A[A.length - 1] < target) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;

		// start = 0, end = 1, exit while loop
		// start = 1, end = 1, exit
		// start = 1, end = 3, run while loop
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				start = mid;
			} else { //if (A[mid] > target) {
				end = mid;
			}
		}
		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}
		return -1;
	}

    public static void main(String[] args) {
    	int[] arr = new int[] {1, 2, 2, 4, 5, 5};
    	ClassicBinarySearch sol = new ClassicBinarySearch();
    	System.out.println(sol.findPosition(arr, 5));
    }
}
