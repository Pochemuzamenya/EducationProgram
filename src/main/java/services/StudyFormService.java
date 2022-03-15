package services;

import model.StudyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.StudyFormRepository;

import java.util.List;

@Service
public class StudyFormService {
    @Autowired
    StudyFormRepository repository;
    public List<StudyForm> findAll(){
        return repository.findAll();
    }
    public StudyForm findById(int id){
        return repository.findById(id);
    }
}
