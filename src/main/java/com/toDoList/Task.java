package com.toDoList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
    private List<Task> taskArrayList;
    private String taskTitle;
    private Date dueDate;
    private String status;
    private String project;

    public Task(String taskTitle, Date dueDate, String status, String project) {
        this.taskTitle = taskTitle;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
        this.taskArrayList=new ArrayList<>();
    }

    public List<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(List<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
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

