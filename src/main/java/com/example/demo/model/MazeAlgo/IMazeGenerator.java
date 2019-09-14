package com.example.demo.model.MazeAlgo;

/**
 * what functions need to create maze generator
 */

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

