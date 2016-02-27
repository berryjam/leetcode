package com.berryjam;


class GameOfLifeBoard {
    int currentState;
    int nextState;
}

/**
 * @author huangjinkun.
 * @date 16/2/27
 * @time 下午1:00
 */
public class GameOfLife {

    public static int LIVE = 1;
    public static int DEAD = 0;

    GameOfLifeBoard[][] gameOfLifeBoards;

    public void gameOfLife(int[][] board) {
        initialize(board);

        for (int i = 0; i < gameOfLifeBoards.length; i++) {
            for (int j = 0; j < gameOfLifeBoards[i].length; j++) {
                int liveNeighbour = 0;
                if (i - 1 >= 0 && j - 1 >= 0) {  // left up conrner
                    if (gameOfLifeBoards[i - 1][j - 1].currentState == LIVE) {
                        liveNeighbour++;
                    }
                }
                if (j - 1 >= 0) { // left
                    if (gameOfLifeBoards[i][j-1].currentState == LIVE) {
                        liveNeighbour++;
                    }
                }
                if (i +1 < gameOfLifeBoards.length && j - 1 >=0) { // left down conrner
                    if (gameOfLifeBoards[i + 1][j - 1].currentState == LIVE) {
                        liveNeighbour++;
                    }
                }
                if (i+1 < gameOfLifeBoards.length) { // down
                    if (gameOfLifeBoards[i+1][j].currentState == LIVE) {
                        liveNeighbour++;
                    }
                }
                if (i + 1 < gameOfLifeBoards.length && j + 1 < gameOfLifeBoards[i].length) { // right down
                    if (gameOfLifeBoards[i + 1][j + 1].currentState == LIVE) {
                        liveNeighbour++;
                    }
                }
                if (j + 1 < gameOfLifeBoards[i].length) { // right
                    if (gameOfLifeBoards[i][j + 1].currentState == LIVE) {
                        liveNeighbour++;
                    }
                }
                if (i - 1 >= 0 && j + 1 < gameOfLifeBoards[i].length) { // right up conrner
                    if (gameOfLifeBoards[i - 1][j + 1].currentState == LIVE) {
                        liveNeighbour++;
                    }
                }
                if (i - 1 >= 0) { // up
                    if (gameOfLifeBoards[i - 1][j].currentState == LIVE) {
                        liveNeighbour++;
                    }
                }

                switch (gameOfLifeBoards[i][j].currentState) {
                    case 1:
                        if (liveNeighbour < 2) { // Any live cell with fewer than two live neighbors dies, as if
                            // caused by under-population.
                            gameOfLifeBoards[i][j].nextState = DEAD;
                        } else if (liveNeighbour >= 2 && liveNeighbour <= 3) { // Any live cell with two or three
                            // live neighbors lives on to the next generation.
                            gameOfLifeBoards[i][j].nextState = LIVE;
                        } else if (liveNeighbour > 3) { // Any live cell with more than three live neighbors dies, as
                            // if by over-population.
                            gameOfLifeBoards[i][j].nextState = DEAD;
                        }
                        break;
                    case 0:
                        if (liveNeighbour == 3) { // Any dead cell with exactly three live neighbors becomes a live
                            // cell, as if by reproduction.
                            gameOfLifeBoards[i][j].nextState = LIVE;
                        }
                }


            }
        }


        for (int i = 0; i < gameOfLifeBoards.length; i++) {
            for (int j = 0; j < gameOfLifeBoards[i].length; j++) {
                board[i][j] = gameOfLifeBoards[i][j].nextState;
            }
        }
    }

    private void initialize(int[][] board) {
        gameOfLifeBoards = new GameOfLifeBoard[board.length][];

        for (int i = 0; i < board.length; i++) {
            gameOfLifeBoards[i] = new GameOfLifeBoard[board[i].length];
            for (int j = 0; j < board[i].length; j++) {
                gameOfLifeBoards[i][j] = new GameOfLifeBoard();
                gameOfLifeBoards[i][j].currentState = board[i][j];
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife life = new GameOfLife();
        int[][] board = new int[][]{{1,1}};
        life.gameOfLife(board);
    }
}
