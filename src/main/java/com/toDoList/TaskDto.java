package com.toDoList;

import java.util.Date;

public class TaskDto {
    private String taskTitle;
    private String dueDate;
    private String status;
    private String project;

    public TaskDto(String taskTitle, String dueDate, String status, String project) {
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
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
}
