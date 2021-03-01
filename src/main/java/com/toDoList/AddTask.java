package com.toDoList;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AddTask {

    public boolean addNewTaskToFile(Task task, Path file){
        String title=task.getTaskTitle();
        Date dueDate= task.getDueDate();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        String dDate=sdf.format(dueDate);
        String status= task.getStatus();
        String project= task.getProject();
        String taskLineString= String.join(",",title,dDate,status,project);
        try {
            Files.write(file,(taskLineString + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    public boolean addNewTaskToFile(List<Task> task, Path file) {
        task.stream().forEach(line -> {
            String title = line.getTaskTitle();
            Date dueDate = line.getDueDate();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String  dDate= sdf.format(dueDate);
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
    public void processAddTaskUserInputs(Path filePath){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the task tiltle: ");
        String tiltle= scanner.nextLine();
        System.out.println("Enter the due date (yyyy-MM-dd): ");
        String stringDueDate= scanner.nextLine();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date dueDate= null;
        try {
            dueDate = sdf.parse(stringDueDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println("Enter the due date in the proper format (yyyy-MM-dd): ");
            dDate= scanner.nextLine();
        }
        System.out.println("Enter the task status: ");
        String status= scanner.nextLine();
        System.out.println("Enter the project: ");
        String project= scanner.nextLine();
        Task task= new Task(tiltle,dueDate,status,project);
        addNewTaskToFile(task,filePath);
    }
}
