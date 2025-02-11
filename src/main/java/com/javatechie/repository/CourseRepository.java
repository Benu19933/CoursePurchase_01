package com.javatechie.repository;

import com.javatechie.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    CourseEntity findByName(String name);

    CourseEntity findByFees(Double fees);

    List<CourseEntity> findByCourseType(String courseType);

    List<CourseEntity> findByCourseTypeAndFees(String courseType, Double fees);

    List<CourseEntity> findByCourseTypeOrFees(String courseType, Double fees);

    @Query("from CourseEntity c where c.fees=?1")
   // @Query("from CourseEntity c where c.fees= :fees")
   List<CourseEntity> getCourseByFees(@Param("fees") Double fees);





}
