package com.io;

import com.entity.TaskDataTranfer;

import java.util.*;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public String getMainUserInput() {
        System.out.println("-----------------");
        System.out.println("WELCOME TO TODOLY");
        System.out.println("-----------------");
        System.out.println("Pick an option: ");
        System.out.println("(1) Show Task list (By date or Project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");
        return scanner.nextLine();
    }

    public String getShowTaskInputOption() {
        System.out.println("ENTER '1' TO SORT BY DATE:  ");
        System.out.println("ENTER '2' TO SORT BY PROJECT: ");
        System.out.println("ENTER '3' TO QUIT: ");
        return scanner.nextLine();
    }

    public TaskDataTranfer getProcessAddTaskUserInputs() {
        System.out.println("ENTER THE TASK TITLE: ");
        String tiltle = scanner.nextLine();
        System.out.println("ENTER THE DUE DATE (yyyy-MM-dd): ");
        String stringDueDate = scanner.nextLine();
        System.out.println("ENTER THE TASK STATUS: ");
        String status = scanner.nextLine();
        System.out.println("ENTER THE PROJECT: ");
        String project = scanner.nextLine();
        TaskDataTranfer taskDto = new TaskDataTranfer(tiltle, stringDueDate, status, project);
        return taskDto;
    }

    public String getEditTaskInputOption() {
        System.out.println("ENTER '1' TO UPDATE THE TASK: ");
        System.out.println("ENTER '2' TO MARK AS DONE STATE: ");
        System.out.println("ENTER '3' TO REMOVE THE TASK: ");
        System.out.println("ENTER '4' TO QUIT");
        return scanner.nextLine();
    }

    public String getRemoveTaskIndexNumber() {
        System.out.println("WHICH TASK YOU WANT TO REMOVE, ENTER THE INDEX NUMEBR:");
        return scanner.nextLine();
    }

    public String getDoneTaskIndexNumber() {
        System.out.println("WHICH TASK YOU WANT TO MARK AS DONE STATE,ENTER THE INDEX NUMBER:");
        return scanner.nextLine();
    }

    public String getUpdateTaskIndexOption() {
        System.out.println("WHICH TASK YOU WANT TO UPDATE, ENTER THE INDEX NUMBER:");
        return scanner.nextLine();
    }

    public List<String> getUpdateTaskFieldAndValue() {
        List<String> taskField = new ArrayList<>();
        System.out.println("ENTER THE FIELD, WHICH YOU WANT TO UPDATE :");
        taskField.add(scanner.nextLine().toLowerCase());

        System.out.println("ENTER THE VALUE, WHICH YOU WANT TO UPDATE TO: ");
        taskField.add(scanner.nextLine().toLowerCase());
        return taskField;
    }


}
