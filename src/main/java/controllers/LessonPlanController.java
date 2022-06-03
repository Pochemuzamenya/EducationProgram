package controllers;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.CompetenceService;
import services.IndicatorService;
import services.LessonPlanService;

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

    @GetMapping(produces = "application/json")
    public List<LessonPlan> findAll(){
        return lessonPlanService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public LessonPlan create(@RequestBody LessonPlan lessonPlan){
        List<Competence> competences = lessonPlan.getCompetences();
        for(Competence c : competences){
            List<Indicator> indicators = c.getIndicators();
            for (Indicator i : indicators)
                indicatorService.save(i);
            competenceService.save(c);
        }

        System.out.println(lessonPlan);
        lessonPlanService.save(lessonPlan);
        return lessonPlan;
    }
}
