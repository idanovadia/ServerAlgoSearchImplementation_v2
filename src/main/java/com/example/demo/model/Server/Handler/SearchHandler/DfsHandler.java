package com.example.demo.model.Server.Handler.SearchHandler;


import com.example.demo.model.ArrayFunc.Solution;
import com.example.demo.model.search_algo.DepthFirstSearch;

public class DfsHandler extends SearchHandler {

    @Override
    public Solution findSol() {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(params);
        return depthFirstSearch.solve();
    }
}
