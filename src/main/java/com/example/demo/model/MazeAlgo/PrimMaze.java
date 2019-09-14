package com.example.demo.model.MazeAlgo;

import java.util.ArrayList;
import java.util.Random;


/**
 * generate maze by Implementation Prim algorithem
 */


public class PrimMaze extends AMazeGenerator {

    public PrimMaze(String [][] board) {
        this.maze = new Maze(board);
    }

    public PrimMaze() {

    }

    /**
     * @return maze
     * <p>
     * by Prim alg
     */
    @Override
    public Maze generate() {

        int row = maze.getBoard().length;
        int col = maze.getBoard()[0].length;
        if (row <4 || col <4) {
            System.out.println("ROW AND COL MUST BE BIGGER THEN 3: DEF MAZE");
            return null;
        }
        //visited array
        boolean[][] wasHere = new boolean[row][col];
        //list of Neighbors to put them walls by conditions
        ArrayList<Position> walls = new ArrayList<Position>();
        //init the start position
        Position start = maze.getStartPosition();
        maze.getBoard()[start.getRowIndex()][start.getColIndex()] = "0";
        wasHere[start.getRowIndex()][start.getColIndex()] = true;
        // init Neighbors to the list and update visited places
        walls = Neighbors(start, walls, wasHere, row, col, maze);
        while (!walls.isEmpty()) {
            //choose randomly a Neighbor from the list
            Position neighbor = walls.get(new Random().nextInt(walls.size()));
            wasHere[neighbor.getRowIndex()][neighbor.getColIndex()] = true;
            //can put there 0 by "justOneVisitid" condition
            if (justOneVisitid(maze, neighbor, col, row)) {
                maze.getBoard()[neighbor.getRowIndex()][neighbor.getColIndex()] = "0";
                //add the new Neighbors to the list - the Neighbors of the "Position neighbor" that has random
                walls = Neighbors(neighbor, walls, wasHere, row, col, maze);
            }
            //remove from the list the "Position neighbor" that has random
            walls.remove(neighbor);
        }
        return maze;
    }




    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}

