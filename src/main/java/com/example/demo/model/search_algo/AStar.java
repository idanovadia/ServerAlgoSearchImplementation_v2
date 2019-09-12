package com.example.demo.model.search_algo;

import com.example.demo.model.ArrayFunc.AState;
import com.example.demo.model.ArrayFunc.Params;
import com.example.demo.model.ArrayFunc.Solution;

import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

public class AStar extends ASearchAlgo {


    AState begin;
    AState end;
    PriorityQueue<AState> queue;
    public AStar(Params board) {
        this.queue = new PriorityQueue<AState>();
        super.board =board;
        begin  = board.getStart();
        end = board.getEnd();
    }

    public AStar() {

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
                    newNeighbor.setDistance(ManhetenDistance(current,end));
                    newNeighbor.setSumDis(newNeighbor.getDistance()+newNeighbor.getWeight());
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
        return createSol(expansionGraph,begin);
    }


    public String getName() {
        return "A*";
    }

    private double ManhetenDistance(AState a, AState b){
        return Math.pow((parseInt(a.getX())-parseInt(b.getX())),2)+Math.pow((parseInt(a.getY())-parseInt(b.getY())),2);
    }


}
