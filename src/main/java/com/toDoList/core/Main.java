package com.toDoList.core;

import com.toDoList.core.impl.ErrorHandlerImpl;
import com.toDoList.core.impl.TaskDaoImpl;
import com.toDoList.core.impl.TaskPrinterImpl;
import com.toDoList.core.impl.command.StaticCommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    private static final Logger logger =LoggerFactory.getLogger(Main.class);


    public static void main(String[] args)  {

        final Pattern pattern = Pattern.compile("(\\S+)\\s");

       final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final ErrorHandler errorHandler = new ErrorHandlerImpl();
        final TaskDao taskDao = new TaskDaoImpl();
        final TaskPrinter taskPrinter = new TaskPrinterImpl();
        final CommandFactory commandFactory = new StaticCommandFactory(taskDao,errorHandler,taskPrinter);

        System.out.println("1.add - добавление задачи\n" +
                " 2.print - печать списка задач\n" +
                " 3.search - поиск задачи\n" +
                " 4.toggle - изменение статуса задачи\n" +
                " 5.delete - удаоение команды\n" +
                " 6.edit - изменение команды\n" +
                " 7.quit - завершение работы");

        try {

            while (!reader.ready()) {
                Command command = commandFactory.getCommand(reader.readLine().trim());
                logger.debug("User input: {}", "что-то");
                if (command != null) {
                    command.process(reader);
                } else {
                    logger.error("Не верная команда");
                }}
            }catch(IOException ex){
                logger.error("Error: {}",ex);

            }






    }


}





