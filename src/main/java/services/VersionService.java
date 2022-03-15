package services;


import model.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.VersionRepository;

import java.util.List;

@Service
public class VersionService {
    @Autowired
    VersionRepository repository;
    List<Version> findAll(){
        return repository.findAll();
    }
    Version findById(int id){
        return repository.findById(id);
    }
    public void save(Version version){
        repository.saveAndFlush(version);
    }
}
