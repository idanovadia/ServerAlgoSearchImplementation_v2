package com.example.demo.model.Server.Handler.MazeHandler;

import com.example.demo.model.MazeAlgo.PrimMaze;
import org.json.JSONObject;

public class PrimHandler extends MazeHandler {

    @Override
    public String[][] generateMazeType(JSONObject jsonObject) {
        PrimMaze primMaze = new PrimMaze(new String[Integer.parseInt(jsonObject.get("row").toString())][Integer.parseInt(jsonObject.get("col").toString())]);
        primMaze.generate();
        return primMaze.getMaze().getBoard();
    }

}
