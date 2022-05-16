package controllers;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.*;
import java.sql.Timestamp;
import java.util.List;

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
    VersionService versionService;
    @Autowired
    DegreeService degreeService;
    @Autowired
    StudyFormService studyFormService;

    @GetMapping(produces = "application/json")
    public
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
    public
    Program findById(@PathVariable("id") int id){
        Program program = programService.findById(id);
        return program;
    }

    @GetMapping(value = "/new", produces = "application/json")
    public NewProgramJSON addProgram(){
        NewProgramJSON json = new NewProgramJSON();
        json.setSubjects(subjectService.findAll());
        json.setSpecialties(specialtyService.findAll());
        json.setLearning_profiles(learningProfileService.findAll());
        json.setChairs(chairService.findAll());
        json.setDegrees(degreeService.findAll());
        json.setStudyForms(studyFormService.findAll());
        return json;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Program create(@RequestBody Program program){
        System.out.println(program);
        Version version = new Version();
        version.setCreation_date(new Timestamp(System.currentTimeMillis()));
        version.setLast_edit(new Timestamp(System.currentTimeMillis()));
        versionService.save(version);
        program.setVersion(version);
        programService.save(program);
        return program;
    }
    @PutMapping(value = "/{id}",produces = "application/json", consumes = "application/json")
    public Program update(@PathVariable("id") int id, @RequestBody Program program){
        Program programToUpdate = programService.findById(id);
/*        System.out.println("Anything");
        System.out.println(program);
        Timestamp creationDate = programToUpdate.getVersion().getCreation_date();

        programToUpdate= new Program(program);
        programToUpdate.setId(id);
        programToUpdate.getVersion.setCreation_date(creationDate);
        programToUpdate.getVersion.setLast_edit(new Timestamp(System.currentTimeMillis()));
        */
        programToUpdate.copyParameters(program);
        versionService.save(programToUpdate.getVersion());
        programService.save(programToUpdate);
        //return null;
        return programToUpdate;
    }
    @DeleteMapping(value = "/{id}",produces = "application/json", consumes = "application/json")
    public void delete(@PathVariable("id") int id){
        Program program = programService.findById(id);
        programService.delete(program);
    }

}
