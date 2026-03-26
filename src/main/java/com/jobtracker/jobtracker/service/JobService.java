package com.jobtracker.jobtracker.service;

import com.jobtracker.jobtracker.entity.Job;
import com.jobtracker.jobtracker.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    public Job addJob(Job job) {
        return repository.save(job);
    }

    public Job updateJob(int id, Job newJob) {
        Job job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setCompanyName(newJob.getCompanyName());
        job.setRole(newJob.getRole());
        job.setStatus(newJob.getStatus());

        return repository.save(job);
    }

    public List<Job> searchJobs(String companyName) {
        return repository.findByCompanyNameContainingIgnoreCase(companyName);
    }

    public void deleteJob(int id) {
        repository.deleteById(id);
    }
}