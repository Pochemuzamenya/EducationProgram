package org.isu.rpd.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {


    @GetMapping(value = "/")
    public String sayHello(){
        return "home";
    }

}
