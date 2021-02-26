package com.toDoList;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class AddTask {

    public boolean addNewTask(Task task, File file){

        return true;
    }
    public boolean addNewTask(List<Task> task, File file){

        return true;
    }
    public void processAddTaskUserInputs(File file){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the task tiltle: ");
        String tiltle= scanner.next();
        System.out.println("Enter the due date (dd/mm/yyyy): ");
        String dueDate= scanner.next();
        System.out.println("Enter the task status: ");
        String status= scanner.next();
        System.out.println("Enter the project: ");
        String project= scanner.next();
        Task task= new Task(tiltle,dueDate,status,project);
        addNewTask(task,file);
    }
}
