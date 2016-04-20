package com.berryjam;

import java.util.ArrayList;
import java.util.List;


// 重点复习；基本类型作为参数传递时，是传递值的拷贝；对象作为参数传递时，是把对象在内存中的地址拷贝了一份传给了参数。

/**
 * @author huangjinkun.
 * @date 16/2/28
 * @time 下午6:59
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();

        helper(n, 0, new int[n], solutions);

        return solutions;
    }

    private void helper(int n, int row, int[] columnForRow, List<List<String>> solutions) {
        if (row == n) {
            List<String> solution = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String line = "";
                for (int j = 0; j < n; j++) {
                    if (columnForRow[i] == j) {
                        line += 'Q';
                    } else {
                        line += '.';
                    }
                }
                solution.add(line);
            }
            solutions.add(solution);
        } else {
            for (int i = 0; i < n; i++) {
                columnForRow[row] = i;
                if (check(row, i, columnForRow)) {
                    helper(n, row + 1, columnForRow, solutions);
                }
            }
        }
    }

    private boolean check(int row, int column, int[] columnForRow) {
        boolean legal = true;
        for (int i = 0; i < row; i++) {
            if (columnForRow[i] == column || Math.abs(columnForRow[i] - column) == (row - i)) {
                legal = false;
            }
        }

        return legal;
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        List<List<String>> solutions = queens.solveNQueens(4);
        for (List<String> solution : solutions) {
            System.out.println();
        }
    }
}
