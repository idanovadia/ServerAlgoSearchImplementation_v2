package com.example.demo.model.Server.Handler.SearchHandler;


import com.example.demo.model.ArrayFunc.Solution;
import com.example.demo.model.search_algo.AStar;

public class AStarHandler extends SearchHandler {

    @Override
    public Solution findSol() {
        AStar aStar = new AStar(params);
        return aStar.solve();
    }
}
