package controllers;

import model.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.SetService;

import java.util.List;

@RestController
@RequestMapping(value = "/sets")
public class SetController {
    @Autowired
    SetService service;
    @GetMapping
    public List<Set> findAll(){
        return service.findAll();
    }
}
