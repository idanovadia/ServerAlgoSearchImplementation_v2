package com.example.demo.model.ArrayFunc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private List<AState> expansionGraph;
    private List<AState> sol;

    public Solution(List<AState> expansionGraph) {
        this.expansionGraph = expansionGraph;
        sol = new ArrayList<AState>();
    }

    public void generateSol(AState state){
        while (state.getFather()!=null){
            sol.add(sol.size(),state);
            state = state.getFather();
        }
        sol.add(sol.size(),state);
        Collections.reverse(sol);
    }

    public List<AState> getExpansionGraph() {
        return expansionGraph;
    }

    public void setExpansionGraph(List<AState> expansionGraph) {
        this.expansionGraph = expansionGraph;
    }

    public List<AState> getSol() {
        return sol;
    }

    public void setSol(List<AState> sol) {
        this.sol = sol;
    }

}
