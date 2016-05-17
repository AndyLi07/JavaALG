package ladder.binarysearch;
/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed? Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */

public class SearchInRotatedSortedArrayII {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
