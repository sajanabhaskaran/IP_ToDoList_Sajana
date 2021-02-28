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
        //System.out.println(taskFile);



        System.out.println("Pick an option: ");
        System.out.println("(1) Show Task list (By date or Project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");
        Scanner s= new Scanner(System.in);
        if (s.hasNext()){
            String input= s.next();
            switch (input){
                case "1":
                    ShowTask showTask= new ShowTask();
                    showTask.filterOption(taskFile);
                    break;
                case "2":
                    AddTask addTask=new AddTask();
                    addTask.processAddTaskUserInputs(taskFile);
                    break;
                case "3":
                    EditTask editTask= new EditTask();
                    editTask.editOption(taskFile);
                    break;
                case "4":
                    System.out.println("Save and Quit");
                    break;
                case "5":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid Option, please try again");
                    mainPage();

            }
        }




    }

}
