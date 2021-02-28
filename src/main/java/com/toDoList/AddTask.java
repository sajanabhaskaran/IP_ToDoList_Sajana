package com.toDoList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class AddTask {

    public boolean addNewTask(Task task, Path file) {
        String title = task.getTaskTitle();
        String dueDate = task.getDueDate();
        String status = task.getStatus();
        String project = task.getProject();
        String taskLineString = String.join(",", title, dueDate, status, project);
        try {
            Files.write(file, (taskLineString + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean addNewTask(List<Task> task, Path file) {
        task.stream().forEach(line -> {
            String title = line.getTaskTitle();
            String dueDate = line.getDueDate();
            String status = line.getStatus();
            String project = line.getProject();
            String taskLineString = String.join(",", title, dueDate, status, project);
            try {
                Files.write(file, (taskLineString + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
        return true;
    }

    public void processAddTaskUserInputs(Path filePath) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the task tiltle: ");
        String tiltle = scanner.next();
        System.out.println("Enter the due date (dd/mm/yyyy): ");
        String dueDate = scanner.next();
        System.out.println("Enter the task status: ");
        String status = scanner.next();
        System.out.println("Enter the project: ");
        String project = scanner.next();
        Task task = new Task(tiltle, dueDate, status, project);
        addNewTask(task, filePath);
    }
}
