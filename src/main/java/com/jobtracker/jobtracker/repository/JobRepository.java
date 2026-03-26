package com.jobtracker.jobtracker.repository;

import com.jobtracker.jobtracker.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {

    List<Job> findByStatus(String status);

    // 🔍 SEARCH
    List<Job> findByCompanyNameContainingIgnoreCase(String companyName);
}