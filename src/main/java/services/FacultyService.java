package services;

import model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository repository;
    public List<Faculty> findAll(){
        return repository.findAll();
    }
    public Faculty findById(int id){
        return repository.findById(id);
    }
}
