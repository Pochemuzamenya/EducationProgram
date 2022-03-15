package controllers;

import model.LearningProfile;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repositories.LearningProfileRepository;
import services.LearningProfileService;

import java.util.List;

@Controller
@RequestMapping(value = "/learning_profiles")
public class LearningProfileController {
    @Autowired
    LearningProfileRepository repository;
    @Autowired
    LearningProfileService service;
    @GetMapping(produces = "application/json")
    public @ResponseBody
    List<LearningProfile> findAll(Model model){
        List<LearningProfile> learningProfiles = service.findAll();
        model.addAttribute("learning_profiles", learningProfiles);
        return learningProfiles;
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody
    LearningProfile findById(@PathVariable("id") int id, Model model){
        LearningProfile learningProfile = service.findById(id);
        System.out.println(learningProfile);
        model.addAttribute("learning_profile", learningProfile);
        return learningProfile;
    }
    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody LearningProfile create(@RequestBody LearningProfile learning_profile){
        service.save(learning_profile);
        return learning_profile;
    }
}
