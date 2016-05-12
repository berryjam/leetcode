package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/5/12
 * @time 下午9:36
 */
public class RoundTripMatrix {

    public int[][] getRoundTripMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[n];
        }

        Direction direction = Direction.RIGHT;
        int num = 1;
        int i = 0, j = 0;
        while (true) {
            matrix[i][j] = num;
            switch (direction) {
                case RIGHT:
                    if (j < n - 1) {
                        if (matrix[i][j + 1] != 0) {
                            direction = Direction.DOWN;
                            i++;
                        } else {
                            j++;
                        }
                    } else {
                        direction = Direction.DOWN;
                        i++;
                    }
                    break;
                case DOWN:
                    if (i < n - 1) {
                        if (matrix[i + 1][j] != 0) {
                            direction = Direction.LEFT;
                            j--;
                        } else {
                            i++;
                        }
                    } else {
                        direction = Direction.LEFT;
                        j--;
                    }
                    break;
                case LEFT:
                    if (j > 0) {
                        if (matrix[i][j - 1] != 0) {
                            direction = Direction.UP;
                            i--;
                        } else {
                            j--;
                        }
                    } else {
                        direction = Direction.UP;
                        i--;
                    }
                    break;
                case UP:
                    if (i > 0) {
                        if (matrix[i - 1][j] != 0) {
                            direction = Direction.RIGHT;
                            j++;
                        } else {
                            i--;
                        }
                    } else {
                        direction = Direction.RIGHT;
                        j++;
                    }
                    break;
            }
            num++;
            if (num > n * n) {
                break;
            }
        }

        return matrix;
    }

    enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    public static void main(String[] args) {
        RoundTripMatrix app = new RoundTripMatrix();
        System.out.println(app.getRoundTripMatrix(5));
        int a=1;
    }
}
