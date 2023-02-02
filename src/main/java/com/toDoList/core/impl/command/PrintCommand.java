package com.toDoList.core.impl.command;

import com.toDoList.core.ErrorHandler;
import com.toDoList.core.TaskDao;
import com.toDoList.core.TaskPrinter;
import com.toDoList.core.Tasks;
import com.toDoList.core.impl.TaskPrinterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

public class PrintCommand extends BaseDaoCommand{

    private  final TaskPrinter taskPrinter;

    protected PrintCommand(TaskDao taskDao, ErrorHandler errorHandler,TaskPrinter taskPrinter) {
        super(taskDao, errorHandler);
        this.taskPrinter = taskPrinter;
    }

    @Override
    public String getCommandName() {
        return "print";
    }

    @Override
    public void process(BufferedReader reader) {
        try{
            String line = reader.readLine();
            boolean all = line.contains("all");

            if(!all && line.length()>0){
                errorHandler.handle("Недопустимый аргумент команды");
                return;
            }
            Stream<Tasks> tasks = taskDao.find(null,!all);
            taskPrinter.print(tasks);
        }catch (IOException ex){
                errorHandler.handle("Упс ошибка"+ ex);
        }

    }
}
