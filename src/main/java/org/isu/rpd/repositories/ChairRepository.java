package org.isu.rpd.repositories;

import org.isu.rpd.model.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairRepository extends JpaRepository<Chair,Integer> {
    List<Chair> findAll();
    Chair findById(int id);
}
