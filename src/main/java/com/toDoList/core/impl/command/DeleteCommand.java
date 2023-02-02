package com.toDoList.core.impl.command;

import com.toDoList.core.ErrorHandler;
import com.toDoList.core.TaskDao;
import com.toDoList.core.Tasks;
import com.toDoList.core.impl.TaskIdProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

public class DeleteCommand extends  BaseDaoCommand{

    private final TaskIdProcessor processor;

    protected DeleteCommand(TaskDao taskDao, ErrorHandler errorHandler) {
        super(taskDao, errorHandler);
        processor = new TaskIdProcessor(errorHandler);
    }

    @Override
    public String getCommandName() {
        return "delete";
    }

    @Override
    public void process(BufferedReader reader) {
       processor.process(reader, taskDao::delete);

    }
}
