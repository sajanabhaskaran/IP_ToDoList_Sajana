package com.entity;

public class TaskDataTranfer {
    private String taskTitle;
    private String dueDateString;
    private String status;
    private String project;

    public TaskDataTranfer(String taskTitle, String dueDate, String status, String project) {
        this.taskTitle = taskTitle;
        this.dueDateString = dueDate;
        this.status = status;
        this.project = project;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDueDateString() {
        return dueDateString;
    }

    public void setDueDateString(String dueDateString) {
        this.dueDateString = dueDateString;
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
