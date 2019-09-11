package com.example.demo.model.MazeAlgo;

import java.util.ArrayList;

public abstract class AMazeGenerator implements IMazeGenerator {
    Maze maze;

    public abstract Maze generate();


    public long measureAlgorithmTimeMillis(int row, int col) {
        long begin = System.currentTimeMillis();
//        generate();
        long end = System.currentTimeMillis();
        return end - begin ;
    }

    /**
     * @param was      - the list of Neighbors
     * @param position - the obj to search in the list
     * @return is there - True ,else False
     * <p>
     * running on the list and search if the obj is there
     */
    public boolean contain(boolean[][] was, Position position) {
        if (was[position.getRowIndex()][position.getColIndex()] == true)
            return true;
        return false;
    }


    /**
     * @param lastChoice - the last neighbor that had choosen
     * @param walls      - the list
     * @param row        - number of rows
     * @param col        - nnumber of cols
     * @param maze       - the maze
     * @return - maze
     * <p>
     * find the ligal neighbors by the alg
     * checking up,down,left,right
     */
    public ArrayList<Position> Neighbors(Position lastChoice, ArrayList<Position> walls, boolean[][] b, int row, int col, Maze maze) {

        int lastX = lastChoice.getRowIndex();
        int lastY = lastChoice.getColIndex();
        //up
        Position p = new Position(lastX + 1, lastY);
        //the Position in the maze ,not visited there and have path in this position.
        walls = CheckNeighbor(p, col, row, b, maze, walls);
        //down
        p = new Position(lastX - 1, lastY);
        walls = CheckNeighbor(p, col, row, b, maze, walls);
        //right
        p = new Position(lastX, lastY + 1);
        walls = CheckNeighbor(p, col, row, b, maze, walls);
        //left
        p = new Position(lastX, lastY - 1);
        walls = CheckNeighbor(p, col, row, b, maze, walls);
        return walls;
    }

    /**
     * @return if the Neighbor is legal then add is to list
     */
    private ArrayList<Position> CheckNeighbor(Position p, int col, int row, boolean[][] b, Maze maze, ArrayList<Position> walls) {
        if (inMazeN(p, col, row) && !contain(b, p) && !maze.value(p).equals("0")) {
            walls.add(p);
        }
        return walls;
    }


    /**
     * @param position
     * @param col
     * @param row
     * @return if in the maze and not in the frame of the maze
     */
    protected boolean inMazeN(Position position, int col, int row) {
        boolean rowPlace = position.getRowIndex() > 0 && position.getRowIndex() < row - 1;
        boolean colPlace = position.getColIndex() > 0 && position.getColIndex() < col - 1;
        if (rowPlace && colPlace) {
            return true;
        }
        return false;
    }


    /**
     * check if the Neighbor that has choosen can be part of the way(0)
     * the idea is to check that has a most one 0 Neighbor to the choosen Neighbor
     *
     * @param maze
     * @param position
     * @param col
     * @param row
     * @return
     */

    protected boolean justOneVisitid(Maze maze, Position position, int col, int row) {
        int lastX = position.getRowIndex();
        int lastY = position.getColIndex();
        int counter = 0;
        //check up
        Position p = new Position(lastX + 1, lastY);
        counter = CheckJustOneVisitid(p, col, row, maze, counter);
        //check down
        p = new Position(lastX - 1, lastY);
        counter = CheckJustOneVisitid(p, col, row, maze, counter);
        //check right
        p = new Position(lastX, lastY + 1);
        counter = CheckJustOneVisitid(p, col, row, maze, counter);
        //check left
        p = new Position(lastX, lastY - 1);
        counter = CheckJustOneVisitid(p, col, row, maze, counter);
        //more or less then one Neighbor
        if (counter > 1)
            return false;
        return true;
    }

    /**
     * @return the counter
     */
    private int CheckJustOneVisitid(Position p, int col, int row, Maze maze, int counter) {
        if (inMaze(p, col, row) && maze.value(p).equals("0")) {
            counter++;
        }
        return counter;
    }

    /**
     * in the boands of the maze
     *
     * @param position
     * @param col
     * @param row
     * @return bool
     */
    protected boolean inMaze(Position position, int col, int row) {
        boolean rowPlace = position.getRowIndex() >= 0 && position.getRowIndex() < row;
        boolean colPlace = position.getColIndex() >= 0 && position.getColIndex() < col;
        if (rowPlace && colPlace) {
            return true;
        }
        return false;
    }
    public Maze getMaze() {
        return maze;
    }

}
