package com.example.demo.model.search_algo;

import com.example.demo.model.ArrayFunc.AState;
import com.example.demo.model.ArrayFunc.Params;
import com.example.demo.model.ArrayFunc.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchAlgo {

    AState begin;
    AState end;
    Queue<AState> queue;
    public BreadthFirstSearch(Params board)
    {
        queue = new LinkedList<AState>();
        super.board = board;
        begin  = board.getStart();
        end = board.getEnd();
    }

    public BreadthFirstSearch() {

    }


    public Solution solve() {

        queue.add(begin);
        AState current = begin;
        hasCheck.add(current);
        while(!queue.isEmpty() && !hasSolve(current,end)){
            current = queue.remove();
            numberOfSteps++;
            neighbors = board.getAllPossibleStates(current);
            for (AState newNeighbor:neighbors) {
                if(legalRoad(newNeighbor)){
                    newNeighbor.setFather(current);
                    queue.add(newNeighbor);
                    expansionGraph.add(newNeighbor);
                    if(hasSolve(newNeighbor,end)) {
                        return createSol(expansionGraph,newNeighbor);
                    }
                }
                hasCheck.add(newNeighbor);
            }
            neighbors.clear();
        }
        return null;
    }

    public String getName() {
        return "BreadthFirstSearch";
    }

}
