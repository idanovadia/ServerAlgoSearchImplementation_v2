package com.example.demo.model.Server.Handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public abstract class MainHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
//        // parse request
//        he.getResponseHeaders().add("Access-Control-Allow-Origin","*");
//        he.getResponseHeaders().add("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization");
//        he.getResponseHeaders().add("Access-Control-Allow-Methods","PUT, POST, GET,PATCH, DELETE");
//        InputStreamReader isr = new InputStreamReader(he.getRequestBody(), "utf-8");
//        BufferedReader br = new BufferedReader(isr);
//        String query = br.readLine();
//        String response = jsonQuery(query);
//        he.sendResponseHeaders(200, response.length());
//        OutputStream os = he.getResponseBody();
//        os.write(response.toString().getBytes());
//        os.close();
    }

    public abstract String jsonQuery(String query);
}
