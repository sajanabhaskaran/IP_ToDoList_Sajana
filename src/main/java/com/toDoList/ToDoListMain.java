package com.toDoList;

import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListMain {
    public static void main(String[] args) {
        ToDoListMain toDoListMain= new ToDoListMain();
        toDoListMain.mainPage();

    }


    private void mainPage() {
        TaskFileHandler taskFileHandler= new TaskFileHandler();
        Path taskFile=taskFileHandler.getTaskFile();
        System.out.println(taskFile);


        Scanner s= new Scanner(System.in);
        System.out.println("Pick an option: ");
        System.out.println("(1) Show task list");
        System.out.println("(2) Add new task");
        System.out.println("(3) Edit task");
        System.out.println("(4) Save and Quit");
        if (s.hasNext()){
            String input= s.next();
            switch (input){
                case "1":
                    ShowTask showTask= new ShowTask();
                    showTask.showTaskFile(taskFile);

                    break;
                case "2":
                    AddTask addTask=new AddTask();
                    addTask.processAddTaskUserInputs(taskFile);
                    break;
                case "3":
                    System.out.println("Edit task list");
                    break;
                case "4":
                    System.out.println("Save and Quit");
                    break;
            }
        }




    }

}
