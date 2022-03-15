package repositories;

import model.StudyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyFormRepository extends JpaRepository<StudyForm,Integer> {
    public List<StudyForm> findAll();
    public StudyForm findById(int id);
}
