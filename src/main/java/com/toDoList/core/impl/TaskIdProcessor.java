package com.toDoList.core.impl;

import com.toDoList.core.ErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.LongConsumer;

public class TaskIdProcessor {

    private  final ErrorHandler errorHandler;

    public TaskIdProcessor(ErrorHandler errorHandler){this.errorHandler=errorHandler;}

    public  void process(BufferedReader reader, LongConsumer consumer){
        long taskId;
        try {
            String id = reader.readLine().trim();
            if(id.length()==0){
                errorHandler.handle("Не указан идентификатор задачи");
                return;
            }

            taskId = Long.parseLong(id);

        }catch (IOException|NumberFormatException ex){
            errorHandler.handle("Неверный формат идентификатора задачи (должно быть целое число)");
            return;
        }
        consumer.accept(taskId);
    }


}
