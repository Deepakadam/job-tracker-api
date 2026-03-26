package com.jobtracker.jobtracker.controller;

import com.jobtracker.jobtracker.entity.Job;
import com.jobtracker.jobtracker.service.JobService;
import com.jobtracker.jobtracker.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService service;

    @Autowired
    private JobRepository repository;

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return service.getAllJobs();
    }

    @PostMapping("/jobs")
    public Job addJob(@Valid @RequestBody Job job) {
        return service.addJob(job);
    }

    @PutMapping("/jobs/{id}")
    public Job updateJob(@PathVariable int id, @RequestBody Job job) {
        return service.updateJob(id, job);
    }

    @GetMapping("/jobs/status/{status}")
    public List<Job> getJobsByStatus(@PathVariable String status) {
        return repository.findByStatus(status);
    }

    // 🔍 SEARCH API
    @GetMapping("/jobs/search/{company}")
    public List<Job> searchJobs(@PathVariable String company) {
        return service.searchJobs(company);
    }

    @DeleteMapping("/jobs/{id}")
    public String deleteJob(@PathVariable int id) {
        service.deleteJob(id);
        return "Deleted job with id " + id;
    }
}