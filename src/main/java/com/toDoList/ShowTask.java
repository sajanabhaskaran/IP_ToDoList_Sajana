package com.toDoList;

import com.entity.Task;
import com.fileHandler.TaskFileHandler;
import com.io.UserInput;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ShowTask {
    private UserInput userInput;
    public ShowTask(UserInput userInput) {
        this.userInput=userInput;
    }
    /**
     * This method is used to get the user input for all the show task option.
     * This method makes use of sortByDate, sortByProject method.
     * @param filePath, the path of the taskfile.
     * @return Nothing.
     */
    public void sortOption(Path filePath) {
        String option = userInput.getShowTaskInputOption();
        switch (option) {
            case "1":
                sortByDate(filePath);
                break;
            case "2":
                sortByProject(filePath);
                break;
            case "3":
                System.exit(1);
                break;
            default:
                System.out.println("INVALID OPTION, PLEASE ENTER AGAIN!!");
                sortOption(filePath);
        }
    }
    /**
     * This method is used to sort the tasks by DueDate and prints the sorted task list.
     * @param filePath , the path of the taskfile.
     * @return Nothing.
     */

    private void sortByDate(Path filePath) {
        TaskFileHandler taskFileHandler = new TaskFileHandler();
        List<Task> taskList = taskFileHandler.convertFilesToList(filePath);
        Collections.sort(taskList, ((o1, o2) -> {
            Task task1 = (Task) o1;
            Task task2 = (Task) o2;
            return task1.getDueDate().compareTo(task2.getDueDate());
        }));
        System.out.println("TASCS SORTED BY DUE DATE ORDER: ");
        taskList.stream().forEach(System.out::println);
    }
    /**
     * This method is used to sort the tasks by Project and prints the sorted task list.
     * @param filePath .
     * @return Nothing.
     */
    private void sortByProject(Path filePath) {
        TaskFileHandler taskFileHandler = new TaskFileHandler();
        List<Task> taskList = taskFileHandler.convertFilesToList(filePath);
        Collections.sort(taskList, ((o1, o2) -> {
            Task task1 = (Task) o1;
            Task task2 = (Task) o2;
            return task1.getProject().toUpperCase().compareTo(task2.getProject().toUpperCase());
        }));
        System.out.println("TASCS SORTED BY PROJECT'S ALPHABETICAL ORDER: ");
        taskList.stream().forEach(System.out::println);
    }
    /**
     * This method is used to print all the task list.
     * @param filePath , the path of the task file .
     * @return Task List, the list contains all the tasks.
     */
    public List<Task> showAllTasks(Path filePath) {
        AtomicReference<Integer> n = new AtomicReference<>(1);
        TaskFileHandler taskFileHandler = new TaskFileHandler();
        List<Task> taskList = taskFileHandler.convertFilesToList(filePath);
        taskList.stream().forEach(line -> {
            System.out.print(n + " : ");
            System.out.println(line);
            n.updateAndGet(v -> v + 1);
        });
        return taskList;
    }

}
