package com.toDoList.core.impl.command;

import com.toDoList.core.ErrorHandler;
import com.toDoList.core.TaskDao;
import com.toDoList.core.TaskPrinter;
import com.toDoList.core.impl.TaskPrinterImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class SearchCommand extends BaseDaoCommand{

    private  final TaskPrinter taskPrinter;

    protected SearchCommand(TaskDao taskDao, ErrorHandler errorHandler,TaskPrinter taskPrinter) {
        super(taskDao, errorHandler);
        this.taskPrinter = taskPrinter;
    }

    @Override
    public String getCommandName() {
        return "search";
    }

    @Override
    public void process(BufferedReader reader) {
        try{
            String line = reader.readLine();
            if(line.length()==0){
                errorHandler.handle("Необходимо указать параметры для поиска");
                return;
            }else{
                taskPrinter.print(taskDao.find(line,true));
            }
        }catch (IOException ex){
            errorHandler.handle("Упс, ошибка"+ex);
        }

    }
}
