package com.toDoList.core.impl.command;

import com.toDoList.core.ErrorHandler;
import com.toDoList.core.TaskDao;
import com.toDoList.core.Tasks;
import com.toDoList.core.impl.TaskIdProcessor;

import java.io.BufferedReader;
import java.util.Optional;

public class ToggleCommand  extends BaseDaoCommand{

    private final TaskIdProcessor processor;

    protected ToggleCommand(TaskDao taskDao, ErrorHandler errorHandler) {
        super(taskDao, errorHandler);
        processor = new TaskIdProcessor(errorHandler);
    }

    @Override
    public String getCommandName() {
        return "toggle";
    }

    @Override
    public void process(BufferedReader reader) {

        processor.process(reader, id ->{
            Optional<Tasks> t = taskDao.get(id);
            if(t.isPresent()){
                Tasks task = t.get();
                task.setDone(!task.isDone());
            }
        });


    }
}
