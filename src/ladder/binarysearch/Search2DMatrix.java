package ladder.binarysearch;
/** 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *     - Integers in each row are sorted from left to right.
 *     - The first integer of each row is greater than the last integer of the previous row.
 *
 * [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]]
 * Given target = 3, return true.
 */
public class Search2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
    	// write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0, end = row * column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int element = matrix[mid / column][mid % column];
            if (element == target) {
                return true;
            } else if (element < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / column][start % column] == target) {
            return true;
        }
        if (matrix[end / column][end % column] == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
    	Search2DMatrix sol =  new Search2DMatrix();
    	System.out.println(sol.searchMatrix(matrix, 34));
    	System.out.println(sol.searchMatrix(matrix, 8));
    }
}
