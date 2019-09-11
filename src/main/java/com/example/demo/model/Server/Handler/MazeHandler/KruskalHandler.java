package com.example.demo.model.Server.Handler.MazeHandler;


import com.example.demo.model.MazeAlgo.KruskalMaze;
import org.json.JSONObject;

public class KruskalHandler extends MazeHandler {

    @Override
    public String[][] generateMazeType(JSONObject jsonObject) {
        KruskalMaze kruskalMaze = new KruskalMaze(new String[Integer.parseInt(jsonObject.get("row").toString())][Integer.parseInt(jsonObject.get("col").toString())]);
        kruskalMaze.generate();
        return kruskalMaze.getMaze().getBoard();
    }

}
