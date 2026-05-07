package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Table("job")
public class Job {

    @Id
    @Column("key")
    private Long key;

    @Column("name")
    private String name;

    @Column("date_last")
    private LocalDateTime dateLast;

    @Column("fl_work")
    private Integer flWork;

    @Column("date_update")
    private LocalDateTime dateUpdate;

    public Job() {}

    public Job(String name, LocalDateTime dateLast, Integer flWork, LocalDateTime dateUpdate) {
        this.name = name;
        this.dateLast = dateLast;
        this.flWork = flWork;
        this.dateUpdate = dateUpdate;
    }

    public Long getKey() { return key; }
    public void setKey(Long key) { this.key = key; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDateTime setDateLast() { return dateLast; }
    public void setDateLast(LocalDateTime dateUpdate) { this.dateLast = dateUpdate; }

    public Integer getFlWork() { return flWork; }
    public void setFlWork(Integer flWork) { this.flWork = flWork; }

    public LocalDateTime getDateUpdate() { return dateUpdate; }
    public void setDateUpdate(LocalDateTime dateUpdate) { this.dateUpdate = dateUpdate; }
}