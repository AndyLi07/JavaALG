package ladder.binarysearch;
/**
 * There is an integer array which has the following features:
 *     - The numbers in adjacent positions are different.
 *     - A[0] < A[1] AND A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peek if: A[P] > A[P-1] AND A[P] > A[P+1]
 *
 * Find a peak element in this array. Return the index of the peak.
 * The array may contains multiple peeks, find any of them.
 * 
 * Given [1, 2, 1, 3, 4, 5, 7, 6]
 * Return index 1 (which is number 2) or 6 (which is number 7)
 */
public class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
    	if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid + 1]) { // 后一段是先上升后下降
                start = mid;
            } else if (A[mid] < A[mid - 1]) { // 前一段是先上升后下降
                end = mid;
            } else { // 前一段上升上升，后一段下降下降 则mid是波峰 直接返回
                // end = mid;
                return mid;
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }

    public static void main(String[] args) {
    	int[] A = {1, 2, 1, 3, 4, 5, 7, 6};
    	FindPeakElement sol = new FindPeakElement();
    	System.out.println(sol.findPeak(A));
    }
}
