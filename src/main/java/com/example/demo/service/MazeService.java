package com.example.demo.service;


import com.example.demo.model.Server.Handler.MazeHandler.KruskalHandler;
import com.example.demo.model.Server.Handler.MazeHandler.PrimHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Using as maze generate algorithm's services
 * send the application to gene maze to specific handler that handle it
 */


@Service
public class MazeService {



    @Autowired
    public MazeService() {

    }

    public String genPrimMaze(String obj) {
        PrimHandler handler = new PrimHandler();
        return handler.jsonQuery(obj);

    }

    public String genKruskalMaze(String obj) {
        KruskalHandler handler = new KruskalHandler();
        return handler.jsonQuery(obj);
    }
}
