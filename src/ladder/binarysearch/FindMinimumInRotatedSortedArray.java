package ladder.binarysearch;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 * Given [4, 5, 6, 7, 0, 1, 2] return 0
 */

public class FindMinimumInRotatedSortedArray {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // find the first index of 第二段上升区间
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        int target = num[num.length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == target) {
                end = mid;
            } else if (num[mid] > target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (num[start] <= target) {
            return num[start];
        } else {// if (num[end] <= target) {
            return num[end];
        }
    }

    public static void main(String[] args) {
    	int[] num = {4, 5, 6, 7, 0, 1, 2};
    	FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();
    	System.out.println(sol.findMin(num));
    }
}
