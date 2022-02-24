package controllers;

import model.LearningProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
}
