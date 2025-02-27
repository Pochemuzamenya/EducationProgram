package org.isu.rpd.repositories;

import org.isu.rpd.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Integer> {
    @Override
    List<Faculty> findAll();
    Faculty findById(int id);
}
