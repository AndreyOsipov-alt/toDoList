package com.toDoList.core.impl.command;

import com.toDoList.core.ErrorHandler;
import com.toDoList.core.TaskDao;
import com.toDoList.core.Tasks;

import java.io.BufferedReader;
import java.io.IOException;

public class AddCommand extends BaseDaoCommand{
    @Override
    public String getCommandName() {
        return "add";
    }

    @Override
    public void process(BufferedReader reader) {
        try{
            String line = reader.readLine().trim();
            if (line.length() == 0) {
                errorHandler.handle("Необходимо ввести описание задачи");
                return;
            }
            taskDao.save(Tasks.of(line));
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    protected AddCommand(TaskDao taskDao, ErrorHandler errorHandler) {
        super(taskDao, errorHandler);
    }
}
