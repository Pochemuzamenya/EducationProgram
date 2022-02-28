package repositories;

import model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findAll();
    Subject findById(@Param("id") int id);
    /*@Modifying
    @Query("update Subject s set s.name = :name where s.id = :id")
    int updateSubject(@Param("id") Integer id, @Param("name") String name);*/
}
