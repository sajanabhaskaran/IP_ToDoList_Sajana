package com.toDoList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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
        try(Stream<String> stream= Files.lines(taskFile)){
            List<Task> taskList=stream.map(line->{
                String [] parts= line.split(",");
                String title= parts[0];
                String dueDate= parts[1];
                String status= parts[2];
                String project= parts[3];
                return (new Task(title,dueDate,status,project));
            }).collect(Collectors.toList());

            Files.delete(taskFile);

            List<Task> newTaskList=taskList.stream().filter(line->{
                if (!line.getTaskTitle().equals(removeTitle)) return true;
                return false;
            }).collect(Collectors.toList());

            Path path=Files.createFile(taskFile);

            AddTask addTask= new AddTask();
            addTask.addNewTask(newTaskList,path);

            }catch (IOException e){
            System.out.println(e.getMessage());
        }
        }



    private void markAsDone(Path taskFile) {
    }

    private void update(Path taskFile) {
    }
}
