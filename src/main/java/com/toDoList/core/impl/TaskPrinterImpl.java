package com.toDoList.core.impl;

import com.toDoList.core.TaskPrinter;
import com.toDoList.core.Tasks;

import java.util.stream.Stream;

public class TaskPrinterImpl implements TaskPrinter {
    @Override
    public void print(Stream<Tasks> task) {
       task.forEach(TaskPrinterImpl::printTask);
    }

    private static void printTask(Tasks task){
        System.out.printf("%d %s %s\n",task.getId(),task.isDone()? "[x]":"[ ]",task.getName());
    }
}
