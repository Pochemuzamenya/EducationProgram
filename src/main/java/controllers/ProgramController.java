package controllers;

import model.*;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@Controller
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
    VersionService versionService;

    @GetMapping(produces = "application/json")
    public @ResponseBody
    ResponseJSON findAll(){
        Filter filters = new Filter();
        List<String> subjects = programService.findSubjectNames();
        List<String> chairs = programService.findChairNames();
        List<Integer> years = programService.findYears();
        List<String> specialties = programService.findSpecialtyNames();
        List<String> degrees = programService.findDegrees();
        filters.setChair(chairs);
        filters.setDegree(degrees);
        filters.setSpecialty(specialties);
        filters.setYear(years);
        filters.setSubject(subjects);
        List<Program> programs = programService.findAll();
        ResponseJSON response = new ResponseJSON(programs, filters);
        return response;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody
    Program findById(@PathVariable("id") int id){
        Program program = programService.findById(id);
        return program;
    }

    @GetMapping(value = "/new", produces = "application/json")
    public @ResponseBody NewProgramJSON addProgram(){
        NewProgramJSON json = new NewProgramJSON();
        json.setSubjects(subjectService.findAll());
        json.setSpecialties(specialtyService.findAll());
        json.setLearning_profiles(learningProfileService.findAll());
        json.setChairs(chairService.findAll());
        return json;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody Program create(@RequestBody Program program){
        Version version = new Version();
        version.setCreation_date(new Timestamp(System.currentTimeMillis()));
        version.setLast_edit(new Timestamp(System.currentTimeMillis()));
        /*if(program.getSubject().getId()==null){
            Subject subject = new Subject();
            subject.setName(program.getSubject().getName());
            subjectService.save(subject);
            program.setSubject(subject);
        }*/
        versionService.save(version);
        program.setVersion(version);
        programService.save(program);
        return program;
    }
    @PutMapping(value = "/{id}",produces = "application/json", consumes = "application/json")
    public @ResponseBody Program update(@PathVariable("id") int id, @RequestBody Program program){
        Program programToUpdate = programService.findById(id);
        programToUpdate.copyParameters(program);
        versionService.save(programToUpdate.getVersion());
        programService.save(programToUpdate);
        return programToUpdate;
    }

}
