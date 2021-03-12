package com.toDoList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class EditTask {
    private UserInput userInput;
    public EditTask(UserInput userInput) {
        this.userInput=userInput;
    }

    public void editOption(Path taskFile) {
        UserInput userInput = new UserInput();
        String input = userInput.getEditTaskInputOption();

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

        ShowTask showTask = new ShowTask(userInput);
        List<Task> taskList = showTask.showAllTasks(taskFile);

        UserInput userInput = new UserInput();
        Integer input = Integer.parseInt(userInput.getRemoveTaskIndexNumber());
        Integer listSize = taskList.size();
        if (input <= listSize) {
            taskList.remove(input - 1);
        } else {
            System.out.println("INVALID OPTION,SO THE PROGRAM IS TERMINATING");
            System.exit(1);
        }

        try {
            Files.delete(taskFile);
            Path path = Files.createFile(taskFile);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        AddTask addTask = new AddTask(userInput);
        if (addTask.addNewTaskToFile(taskList, taskFile)) {
            System.out.println("TASK REMOVED SUCCESSFULLY");
            taskList.stream().forEach(System.out::println);
        } else {
            System.out.println("UNSUCCESSFULL!!!!");
        }

    }


    private void markAsDone(Path taskFile) {

        ShowTask showTask = new ShowTask(userInput);
        List<Task> taskList = showTask.showAllTasks(taskFile);

        UserInput userInput = new UserInput();
        Integer input = Integer.parseInt(userInput.getDoneTaskIndexNumber());
        Integer listSize = taskList.size();
        if (input <= listSize) {
            taskList.get(input - 1).setStatus("Done");
        }
        try {
            Files.delete(taskFile);
            Path path = Files.createFile(taskFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        AddTask addTask = new AddTask(userInput);
        if (addTask.addNewTaskToFile(taskList, taskFile)) {
            System.out.println("TASK UPDATED SUCCESSFULLY");
            taskList.stream().forEach(System.out::println);
        } else {
            System.out.println("UNSUCCESSFULL!!!!");
        }
    }

    private void update(Path taskFile) {

        ShowTask showTask = new ShowTask(userInput);
        List<Task> taskList = showTask.showAllTasks(taskFile);

        UserInput userInput = new UserInput();
        Integer input = Integer.parseInt(userInput.getUpdateTaskIndexOption());
        Integer listSize = taskList.size();
        if (input > 0 && input <= listSize) {
            List<String> fieldValue = userInput.getUpdateTaskFieldAndValue();
            String fieldInput = fieldValue.get(0);
            String valueInput = fieldValue.get(1);
            if (fieldInput.equals("tasktitle") || fieldInput.equals("duedate") || fieldInput.equals("status") || fieldInput.equals("project")) {
                Task task = taskList.get(input - 1);
                switch (fieldInput) {
                    case "tasktitle":
                        task.setTaskTitle(valueInput);
                        break;
                    case "duedate":
                        AddTask addTask = new AddTask(userInput);
                        LocalDate dueDate=ToDoUtils.convertStringToDate(valueInput);
                        task.setDueDate(dueDate);
                        break;
                    case "status":
                        task.setStatus(valueInput);
                        break;
                    case "project":
                        task.setProject(valueInput);
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
            AddTask addTask = new AddTask(userInput);
            if (addTask.addNewTaskToFile(taskList, taskFile)) System.out.println("FILE UPDATED SUCCSESSFULLY");
            else System.out.println("FILE NOT UPDATED");
        } else {
            System.out.println("INVALID OPTION");
        }


    }
}
