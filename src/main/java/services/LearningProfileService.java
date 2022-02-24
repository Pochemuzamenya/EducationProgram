package services;


import model.LearningProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LearningProfileRepository;

import java.util.List;

@Service
public class LearningProfileService {
    @Autowired
    LearningProfileRepository repository;

    public List<LearningProfile> findAll(){
        return repository.findAll();
    }
    public LearningProfile findById(int id){
        return repository.findById(id);
    }
    public void save(LearningProfile learningProfile){
        repository.saveAndFlush(learningProfile);
    }
}
