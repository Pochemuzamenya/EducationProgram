package services;

import model.LessonPlan;
import model.Program;
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
    public LessonPlan findById(int id){
        return repository.findById(id);
    }
    public void save(LessonPlan lessonPlan){
        repository.save(lessonPlan);
    }
    public void update(LessonPlan lessonPlan, Integer id){
        LessonPlan lessonPlanToUpdate = findById(id);
        try {
            lessonPlanToUpdate = lessonPlan.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        lessonPlanToUpdate.setId(id);
        repository.saveAndFlush(lessonPlanToUpdate);
    }
    public void delete(Integer id){
        LessonPlan lessonPlan = findById(id);
        repository.delete(lessonPlan);
    }
}
