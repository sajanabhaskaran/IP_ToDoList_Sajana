package com.toDoList;

import java.nio.file.Path;

public class ToDoListMain {
    public static void main(String[] args) {
        ToDoListMain toDoListMain = new ToDoListMain();
        toDoListMain.mainPage();
    }

    private void mainPage() {
        TaskFileHandler taskFileHandler = new TaskFileHandler();
        Path taskFile = taskFileHandler.getTaskFile();

        UserInput userInput = new UserInput();
        String s = userInput.getMainUserInput();

        switch (s) {
            case "1":
                ShowTask showTask = new ShowTask(userInput);
                showTask.sortOption(taskFile);
                System.out.println("\n");
                mainPage();
                break;
            case "2":
                AddTask addTask = new AddTask(userInput);
                addTask.processAddTaskUserInputs(taskFile);

                mainPage();
                break;
            case "3":
                EditTask editTask = new EditTask(userInput);
                editTask.editOption(taskFile);
                mainPage();
                break;
            case "4":
                System.out.println("Tasks Saved ");
                System.exit(1);
                break;
            default:
                System.out.println("Invalid Option, please try again");
                mainPage();
        }

    }
}
