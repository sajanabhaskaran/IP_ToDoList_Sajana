package com.toDoList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EditTask {
    public void editOption(Path taskFile) {
        System.out.println("Enter 1 to update");
        System.out.println("Enter 2 to mark as done");
        System.out.println("Enter 3 to remove");
        System.out.println("Enter 4 to Quit");
        Scanner editInput = new Scanner(System.in);
        String input = editInput.next();
        switch (input) {
            case "1":
                update(taskFile);
                break;
            case "2":
                markAsDone(taskFile);
                break;
            case "3":
                removeTask(taskFile);
                break;
            case "4":
                System.exit(1);
                break;
            default:
                System.out.println("Invalid Option, please choose the correct option!!");
                editOption(taskFile);
        }

    }

    private void removeTask(Path taskFile) {
        System.out.println("Enter the Title of the task which you want to remove:");
        Scanner scanner=new Scanner(System.in);
        String removeTitle= scanner.next();
        TaskFileHandler taskFileHandler= new TaskFileHandler();
        List <Task> taskList=taskFileHandler.convertFilesToList(taskFile);

            List<Task> newTaskList=taskList.stream().filter(line->{
                if (!line.getTaskTitle().equals(removeTitle)) return true;
                return false;
            }).collect(Collectors.toList());
        try {
            Files.delete(taskFile);
            Path path = Files.createFile(taskFile);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        AddTask addTask= new AddTask();
        addTask.addNewTask(newTaskList,taskFile);
        }


    private void markAsDone(Path taskFile) {
        System.out.println("Enter the Title of the task which you want to mark as 'Done' :");
        Scanner scanner=new Scanner(System.in);
        String doneTitle= scanner.next();
        TaskFileHandler taskFileHandler= new TaskFileHandler();
        List <Task> taskList=taskFileHandler.convertFilesToList(taskFile);


            taskList.stream().forEach(line->{
                if (line.getTaskTitle().equals(doneTitle)){
                    line.setStatus("Done");
                }
            });
        try {
            Files.delete(taskFile);
            Path path=Files.createFile(taskFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        AddTask addTask= new AddTask();
        addTask.addNewTask(taskList,taskFile);
    }

    private void update(Path taskFile) {
        System.out.println("Which Task you want to update:");
        ShowTask showTask= new ShowTask();
        List<Task> taskList=showTask.showAllTasks(taskFile);
        Scanner scanner= new Scanner(System.in);
        Integer  input= Integer.parseInt(scanner.next());
        Integer listSize= taskList.size();
        if (input<=listSize){
            System.out.println("Enter Field, which you want to update :");
            Scanner scanner1= new Scanner(System.in);
            String fieldInput= scanner1.next().toLowerCase();
            System.out.println("Enter the Value, you want to update to: ");
            String fieldValue=scanner1.next();
            if (fieldInput.equals("tasktitle")|| fieldInput.equals("duedate")|| fieldInput.equals("status")|| fieldInput.equals("project")) {
                Task task=taskList.get(input - 1);
                switch (fieldInput){
                    case "tasktitle":
                        task.setTaskTitle(fieldValue);
                        break;
                    case "duedate":
                        task.setDueDate(fieldValue);
                        break;
                    case "status":
                        task.setStatus(fieldValue);
                        break;
                    case "project":
                        task.setProject(fieldValue);
                        break;
                    default:
                        System.out.println("Invalid parameter");
                        break;
                }
            }
            else{
                System.out.println("Invalid Input, please try again:");
                update(taskFile);
            }
        }
        try {
            Files.delete(taskFile);
            Path path=Files.createFile(taskFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        AddTask addTask= new AddTask();
        if (addTask.addNewTask(taskList,taskFile)) System.out.println("File updated successfully");
        else System.out.println("File update Unsuccessful");

    }
}
