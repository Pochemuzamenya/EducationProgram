package org.isu.rpd.services;

import org.isu.rpd.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.isu.rpd.repositories.SubjectRepository;

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

    public void update(Integer id, Subject updatedSubject) {
        Subject subjectToBeUpdated = findById(id);
        System.out.println(updatedSubject.getName());
        //repository.updateSubject(id,updatedSubject.getName());
    }
    public Subject findByName(String name){
        return repository.findByName(name);
    }
}
