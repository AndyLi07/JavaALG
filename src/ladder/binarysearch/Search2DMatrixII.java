package ladder.binarysearch;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix,
 * return the occurrence of it.
 *
 * This matrix has the following properties:
 *     Integers in each row are sorted from left to right.
 *     Integers in each column are sorted from up to bottom.
 *     No duplicate integers in each row or column.
 *
 * Consider the following matrix:[[1, 3, 5, 7], [2, 4, 7, 8], [3, 5, 9, 10]]
 * Given target = 3, return 2.
 */

public class Search2DMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int count = 0;
        // from bottom left to top right
        int m = matrix.length;
        int n = matrix[0].length;
        int row = m - 1;
        int column = 0;
        while (row >= 0 && column < n) {
            if (matrix[row][column] < target) {
                column++;
            } else if (matrix[row][column] > target) {
                row--;
            } else {
                count++;
                row--;
                column++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    	int[][] matrix = {{1, 3, 5, 7}, {2, 4, 7, 8}, {3, 5, 9, 10}};
    	Search2DMatrixII sol = new Search2DMatrixII();
    	System.out.println(sol.searchMatrix(matrix, 7));
    	System.out.println(sol.searchMatrix(matrix, 6));
    }
}
