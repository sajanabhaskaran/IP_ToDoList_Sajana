package com.entity;

import java.time.LocalDate;
import java.util.Date;

public class Task {

    private String taskTitle;
    private LocalDate dueDate;
    private String status;
    private String project;

    public Task(String taskTitle, LocalDate dueDate, String status, String project) {
        this.taskTitle = taskTitle;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;

    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskTitle='" + taskTitle + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status='" + status + '\'' +
                ", project='" + project + '\'' +
                '}';
    }
}

