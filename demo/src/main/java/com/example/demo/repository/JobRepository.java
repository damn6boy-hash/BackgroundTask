package com.example.demo.repository;

import com.example.demo.model.Job;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {

    @Query("SELECT * FROM job WHERE fl_work = :flWork")
    List<Job> findByFLWork(@Param("flWork") Integer flWork);
}