package ladder.binarysearch;
/** 
 * Given a target number, a non-negative integer k and an integer array A sorted in ascending order, 
 * find the k closest numbers to target in A, sorted in ascending order by the difference 
 * between the number and target. Otherwise, sorted in ascending order by number if the difference 
 * is same.
 *
 * Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
 * Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
 */

import java.util.Arrays;
public class KClosestNumbersInSortedArray {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
    	int[] result = new int[k];
        if (A == null || A.length == 0) {
            return result;
        }
        if (k > A.length) {
            return A;
        }
        int index = firstBiggerIndex(A, target);
        int left = index - 1;
        int right = index;
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                result[i] = A[right++];
            } else if (right >= A.length) {
                result[i] = A[left--];
            } else {
                if (target - A[left] <= A[right] - target) {
                    result[i] = A[left--];
                } else {
                    result[i] = A[right++];
                }
            }
        }
        return result;
    }

    private int firstBiggerIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
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
    	int[] A = {1, 4, 6, 8};
    	KClosestNumbersInSortedArray sol = new KClosestNumbersInSortedArray();
    	System.out.println(Arrays.toString(sol.kClosestNumbers(A, 3, 4)));
    }
}
