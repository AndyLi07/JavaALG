package ladder.binarysearch;
/**
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 *
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */
import java.util.Arrays;

public class SearchForARange {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
    	if (A == null || A.length == 0) {
            return new int[] {-1, -1};
        }
        int[] range = new int[2];

        // search for left bound
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
        if (A[start] == target) {
            range[0] = start;
        } else if (A[end] == target) {
            range[0] = end;
        } else {
            return new int[] {-1, -1};
        }

        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            }else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            range[1] = end;
        } else if (A[start] == target) {
            range[1] = start;
        }
        return range;
    }

    public static void main(String[] args) {
    	int[] A = {5, 7, 7, 8, 8, 10};
    	SearchForARange sol = new SearchForARange();
    	System.out.println(Arrays.toString(sol.searchRange(A, 8)));
    	System.out.println(Arrays.toString(sol.searchRange(A, 17)));
    }
}
