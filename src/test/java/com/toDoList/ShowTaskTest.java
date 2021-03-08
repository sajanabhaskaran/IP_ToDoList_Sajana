package com.toDoList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ShowTaskTest {

    @Mock
    private UserInput userInput;

    private ShowTask showTask;

    @BeforeEach
    void init(){
        showTask= new ShowTask(userInput);
    }

    @Test
    public void testSortOption(){
        Mockito.when(userInput.getShowTaskInputOption()).thenReturn("1");
        showTask.sortOption(null);



    }

}
