package com.example.demo.model.ArrayFunc;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * This class manipulate json object to data structure and opposite.
 * the main use of it is get and send json object by the spring server
 *
 * Those functions maintain how the json objects need to get from and sent to the client .
 */

public class ArrayToJson {


    /**
     * use to build json object of board to send back to the client
     * @param array
     * @return
     */
    public JSONObject generateJsonArray(String[][] array){
        JSONArray ja = new JSONArray();
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[0].length ; j++) {
                JSONObject jo = new JSONObject();
                jo.put("x", i);
                jo.put("y", j);
                jo.put("content",array[i][j]);
                ja.put(jo);
            }
        }
        return new JSONObject().put("array",ja);
    }

    /**
     * use to build a board from json obj that get from the client
     * @param row
     * @param col
     * @param jsonObject
     * @return
     */
    public String [][] JsonToArray(int row , int col ,JSONObject jsonObject){
        JSONArray array = jsonObject.getJSONArray("array");
        String [][] tmp = new String[row][col];
        for (int i = 0; i < array.length(); i++) {
            int x = array.getJSONObject(i).getInt("x");
            int y = array.getJSONObject(i).getInt("y");
            String content = array.getJSONObject(i).getString("content");
            tmp[x][y] = content;
        }
        return tmp;
    }


    /**
     * make list of Astate to json
     *
     * @param list
     * @return
     */
    private JSONArray generateJsonList(List<AState> list){
        JSONArray ja = new JSONArray();
            for (int j = 0; j <list.size() ; j++) {
                JSONObject jo = new JSONObject();
                jo.put("x", list.get(j).getX());
                jo.put("y", list.get(j).getY());
                jo.put("content",list.get(j).getContent());
                ja.put(jo);
            }

        return ja;
    }

    /**
     * using to make the expansion and sol lists to json objects to send back to clint
     * @param solution
     * @return
     */
    public JSONObject SolToJson(Solution solution){
        JSONObject object = new JSONObject();
        object.put("expansionGraph",generateJsonList(solution.getExpansionGraph()));
        object.put("sol",generateJsonList(solution.getSol()));
        return object;
    }

}
