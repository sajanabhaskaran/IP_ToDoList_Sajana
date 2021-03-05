package com.toDoList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskFileHandler {
    private String taskFileName = "SDA9_IP_TaskFile.txt";

    public Path getTaskFile() {
        String userHomeDirectory = System.getProperty("user.home");
        String taskFilePath = userHomeDirectory + File.separator + taskFileName;
        Path path = Paths.get(taskFilePath);

        try {
            path = Files.createFile(path);
        } catch (IOException e) {
        }
        return path;
    }

    public List<Task> convertFilesToList(Path taskFile) {
        List<Task> taskList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(taskFile)) {
            taskList = stream.map(line -> {
                String[] parts = line.split(",");
                String title = parts[0];
                String stringdueDate = parts[1];
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                Date dueDate= null;
                try {
                    dueDate = sdf.parse(stringdueDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String status = parts[2];
                String project = parts[3];
                return (new Task(title, dueDate, status, project));
            }).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return taskList;
    }
}
