package ladder.binarysearch;
/**
 * Given a big sorted array with positive integers sorted by ascending order. 
 * The array is so big so that you can not get the length of the whole array directly, 
 * and you can only access the kth number by ArrayReader.get(k). 
 * Find the first index of a target number. 
 * Your algorithm should be in O(log k), where k is the first index of the target number.
 *
 * Return -1, if the number doesn't exist in the array.
 * 
 * Given [1, 3, 6, 9, 21, ...], and target = 3, return 1
 * Given [1, 3, 6, 9, 21, ...], and target = 4, return -1
 */

/**
 * Definition of ArrayReader:
 *
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */

public class SearchInBigSortedArray {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
    	// Algorithm:
        // 1. get the index that ArrayReader.get(index) >= target or == -1, in O(logk) time
        // 2. binary search the target between 0 and index

        // 倍增法
        int count = 1;
        // 数组第count个数的index是count - 1
        // if count in range && [index-1] < target then double the window
        while (reader.get(count - 1) != -1 && reader.get(count - 1) < target) {
            count *= 2;
        }
        
        int start = 0;
        int end = count - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(reader.get(mid) < target  && reader.get(mid) != -1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}
