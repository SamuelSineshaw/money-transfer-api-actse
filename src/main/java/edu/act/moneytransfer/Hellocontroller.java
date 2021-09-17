package edu.act.moneytransfer;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class Hellocontroller {
    @GetMapping("/")
    public String sayhello(){
        return "Hello all ACT community";
    }

    @GetMapping("/{name}")
    public String sayhello(@PathVariable String name){
        return "Hello"+ name +"!";
    }
}
