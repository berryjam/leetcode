package com.berryjam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// BFS或DFS，重点复习，时间超了 http://blog.csdn.net/ljiabin/article/details/44975717

/**
 * @author huangjinkun.
 * @date 16/3/23
 * @time 下午6:41
 */
public class NumberOfIslands {

    private int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') continue;

                ans++;
                dfs(grid, i, j);
            }
        }
        return ans;
    }


    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;

        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }

//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//
//        Stack<Point> stack = new Stack<Point>();
//        boolean[][] hasProcessGrid = new boolean[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            hasProcessGrid[i] = new boolean[grid[i].length];
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == '1') {
//                    stack.push(new Point(i, j));
//                }
//            }
//        }
//
//        int result = 0;
//
//        Point point = findNextIslandBeginning(stack, hasProcessGrid);
//
//        while (point != null) {
//            result++;
//            searchIsland(grid, hasProcessGrid, point);
//            point = findNextIslandBeginning(stack, hasProcessGrid);
//        }
//
//        return result;
//    }
//
//    private void searchIsland(char[][] grid, boolean[][] hasProcessGrid, Point point) {
//        Queue<Point> queue = new LinkedList<Point>();
//        queue.offer(point);
//        while (!queue.isEmpty()) {
//            Point cur = queue.poll();
//            int x = cur.x;
//            int y = cur.y;
//            if (x - 1 >= 0) { // above grid
//                if (grid[x - 1][y] == '1' && !hasProcessGrid[x - 1][y]) {
//                    queue.offer(new Point(x - 1, y));
//                }
//            }
//            if (y - 1 >= 0) { // left grid
//                if (grid[x][y - 1] == '1' && !hasProcessGrid[x][y - 1]) {
//                    queue.offer(new Point(x, y - 1));
//                }
//            }
//            if (x + 1 < grid.length) { // below grid
//                if (grid[x + 1][y] == '1' && !hasProcessGrid[x + 1][y]) {
//                    queue.offer(new Point(x + 1, y));
//                }
//            }
//            if (y + 1 < grid[x].length) { // right grid
//                if (grid[x][y + 1] == '1' && !hasProcessGrid[x][y + 1]) {
//                    queue.offer(new Point(x, y + 1));
//                }
//            }
//
//            hasProcessGrid[x][y] = true;
//        }
//    }
//
//    private Point findNextIslandBeginning(Stack<Point> stack, boolean[][] hasprocessgrid) {
//        while (!stack.isEmpty()) {
//            Point cur = stack.pop();
//            if (cur != null && !hasprocessgrid[cur.x][cur.y]) {
//                return cur;
//            }
//        }
//
//        return null;
//    }
//
//    class Point {
//        int x;
//        int y;
//
//        Point() {
//
//        }
//
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();
        System.out.println(islands.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
        System.out.println(islands.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}));
    }
}
