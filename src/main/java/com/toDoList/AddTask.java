package com.toDoList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

public class AddTask {
    private UserInput userInput;
    public AddTask(UserInput userInput) {
        this.userInput=userInput;
    }

    public boolean addNewTaskToFile(Task task, Path file) {
        String title = task.getTaskTitle();
        LocalDate dueDate = task.getDueDate();
        String dDate = dueDate.toString();
        String status = task.getStatus();
        String project = task.getProject();
        String taskLineString = String.join(",", title, dDate, status, project);
        try {
            Files.write(file, (taskLineString + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    public boolean addNewTaskToFile(List<Task> task, Path file) {
        task.stream().forEach(line -> {
            String title = line.getTaskTitle();
            LocalDate dueDate = line.getDueDate();
            String dDate = dueDate.toString();
            String status = line.getStatus();
            String project = line.getProject();
            String taskLineString = String.join(",", title, dDate, status, project);
            try {
                Files.write(file, (taskLineString + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
        return true;
    }

    public void processAddTaskUserInputs(Path filePath) {
        UserInput userInput = new UserInput();
        TaskDto taskDto = userInput.getProcessAddTaskUserInputs();

        Task task = new Task(taskDto.getTaskTitle(), ToDoUtils.convertStringToDate(taskDto.getDueDate()), taskDto.getStatus(), taskDto.getProject());
        if (addNewTaskToFile(task, filePath)) {
            System.out.println("Task Added to the File successfully in the location: " + filePath);
        }
    }


}
