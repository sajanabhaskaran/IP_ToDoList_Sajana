package com.toDoList;

import java.io.File;
import java.io.InputStreamReader;
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
        File taskFile=taskFileHandler.getTaskFile();

        /*List<Task> taskArrayList= new ArrayList<>();

        taskArrayList.add(new Task("Wakeup","12/12/2021","New","Personal"));
        taskArrayList.add(new Task("Sleep","12/12/2021","New","Personal"));
        taskArrayList.add(new Task("Study","12/12/2022","New","Professional"));
        taskArrayList.add(new Task("Dance","12/12/2029","continuing","Personal"));*/


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
                    System.out.println("go to show task list");


                    break;
                case "2":
                    AddTask addTask=new AddTask();
                    //addTask.addNewTask()
                    //System.out.println("go to Add new task list");
                    //InputStreamReader isr= new InputStreamReader(new Scanner(System.in));
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
