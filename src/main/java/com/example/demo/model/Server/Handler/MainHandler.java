package com.example.demo.model.Server.Handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public abstract class MainHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {

    }

    public abstract String jsonQuery(String query);
}
