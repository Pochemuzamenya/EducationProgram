package services;

import model.CoverSheet;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProgramRepository;

import java.util.List;

@Service
public class ProgramService {
    @Autowired
    ProgramRepository repository;
    public List<Program> findAll(){
        return repository.findAll();
    }
    public Program findById(int id){
        return repository.findById(id);
    }
    public List<Integer> findYears(){
        return repository.findYears();
    }
    public List<String> findChairNames(){
        return repository.findChairNames();
    }
    public List<String> findSubjectNames(){
        return repository.findSubjectNames();
    }
    public List<String> findSpecialtyNames(){
        return repository.findSpecialtyNames();
    }
    public List<String> findDegrees(){
        return repository.findDegrees();
    }
    public CoverSheet findCoverSheet(int id){
        return repository.findCoverSheet(id);
    }
}
