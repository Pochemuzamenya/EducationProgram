package repositories;

import model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DegreeRepository extends JpaRepository<Degree,Integer> {
    public List<Degree> findAll();
    public Degree findById(int id);
}
