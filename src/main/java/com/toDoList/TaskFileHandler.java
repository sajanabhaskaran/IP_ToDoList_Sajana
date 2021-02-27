package com.toDoList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskFileHandler {
    private String taskFileName = "SDA9_IP_TaskFile.rtf";
    public Path getTaskFile(){
        String userHomeDirectory= System.getProperty("user.home");
        String taskFilePath= userHomeDirectory + File.separator + taskFileName;
        Path path= Paths.get(taskFilePath);
        try {
            path=Files.createFile(path);

        } catch (IOException e) {

        }
         return path;
    }

}
