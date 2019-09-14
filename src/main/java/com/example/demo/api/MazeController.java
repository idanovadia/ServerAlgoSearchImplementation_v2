package com.example.demo.api;


import com.example.demo.service.MazeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *  This class is the controller to maze generate algorithem
 *  for creating maze by kind of algo using the specific call func
 *  those functions are the functions that present the API
 */



@CrossOrigin("*")
@RequestMapping("/getMaze")
@RestController
public class MazeController {
    private final MazeService mazeService;

    @Autowired
    public MazeController(MazeService mazeService) {
        this.mazeService = mazeService;
    }
    @RequestMapping("/prim")
    @PostMapping
    public @ResponseBody String genPrimMaze(@RequestBody String obj){
        return mazeService.genPrimMaze(obj);
    }

    @RequestMapping("/kruskal")
    @PostMapping
    public String genKruskalMaze(@RequestBody String obj){
        return mazeService.genKruskalMaze(obj);
    }

}
