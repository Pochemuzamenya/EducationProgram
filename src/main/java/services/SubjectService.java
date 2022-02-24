package services;

import model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.SubjectRepository;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository repository;
    public List<Subject> findAll() {
        return repository.findAll();
    }
    public Subject findById(int id){
        return repository.findById(id);
    }
    public void save(Subject subject){
        repository.saveAndFlush(subject);
    }

}
