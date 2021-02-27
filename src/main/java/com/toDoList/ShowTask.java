package com.toDoList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ShowTask {
    public void showTaskFile(Path filePath){
        try(Stream<String> stream= Files.lines(filePath)) {
            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}
