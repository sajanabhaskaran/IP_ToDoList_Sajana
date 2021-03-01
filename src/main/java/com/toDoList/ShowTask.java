package com.toDoList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShowTask {

    public void filterOption(Path filePath) {
        Scanner scannerinput = new Scanner(System.in);
        System.out.println("ENTER THE OPTION 1 TO SORT BY DATE:  ");
        System.out.println("ENTER THE OPTION 2 TO SORT BY PROJECT: ");
        System.out.println("ENTER THE OPTION 3 TO QUIT: ");
        String option = scannerinput.nextLine();
        switch (option) {
            case "1":
                /*Scanner inputDate = new Scanner(System.in);
                System.out.println("Enter the Date (dd/mm/yyyy): ");
                String filterDate = inputDate.nextLine();
                showTaskFileByDate(filePath, filterDate);*/
                sortByDate(filePath);
                break;
            case "2":
                /*Scanner inputProject = new Scanner(System.in);
                System.out.println("Enter the Project: ");
                String filterProject = inputProject.nextLine();
                showTaskFileByProject(filePath, filterProject);*/
                sortByProject(filePath);
                break;
            case "3":
                System.exit(1);
                break;
            default:
                System.out.println("INVALID OPTION, PLEASE ENTER AGAIN!!");
                filterOption(filePath);
        }
    }

    private void sortByDate(Path filePath) {
        TaskFileHandler taskFileHandler = new TaskFileHandler();
        List<Task> taskList = taskFileHandler.convertFilesToList(filePath);
        Collections.sort(taskList,((o1, o2) -> {
            Task task1= (Task) o1;
            Task task2= (Task) o2;
            return task1.getDueDate().compareTo(task2.getDueDate());
        }));
        System.out.println("TASCS SORTED BY DUE DATE ORDER: ");
        taskList.stream().forEach(System.out::println);

    }

    private void sortByProject(Path filePath) {
        TaskFileHandler taskFileHandler = new TaskFileHandler();
        List<Task> taskList = taskFileHandler.convertFilesToList(filePath);
        Collections.sort(taskList,((o1, o2) -> {
            Task task1= (Task) o1;
            Task task2= (Task) o2;
            return task1.getProject().toUpperCase().compareTo(task2.getProject().toUpperCase());
        }));
        System.out.println("TASCS SORTED BY PROJECT'S ALPHABETICAL ORDER: ");
        taskList.stream().forEach(System.out::println);

    }

    /*private void showTaskFileByProject(Path filePath, String filterProject) {

        TaskFileHandler taskFileHandler = new TaskFileHandler();
        List<Task> taskList = taskFileHandler.convertFilesToList(filePath);

        List<Task> filterTask = taskList.stream().filter(task -> {
            if (task.getProject().equals(filterProject)) return true;
            return false;
        }).collect(Collectors.toList());

        if (!filterTask.isEmpty()){
            filterTask.stream().forEach(System.out::println);
        }
        else {
            System.out.println("There is no tasks with the specified Project!!");
        }



    }*/

    /*public void showTaskFileByDate(Path filePath, String date) {


        TaskFileHandler taskFileHandler = new TaskFileHandler();
        List<Task> taskList = taskFileHandler.convertFilesToList(filePath);


        List<Task> filterTask = taskList.stream().filter(task -> {
            if (task.getDueDate().equals(date)) return true;
            return false;
        }).collect(Collectors.toList());

        if (!filterTask.isEmpty()) {
            System.out.println("\n");
            System.out.println("THESE ARE THE TASKS ON THE DATE :" + date);
            System.out.println("\n");
            filterTask.stream().forEach(System.out::println);
        } else {
            System.out.println("There is no tasks in the specified date!!");
        }


    }*/

    public List<Task> showAllTasks(Path filePath) {
        AtomicReference<Integer> n = new AtomicReference<>(1);
        TaskFileHandler taskFileHandler = new TaskFileHandler();
        List<Task> taskList = taskFileHandler.convertFilesToList(filePath);
        taskList.stream().forEach(line -> {
            System.out.print(n + " : ");
            System.out.println(line);
            n.updateAndGet(v -> v + 1);
        });
        return taskList;
    }
}
