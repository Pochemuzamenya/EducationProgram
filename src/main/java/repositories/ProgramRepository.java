package repositories;

import model.Program;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> findAll();
    List<Program> findAll(Sort sort);
    Program findById(int id);
    @Query("SELECT DISTINCT p.lesson_plan.year FROM Program as p")
    List<Integer> findYears();
    @Query("SELECT DISTINCT c.name FROM Chair as c")
    List<String> findChairNames();
    @Query("SELECT DISTINCT s.name FROM Subject as s")
    List<String> findSubjectNames();
    @Query("SELECT DISTINCT s.name FROM Specialty as s")
    List<String> findSpecialtyNames();
    @Query("SELECT DISTINCT p.lesson_plan.degree FROM Program as p")
    List<String> findDegrees();
}
