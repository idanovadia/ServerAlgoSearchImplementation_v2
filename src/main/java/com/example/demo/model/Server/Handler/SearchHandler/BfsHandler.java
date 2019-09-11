package com.example.demo.model.Server.Handler.SearchHandler;


import com.example.demo.model.ArrayFunc.Solution;
import com.example.demo.model.search_algo.BreadthFirstSearch;

public class BfsHandler extends SearchHandler {

    @Override
    public Solution findSol() {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(params);
        return breadthFirstSearch.solve();
    }
}
