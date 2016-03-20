package com.berryjam;

// 重点复习回归，时间复杂度超了 http://blog.csdn.net/ljiabin/article/details/45846837

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangjinkun.
 * @date 16/3/18
 * @time 上午9:56
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> posts = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            posts.add(new ArrayList<Integer>());
        }

        int[] preNums = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
            preNums[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (preNums[i] == 0){
                queue.offer(i);
            }
        }

        int count = numCourses;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : posts.get(cur)) {
                if (--preNums[i] == 0) {
                    queue.offer(i);
                }
            }
            count--;
        }

        return count == 0;
    }

//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[][] matrices = getAdjacencyMatrices(numCourses, prerequisites);
//
//        int courses = 0;
//        boolean canFinish = false;
//        boolean isOver = false;
//        while (!isOver) {
//            boolean allDegreeZero = true;
//            for (int i = 0; i < matrices.length; i++) {
//                boolean inDegreeZero = true;
//                for (int j = 0; j < matrices[i].length; j++) {
//                    if (j != i) {
//                        if (matrices[j][i] != 0) {
//                            inDegreeZero = false;
//                            allDegreeZero = false;
//                            break;
//                        }
//                    }
//                }
//                if (inDegreeZero) { // 顶点i的入度为0
//                    courses++;
//                    if (courses == numCourses) {
//                        return true;
//                    } else {
//                        for (int j = 0; j < matrices[i].length; j++) {
//                            matrices[i][j] = 0;
//                        }
//                    }
//                }
//            }
//            if (!allDegreeZero) {
//                isOver = true;
//            }
//        }
//
//        return canFinish;
//    }
//
//    private int[][] getAdjacencyMatrices(int numCourses, int[][] prerequisites) {
//        int[][] matrices = new int[numCourses][numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            matrices[i] = new int[numCourses];
//        }
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            for (int j = 0; j <= 0; j++) {
//                matrices[prerequisites[i][1]][prerequisites[i][0]] = 1;
//            }
//        }
//
//        return matrices;
//    }
}
