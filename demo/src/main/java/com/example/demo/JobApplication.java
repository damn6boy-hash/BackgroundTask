package com.example.demo;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class JobApplication {

    private static final Logger log = LoggerFactory.getLogger(JobApplication.class);
    private final JobRepository repo;

    public JobApplication(JobRepository repo) {
        this.repo = repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }

    @Scheduled(fixedDelay = 300000)
    public void processedJobs() {
        List<Job> jobs = repo.findByFLWork(0);
        log.info("Запущена проверка. Новых записей: {}", jobs.size());
        
        for (Job job : jobs) {
            log.info("Обработывается запись: key={}, name={}", job.getKey(), job.getName());
            job.setDateLast(LocalDateTime.now());
            job.setFlWork(1);
            job.setDateUpdate(LocalDateTime.now());
            repo.save(job);
            log.info("Запись key={} обработана", job.getKey());
        }
    }
}
