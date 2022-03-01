package services;

import model.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.SetRepository;

import java.util.List;

@Service
public class SetService {
    @Autowired
    SetRepository repository;
    public List<Set> findAll(){
        return repository.findAll();
    }
}
