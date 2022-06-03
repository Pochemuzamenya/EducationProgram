package services;

import model.Competence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CompetenceRepository;

@Service

public class CompetenceService {
    @Autowired
    CompetenceRepository repository;
    public void save(Competence competence){
        repository.saveAndFlush(competence);
    }
}
