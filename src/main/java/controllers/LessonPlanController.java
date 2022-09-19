package controllers;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.CompetenceService;
import services.IndicatorService;
import services.LessonPlanService;
import services.ProgramService;

import java.util.List;

@RestController
@RequestMapping(value = "/lesson_plans")
public class LessonPlanController {

    @Autowired
    LessonPlanService lessonPlanService;
    @Autowired
    CompetenceService competenceService;
    @Autowired
    IndicatorService indicatorService;
    @Autowired
    ProgramService programService;

    @GetMapping(produces = "application/json")
    public List<LessonPlan> findAll(){
        return lessonPlanService.findAll();
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public LessonPlan findById(@PathVariable("id") int id){
        LessonPlan lessonPlan = lessonPlanService.findById(id);
        return lessonPlan;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public LessonPlan create(@RequestBody LessonPlan lessonPlan){
        List<Program> programs = lessonPlan.getPrograms();
        if (programs != null)
        for(Program p : programs){
            System.out.println(p);
            programService.save(p);
        }
        lessonPlanService.save(lessonPlan);
        return lessonPlan;
    }
    @PutMapping(value = "/{id}",produces = "application/json", consumes = "application/json")
    public LessonPlan update(@PathVariable("id") int id, @RequestBody LessonPlan lessonPlan){
        lessonPlanService.update(lessonPlan,id);
        return lessonPlanService.findById(id);
    }

    @DeleteMapping(value = "/{id}",produces = "application/json", consumes = "application/json")
    public void delete(@PathVariable("id") int id){
        lessonPlanService.delete(id);
    }


}
