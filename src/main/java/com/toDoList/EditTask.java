package com.toDoList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EditTask {
    public void editOption(Path taskFile) {
        System.out.println("ENTER THE OPTION 1 TO UPDATE THE TASK: ");
        System.out.println("ENTER THE OPTION 2 TO MARK AS DONE STATE: ");
        System.out.println("ENETER THE OPTION 3 TO REMOVE THE TASK: ");
        System.out.println("ENTER THE OPTION 4 TO QUIT");
        Scanner editInput = new Scanner(System.in);
        String input = editInput.nextLine();
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
        System.out.println("WHICH TASK YOU WANT TO REMOVE, ENTER THE INDEX NUMEBR:");
        ShowTask showTask = new ShowTask();
        List<Task> taskList = showTask.showAllTasks(taskFile);
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.parseInt(scanner.nextLine());
        Integer listSize = taskList.size();
        if (input <= listSize) {
            taskList.remove(input - 1);
        }else{
            System.out.println("INVALID OPTION,SO THE PROGRAM IS TERMINATING");
            System.exit(1);
        }

        try {
            Files.delete(taskFile);
            Path path = Files.createFile(taskFile);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        AddTask addTask = new AddTask();
        if (addTask.addNewTaskToFile(taskList, taskFile)){
            System.out.println("TASK REMOVED SUCCESSFULLY");
            taskList.stream().forEach(System.out::println);
        }else {
            System.out.println("UNSUCCESSFULL!!!!");
        }

    }


    private void markAsDone(Path taskFile) {
        System.out.println("WHICH TASK YOU WANT TO MARK AS DONE STATE,ENTER THE INDEX NUMBER:");
        ShowTask showTask = new ShowTask();
        List<Task> taskList = showTask.showAllTasks(taskFile);
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.parseInt(scanner.nextLine());
        Integer listSize = taskList.size();
        if (input <= listSize) {
            taskList.get(input-1).setStatus("Done");
        }
        try {
            Files.delete(taskFile);
            Path path = Files.createFile(taskFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        AddTask addTask = new AddTask();
        if (addTask.addNewTaskToFile(taskList, taskFile)){
            System.out.println("TASK UPDATED SUCCESSFULLY");
            taskList.stream().forEach(System.out::println);
        }else {
            System.out.println("UNSUCCESSFULL!!!!");
        }
    }

    private void update(Path taskFile) {
        System.out.println("WHICH TASK YOU WANT TO UPDATE, ENTER THE INDEX NUMBER:");
        ShowTask showTask = new ShowTask();
        List<Task> taskList = showTask.showAllTasks(taskFile);
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.parseInt(scanner.nextLine());
        Integer listSize = taskList.size();
        if (input >0 && input<= listSize) {
            System.out.println("ENTER THE FIELD, WHICH YOU WANT TO UPDATE :");
            Scanner scanner1 = new Scanner(System.in);
            String fieldInput = scanner1.nextLine().toLowerCase();
            System.out.println("ENTER THE VALUE, WHICH YOU WANT TO UPDATE TO: ");
            String fieldValue = scanner1.nextLine();
            if (fieldInput.equals("tasktitle") || fieldInput.equals("duedate") || fieldInput.equals("status") || fieldInput.equals("project")) {
                Task task = taskList.get(input - 1);
                switch (fieldInput) {
                    case "tasktitle":
                        task.setTaskTitle(fieldValue);
                        break;
                    case "duedate":
                        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                        Date dueDate= null;
                        try {
                            dueDate = sdf.parse(fieldValue);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        task.setDueDate(dueDate);
                        break;
                    case "status":
                        task.setStatus(fieldValue);
                        break;
                    case "project":
                        task.setProject(fieldValue);
                        break;
                    default:
                        System.out.println("INVALID FIELD");
                        break;
                }
            } else {
                System.out.println("INVALID INPUT, PLEASE TRY AGAIN:");
                update(taskFile);
            }

            try {
                Files.delete(taskFile);
                Path path = Files.createFile(taskFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            AddTask addTask = new AddTask();
            if (addTask.addNewTaskToFile(taskList, taskFile)) System.out.println("FILE UPDATED SUCCSESSFULLY");
            else System.out.println("FILE NOT UPDATED");
        }
        else{
            System.out.println("INVALID OPTION");
        }


    }
}
