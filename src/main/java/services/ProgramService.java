package services;

import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public List<Program> findAll(String sort , String dir){
        if (sort==null)
            return repository.findAll();
        if (dir.equals("ASC") || dir == null)
            return repository.findAll(new Sort(Sort.Direction.ASC,sort));
        return repository.findAll(new Sort(Sort.Direction.DESC,sort));
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
    public void save(Program program){
        repository.saveAndFlush(program);
    }
}
