package com.example.demo.model.MazeAlgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * generate maze by Implementation Kruskal algorithem
 */


public class KruskalMaze extends AMazeGenerator{

    ArrayList<Position> walls;
    int row,col;
    int counterSet;
    int [][] setNumArray;


    public KruskalMaze(String [][] board) {
        maze = new Maze(board);
        walls = new ArrayList<Position>();
        initialize();
    }


    public KruskalMaze() {

    }

    public void initialize() {
        SetWallList();
        row = maze.getBoard().length;
        col = maze.getBoard()[0].length;
        setNumArray = new int[row][col];
        initSetNum();
    }

    private void initSetNum() {
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                setNumArray[i][j] = counterSet;
                counterSet++;
            }
        }
    }



    public Maze generate() {
        boolean first =true;
        while (walls.size()>0 || first) {
            first =false;
            int indexRnd = RandomCellGen(walls);
            Position p = walls.get(indexRnd);
            ArrayList<Position> neighbors = new ArrayList<Position>();
            neighbors = getNeighbors(neighbors,p);
            Set<Integer> diff = diffSet(neighbors);
            if(diff.size()==neighbors.size()){
                maze.getBoard()[p.getRowIndex()][p.getColIndex()] = "0";
                updateBord(diff,p);
            }
            neighbors.clear();
            walls.remove(indexRnd);
        }
        return maze;
    }

    private void updateBord(Set<Integer> diff, Position p) {
        for (int i = 0; i <setNumArray.length ; i++) {
            for (int j = 0; j < setNumArray[0].length; j++) {
                if(diff.contains(setNumArray[i][j]) && maze.getBoard()[i][j].equals("0"))
                    setNumArray[i][j]=setNumArray[p.getRowIndex()][p.getColIndex()];
            }
        }
    }

    private Set<Integer> diffSet(ArrayList<Position> neighbors) {
        Set<Integer> set = new HashSet<Integer>();
        for (Position tmp:neighbors){
            set.add(setNumArray[tmp.getRowIndex()][tmp.getColIndex()]);
        }
        return set;
    }

    public ArrayList<Position> getNeighbors(ArrayList<Position> neighbors, Position p) {
        int rowIndex = p.getRowIndex();
        int colIndex = p.getColIndex();
        AddNeighbor(neighbors, rowIndex+1, colIndex);
        AddNeighbor(neighbors, rowIndex-1, colIndex);
        AddNeighbor(neighbors, rowIndex, colIndex+1);
        AddNeighbor(neighbors, rowIndex, colIndex-1);
        return neighbors;
    }

    private void AddNeighbor(ArrayList<Position> neighbors, int rowIndex, int colIndex) {
        if(validPositionInBOard(rowIndex,colIndex))
            neighbors.add(new Position(rowIndex,colIndex));
    }

    private boolean validPositionInBOard(int rowIndex, int colIndex) {
        return rowIndex >= 0 && rowIndex < maze.getBoard().length && colIndex >= 0 && colIndex < maze.getBoard()[0].length;
    }

    private int RandomCellGen(ArrayList<Position> tmp) {
        return (new Random().nextInt(tmp.size()));
    }

    private void SetWallList(){
        for (int i = 0; i <maze.getBoard().length ; i++) {
            for (int j = 0; j <maze.getBoard()[0].length ; j++) {
                HashSet<Position> set = new HashSet<Position>();
                walls.add(new Position(i,j));
            }
        }
    }




    }

