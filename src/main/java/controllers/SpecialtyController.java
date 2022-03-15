package controllers;

import model.Program;
import model.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repositories.SpecialtyRepository;
import services.SpecialtyService;

import java.util.List;

@Controller
@RequestMapping("/specialties")
public class SpecialtyController {
    @Autowired
    SpecialtyRepository repository;
    @Autowired
    SpecialtyService service;
    @GetMapping(produces = "application/json")
    public @ResponseBody
    List<Specialty> findAll(Model model){
        List<Specialty> specialties = service.findAll();
        model.addAttribute("specialties", specialties);
        return specialties;
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody
    Specialty findById(@PathVariable("id") int id, Model model){
        Specialty specialty = service.findById(id);
        System.out.println(specialty);
        model.addAttribute("subject", specialty);
        return specialty;
    }
    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody Specialty create(@RequestBody Specialty specialty){
        service.save(specialty);
        return specialty;
    }
}
