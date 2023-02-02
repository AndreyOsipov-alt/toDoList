package com.toDoList.core.impl.command;

import com.toDoList.core.Command;
import com.toDoList.core.ErrorHandler;
import com.toDoList.core.TaskDao;

public abstract class BaseDaoCommand implements Command {
    protected final TaskDao taskDao;
    protected  final ErrorHandler errorHandler;

    protected BaseDaoCommand(TaskDao taskDao, ErrorHandler errorHandler){
        this.taskDao = taskDao;
        this.errorHandler = errorHandler;

    }
}
