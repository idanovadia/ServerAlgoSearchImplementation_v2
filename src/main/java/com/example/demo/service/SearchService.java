package com.example.demo.service;

import com.example.demo.model.Server.Handler.SearchHandler.AStarHandler;
import com.example.demo.model.Server.Handler.SearchHandler.BfsHandler;
import com.example.demo.model.Server.Handler.SearchHandler.DfsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    
    
    @Autowired
    public SearchService() {
        
    }


    public String solveAstar(String obj) {
        AStarHandler aStarHandler = new AStarHandler();
        return aStarHandler.jsonQuery(obj);
    }

    public String solveBfs(String obj) {
        BfsHandler bfsHandler = new BfsHandler();
        return bfsHandler.jsonQuery(obj);
    }

    public String solveDfs(String obj) {
        DfsHandler dfsHandler = new DfsHandler();
        return dfsHandler.jsonQuery(obj);
    }
}
