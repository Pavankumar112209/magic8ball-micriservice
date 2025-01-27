package com.magic8ball.magic8ball.Contollers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {
    @GetMapping("/home")
    public static String home(){
        return "hello world";
}
}
