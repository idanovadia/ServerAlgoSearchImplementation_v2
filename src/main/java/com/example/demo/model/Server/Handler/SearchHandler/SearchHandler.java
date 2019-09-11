package com.example.demo.model.Server.Handler.SearchHandler;

import com.example.demo.model.ArrayFunc.AState;
import com.example.demo.model.ArrayFunc.ArrayToJson;
import com.example.demo.model.ArrayFunc.Params;
import com.example.demo.model.ArrayFunc.Solution;
import com.example.demo.model.Server.Handler.MainHandler;
import org.json.JSONObject;

public abstract class SearchHandler extends MainHandler {
    protected Params params;
    AState start,end;
    int row,col;


    public abstract Solution findSol();

    public String jsonQuery(String query){
        JSONObject jsonObject = new JSONObject(query);
        return generateMazeType(jsonObject).toString();
    }

    public JSONObject generateMazeType(JSONObject jsonObject) {
        initialize(jsonObject);
        ArrayToJson arrayToJson = new ArrayToJson();
        params = new Params(start,end,arrayToJson.JsonToArray(row,col,jsonObject));
        return arrayToJson.SolToJson(findSol());

    }

    private void initialize(JSONObject positions){

        start = new AState(positions.getJSONObject("start").getString("x"),positions.getJSONObject("start").getString("y"),"0");
        end = new AState(positions.getJSONObject("end").getString("x"),positions.getJSONObject("end").getString("y"),"0");
        row = positions.getInt("row");
        col = positions.getInt("col");
    }




}
