package com.example.demo.model.Server.Handler.MazeHandler;


import com.example.demo.model.ArrayFunc.ArrayToJson;
import com.example.demo.model.Server.Handler.MainHandler;
import org.json.JSONObject;

public abstract class MazeHandler extends MainHandler {

      public abstract String[][] generateMazeType(JSONObject jsonObject);

      public String jsonQuery(String query){
          JSONObject jsonObject = new JSONObject(query);
          ArrayToJson arrayToJson = new ArrayToJson();
          JSONObject jsonObjectMaze = arrayToJson.generateJsonArray(this.generateMazeType(jsonObject));
          // send response
          return jsonObjectMaze.toString();
      }
}
