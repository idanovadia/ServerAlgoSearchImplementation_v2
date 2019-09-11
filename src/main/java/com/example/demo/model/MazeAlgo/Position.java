package com.example.demo.model.MazeAlgo;


public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "{" + row + "," + col + "}";
    }

    public int getRowIndex(){
        return row;
    }

    public  int getColIndex(){
        return col;
    }

    /**
     * Equals Positions
     * @param o - to Equals
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row &&
                col == position.col;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
