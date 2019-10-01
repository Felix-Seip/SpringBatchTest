package com.example.demo.rest_controllers;

import org.springframework.batch.core.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/jobs")
public class JobRestController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    HashMap<String, Job> jobsMap;

    @Autowired
    JobExplorer jobExplorer;


    @GetMapping("")
    public Long startJob(@RequestParam("jobName") final String jobName){
        return run(jobName).getJobId();
    }

    @GetMapping("/{jobId}")
    public JobExecution getJobInformation(@PathVariable Long jobId){
        return jobExplorer.getJobExecution(jobId);
    }

    private JobExecution run(final String jobName){
        try {
            JobParameters params = new JobParametersBuilder()
                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
                    .toJobParameters();
            return jobLauncher.run(jobsMap.get(jobName), params);
        } catch (JobExecutionAlreadyRunningException |
                JobRestartException |
                JobInstanceAlreadyCompleteException |
                JobParametersInvalidException e) {
            e.printStackTrace();
        }
        return null;
    }

}
