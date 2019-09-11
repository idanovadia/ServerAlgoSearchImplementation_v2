package com.example.demo.model.search_algo;

import com.example.demo.model.ArrayFunc.AState;
import com.example.demo.model.ArrayFunc.Solution;

import java.util.List;

public interface ISearchAlgo {

    Solution solve();
    boolean hasSolve(AState current, AState end);
    String getName();
    String getNamerOfSteps();
    Solution createSol(List<AState> expansionGraph, AState current);
    boolean legalRoad(AState state);
}
