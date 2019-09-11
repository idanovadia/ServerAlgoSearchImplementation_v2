package com.example.demo.model.search_algo;

import com.example.demo.model.ArrayFunc.AState;
import com.example.demo.model.ArrayFunc.Params;
import com.example.demo.model.ArrayFunc.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class ASearchAlgo implements ISearchAlgo{

    int numberOfSteps = 0;
    Params board;
    ArrayList<AState> neighbors;
    HashSet<AState> hasCheck = new HashSet<AState>();
    List<AState> expansionGraph = new ArrayList<AState>();

    
    public abstract Solution solve();
    
    public boolean hasSolve(AState current, AState end) {
        return current.equals(end);
    }
    
    public Solution createSol(List<AState> expansionGraph, AState current){
        Solution solution = new Solution(expansionGraph);
        solution.generateSol(current);
        return solution;
    }

    public abstract String getName();
    
    public String getNamerOfSteps(){
        return ""+numberOfSteps;
    }
    public boolean legalRoad(AState state){
        if(!hasCheck.contains(state) && !state.getContent().equals("1")){
            return true;
        }
        return false;

    }

}
