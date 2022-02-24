package repositories;

import model.LearningProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningProfileRepository extends JpaRepository<LearningProfile, Integer> {
    List<LearningProfile> findAll();
    LearningProfile findById(int id);
}
