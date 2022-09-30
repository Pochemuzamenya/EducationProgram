package org.isu.rpd.repositories;

import org.isu.rpd.model.LessonPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LessonPlanRepository extends JpaRepository<LessonPlan, Integer> {
public LessonPlan findById(int id);
}
