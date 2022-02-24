package controllers;

import model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repositories.SubjectRepository;
import services.SubjectService;

import java.util.List;

@Controller
@RequestMapping(value = "/subjects")
public class SubjectController {
    @Autowired
    SubjectRepository repository;
    @Autowired
    SubjectService service;
    @GetMapping(produces = "application/json")
    public @ResponseBody
    List<Subject> findAll(Model model){
        List<Subject> subjects = service.findAll();
        model.addAttribute("subjects", subjects);
        return subjects;
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody
    Subject findById(@PathVariable("id") int id, Model model){
        Subject subject = service.findById(id);
        System.out.println(subject);
        model.addAttribute("subject", subject);
        return subject;
    }
    @GetMapping(value = "/new")
    public String addCourse(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "/subjects/new";
    }
    @PostMapping(value="")
    public String create(@ModelAttribute("subject") Subject subject, Model model){
        service.save(subject);
        return "redirect:/subjects";
    }
}
