package com.example.demo.model.search_algo;

import com.example.demo.model.ArrayFunc.AState;
import com.example.demo.model.ArrayFunc.Params;
import com.example.demo.model.ArrayFunc.Solution;

import java.util.Stack;

public class DepthFirstSearch extends ASearchAlgo {


    AState begin;
    AState end;
    Stack<AState> stack;
    public DepthFirstSearch(Params board) {

        stack = new Stack<AState>();
        super.board = board;
        begin  = board.getStart();
        end = board.getEnd();
    }

    public DepthFirstSearch() {

    }

    public Solution solve() {
        stack.push(begin);
        AState current = begin;
        hasCheck.add(current);
        while(!stack.isEmpty() && !hasSolve(current,end)){
            current = stack.pop();
            numberOfSteps++;
            neighbors = board.getAllPossibleStates(current);
            for (AState newNeighbor:neighbors) {
                if(legalRoad(newNeighbor)){
                    newNeighbor.setFather(current);
                    stack.push(newNeighbor);
                    expansionGraph.add(newNeighbor);
                    if(hasSolve(newNeighbor,end)) {
                        return createSol(expansionGraph,newNeighbor);
                    }
                }
                hasCheck.add(newNeighbor);
            }
            neighbors.clear();
        }
        return createSol(expansionGraph,begin);
    }

    public String getName() {
        return "DepthFirstSearch";
    }

}
