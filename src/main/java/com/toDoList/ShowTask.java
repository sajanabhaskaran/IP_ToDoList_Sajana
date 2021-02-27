package com.toDoList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShowTask {

    public void filterOption(Path filePath){
        Scanner scannerinput= new Scanner(System.in);
        System.out.println("Enter 1 if you want to filter by date ");
        System.out.println("Enter 2 if you want to filter by Project");
        System.out.println("Enter 3 to Quit");
        String option= scannerinput.next();
        switch (option){
            case "1":
                Scanner inputDate= new Scanner(System.in);
                System.out.println("Enter the Date: ");
                String filterDate=inputDate.next();
                showTaskFileByDate(filePath,filterDate);
                break;
            case "2":
                Scanner inputProject= new Scanner(System.in);
                System.out.println("Enter the Project: ");
                String filterProject= inputProject.next();
                showTaskFileByProject(filePath,filterProject);
                break;
            case "3":
                System.exit(1);
                break;
            default:
                System.out.println("Invalid option, Please enter again!!");
                filterOption(filePath);
        }
    }

    private void showTaskFileByProject(Path filePath, String filterProject) {
        try(Stream<String> stream= Files.lines(filePath)){
            List<Task> taskList=stream.map(line->{
                String [] parts=line.split(",");
                String title= parts[0];
                String dueDate= parts[1];
                String status= parts[2];
                String project= parts[3];
                return (new Task(title,dueDate,status,project));
            }).collect(Collectors.toList());

            List<Task>filterTask=taskList.stream().filter(task -> {
                if (task.getProject().equals(filterProject)) return true;
                return false;
            }).collect(Collectors.toList());

            filterTask.stream().forEach(System.out::println);

        }catch(IOException e){
            System.out.println(e.getMessage());

        }


    }

    public void showTaskFileByDate(Path filePath,String date){

        try(Stream<String> stream= Files.lines(filePath)) {
            List<Task> taskList=stream.map(line->{
                String [] parts= line.split(",");
                String title= parts[0];
                String dueDate= parts[1];
                String status= parts[2];
                String project= parts[3];
                return (new Task(title,dueDate,status,project));
            }).collect(Collectors.toList());
            List<Task> filterTask=taskList.stream().filter(task -> {
                if (task.getDueDate().equals(date)) return true;
                return false;
            }).collect(Collectors.toList());

            filterTask.stream().forEach(System.out::println);



        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}
