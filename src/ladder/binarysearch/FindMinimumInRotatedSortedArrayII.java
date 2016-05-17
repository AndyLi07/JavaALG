package ladder.binarysearch;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 * The array may contain duplicates.
 *
 * Given [4,4,5,6,7,0,1,2] return 0
 */

public class FindMinimumInRotatedSortedArrayII {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return -1;
        }
        // worst case: 1, 1, 1, 1, 0, 1, 1, 1 cannot use binary search, have to go through all element => O(n), same as using for loop
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
    	int[] num = {4,4,5,6,7,0,1,2};
    	FindMinimumInRotatedSortedArrayII sol = new FindMinimumInRotatedSortedArrayII();
    	System.out.println(sol.findMin(num));
    }
}
