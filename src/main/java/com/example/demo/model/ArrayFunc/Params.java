package com.example.demo.model.ArrayFunc;
import org.json.JSONObject;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Params for doing Search
 * board to search on it
 * start and end - from where to where
 * weight [][] if some point in the array are diff in the weight
 */

public class Params {

    private JSONObject positions;
    private AState[][] board;
    private AState start ;
    private AState end;
    private ArrayList<AState> neighbors;
    private String [][] boardS;
    int [][] weight;


    public Params (AState start,AState end , String [][] board) {
//        this.positions = positions;
        boardS = board;
        this.start = start;
        this.end = end;
        this.board = new AState[board.length][board[0].length];
        //initialize();
        AStateArray();
    }

    public Params (AState start,AState end , String [][] board,int [][] weight) {
//        this.positions = positions;
        boardS = board;
        this.start = start;
        this.end = end;
        this.board = new AState[board.length][board[0].length];
        this.weight = weight;
        //initialize();
        AStateArrayWeight();
    }


    /**
     * set the board as AState board
     */
    private void AStateArray() {
        for (int i = 0; i <boardS.length ; i++) {
            for (int j = 0; j <boardS[0].length ; j++) {
                board[i][j] = new AState(""+i,""+j,boardS[i][j]);
            }
        }
    }


    private void AStateArrayWeight() {
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                board[i][j] = new AState(""+i,""+j,boardS[i][j],weight[i][j]);
            }
        }
    }

    /**
     * check all the possible neighbors of a State
     * up , down , right , left
     * @param state
     * @return list of neighbors
     */
    public ArrayList<AState> getAllPossibleStates(AState state){
        neighbors = new ArrayList<AState>();
        int x = parseInt(state.getX());
        int y = parseInt(state.getY());
        checkPossibleNeighbors(x+1,y);
        checkPossibleNeighbors(x-1,y);
        checkPossibleNeighbors(x,y+1);
        checkPossibleNeighbors(x,y-1);
        return neighbors;
    }

    /**
     * check etch neighbor if it legal
     * mean if it in the board
     * @param x
     * @param y
     */
    private void checkPossibleNeighbors(int x,int y) {
        if(x>=0 && x <board.length && y>=0 && y<board[0].length){
            neighbors.add(board[x][y]);
//            neighbors.add(new AState(String.valueOf(x),String.valueOf(y),boardS[x][y]));
        }
    }

    public JSONObject getPositions() {
        return positions;
    }

    public void setPositions(JSONObject positions) {
        this.positions = positions;
    }

    public AState[][] getBoard() {
        return board;
    }

    public void setBoard(AState[][] board) {
        this.board = board;
    }

    public AState getStart() {
        return start;
    }

    public void setStart(AState start) {
        this.start = start;
    }

    public AState getEnd() {
        return end;
    }

    public void setEnd(AState end) {
        this.end = end;
    }
}
