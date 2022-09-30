package org.isu.rpd.controllers;

import org.isu.rpd.model.NewProgramJSON;
import org.isu.rpd.model.Program;
import org.isu.rpd.model.ResponseJSON;
import org.isu.rpd.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/programs")
public class ProgramController {


    @Autowired
    ProgramService programService;
    @Autowired
    ChairService chairService;
    @Autowired
    SpecialtyService specialtyService;
    @Autowired
    LearningProfileService learningProfileService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    DegreeService degreeService;
    @Autowired
    StudyFormService studyFormService;

    @GetMapping(produces = "application/json")
    public ResponseJSON findAll(){
        ResponseJSON response = programService.findAll();
        return response;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Program findById(@PathVariable("id") int id){
        Program program = programService.findById(id);
        return program;
    }

    @GetMapping(value = "/new", produces = "application/json")
    public NewProgramJSON addProgram(){
        NewProgramJSON json = programService.addProgram();
        return json;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Program create(@RequestBody Program program){
        programService.save(program);
        return program;
    }

    @PutMapping(value = "/{id}",produces = "application/json", consumes = "application/json")
    public Program update(@PathVariable("id") int id, @RequestBody Program program){
        programService.update(program,id);
        return findById(id);
    }

    @DeleteMapping(value = "/{id}",produces = "application/json", consumes = "application/json")
    public void delete(@PathVariable("id") int id){
        programService.delete(id);
    }

}
