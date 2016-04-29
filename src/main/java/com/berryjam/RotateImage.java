package com.berryjam;

/**
 * 还有一种更简单的方式是先转置再对每行逆序
 *
 * @author huangjinkun.
 * @date 16/4/25
 * @time 下午9:02
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
