package com.example.demo.model.MazeAlgo;

public interface IMazeGenerator {

    /**
     * create a maze by algo
     */
    Maze generate();



    /**
     * measure time of creation maze
     */
    long measureAlgorithmTimeMillis(int row, int col);
}

