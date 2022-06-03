package services;

import model.LessonPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LessonPlanRepository;

import java.util.List;

@Service
public class LessonPlanService {
    @Autowired
    LessonPlanRepository repository;

    public List<LessonPlan> findAll(){
        return repository.findAll();
    }
    public void save(LessonPlan lessonPlan){
        repository.save(lessonPlan);
    }
}
