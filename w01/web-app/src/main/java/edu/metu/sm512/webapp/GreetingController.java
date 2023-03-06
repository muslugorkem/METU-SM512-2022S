/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.sm512.webapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Serkan
 */
@RestController
public class GreetingController {
    
    @GetMapping("/greeting")
    public String sayHello(){
        return "hello ";
    }
    
    @GetMapping("/greeting/{name}")
    public ResponseEntity<String> sayHelloTo(@PathVariable String name){
        if (name.startsWith("-")) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok("hello " + name);
    }
    
}
