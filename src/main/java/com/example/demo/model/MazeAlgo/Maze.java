package com.example.demo.model.MazeAlgo;

import java.util.Random;

public class Maze {

    private String [][] board;

    public Maze(String[][] maze) {
        this.board = maze;
        initMaze();
    }

    public String[][] initMaze(){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                board[i][j] = ("1");
            }
        }
        return  board;
    }


    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public Position getStartPosition() {
        Random rnd = new Random();
        return new Position(rnd.nextInt(board.length), rnd.nextInt(board[0].length));
    }

    @Override
    public String toString() {
        String s ="[\n";
        for (int i = 0; i <this.getBoard().length ; i++) {
            s = s+" {";
            for (int j = 0; j <getBoard()[0].length ; j++) {
                s = s + " " + getBoard()[i][j]+",";
            }
            s = s + " }\n";
        }
        return s+"]";
    }

    public String value(Position p) {
        return board[p.getRowIndex()][p.getColIndex()];
    }
}
