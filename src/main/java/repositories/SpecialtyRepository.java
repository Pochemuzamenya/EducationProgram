package repositories;

import model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty,Integer> {
    List<Specialty> findAll();
    Specialty findById(int id);
}
