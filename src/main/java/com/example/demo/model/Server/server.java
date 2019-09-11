package com.example.demo.model.Server;


import com.example.demo.model.Server.Handler.MazeHandler.PrimHandler;
import com.example.demo.model.Server.Handler.SearchHandler.AStarHandler;
import com.example.demo.model.Server.Handler.SearchHandler.BfsHandler;
import com.example.demo.model.Server.Handler.SearchHandler.DfsHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class server implements Runnable {



    public static void main(String[] args) {
        Runnable runnable  = new server();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void run() {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(3000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/getMaze/prim", new PrimHandler());
        server.createContext("/getMaze/kruskal", new PrimHandler());
        server.createContext("/solveMaze/AStar", new AStarHandler());
        server.createContext("/solveMaze/DFS", new DfsHandler());
        server.createContext("/solveMaze/BFS", new BfsHandler());
        server.setExecutor(null); // creates a default executor
        server.start();

    }


}



//    public static void main(String[] args) {
//        connectToServer();
//    }
//
//    public static void parse(ArrayList<String> in){
//        String[] method = in.get(0).split("/");
//        System.out.println("s");
//    }
//
//    public static void connectToServer() {
//        //Try connect to the server on an unused port eg 9991. A successful connection will return a socket
//        try(ServerSocket serverSocket = new ServerSocket(3000)) {
//            Socket connectionSocket = serverSocket.accept();
//
//            //Create Input&Outputstreams for the connection
//            InputStream inputToServer = connectionSocket.getInputStream();
//            OutputStream outputFromServer = connectionSocket.getOutputStream();
//
//            Scanner scanner = new Scanner(inputToServer, "UTF-8");
//            PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);
//
//            serverPrintOut.println("Hello World! Enter Peace to exit.");
//
//            //Have the server take input from the client and echo it back
//            //This should be placed in a loop that listens for a terminator text e.g. bye
//            boolean done = false;
//            ArrayList<String> in =new ArrayList<>();
//            while(!done && scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                serverPrintOut.println("Echo from <Your Name Here> Server: " + line);
//                in.add(line);
//                if(line.toLowerCase().trim().equals("peace")) {
//                    done = true;
//                }
//            }
//            parse(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

