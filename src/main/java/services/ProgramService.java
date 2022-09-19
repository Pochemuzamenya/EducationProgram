package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Filter;
import model.NewProgramJSON;
import model.Program;
import model.ResponseJSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repositories.ProgramRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProgramService {
    @Autowired
    ProgramRepository repository;
    @Autowired
    ChairService chairService;
    @Autowired
    SpecialtyService specialtyService;
    @Autowired
    LearningProfileService learningProfileService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    DegreeService degreeService;
    @Autowired
    StudyFormService studyFormService;
    public ResponseJSON findAll(){
        Filter filters = new Filter();
        List<String> subjects = findSubjectNames();
        List<String> chairs = findChairNames();
        List<Integer> years = findYears();
        List<String> specialties = findSpecialtyNames();
        List<String> degrees = findDegrees();
        filters.setChair(chairs);
        filters.setDegree(degrees);
        filters.setSpecialty(specialties);
        filters.setYear(years);
        filters.setSubject(subjects);
        List<Program> programs = repository.findAll();
        ResponseJSON response = new ResponseJSON(programs, filters);
        return response;
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
        program.setCreation_date(new Timestamp(System.currentTimeMillis()));
        program.setLast_edit(program.getCreation_date());
        repository.saveAndFlush(program);
    }
    public void delete(Integer id){
        Program program = findById(id);
        repository.delete(program);
    }
    public NewProgramJSON addProgram(){
        NewProgramJSON json = new NewProgramJSON();
        json.setSubjects(subjectService.findAll());
        json.setSpecialties(specialtyService.findAll());
        json.setLearning_profiles(learningProfileService.findAll());
        json.setChairs(chairService.findAll());
        json.setDegrees(degreeService.findAll());
        json.setStudyForms(studyFormService.findAll());
        return json;
    }

    public void update(Program program, Integer id){
        Program programToUpdate = findById(id);
        try {
            programToUpdate = program.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        programToUpdate.setId(id);
        programToUpdate.setLast_edit(program.getCreation_date());
        repository.saveAndFlush(programToUpdate);
    }
}
