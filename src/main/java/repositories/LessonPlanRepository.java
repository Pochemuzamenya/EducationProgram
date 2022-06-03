package repositories;

import model.LessonPlan;
import model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LessonPlanRepository extends JpaRepository<LessonPlan, Integer> {

}
