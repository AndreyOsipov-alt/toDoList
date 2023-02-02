package com.toDoList.core.impl.command;

import com.toDoList.core.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StaticCommandFactory implements CommandFactory {

    private final Map<String, Command> commands;

    public StaticCommandFactory(TaskDao taskDao, ErrorHandler errorHandler, TaskPrinter taskPrinter){
        Map<String,Command> map = new HashMap<>();
        Command command = new AddCommand(taskDao,errorHandler);
        map.put(command.getCommandName(), command);

        command = new DeleteCommand(taskDao,errorHandler);
        map.put(command.getCommandName(), command);

        command = new QuitCommand();
        map.put(command.getCommandName(), command);

        command = new EditCommand(taskDao,errorHandler);
        map.put(command.getCommandName(), command);

        command = new ToggleCommand(taskDao,errorHandler);
        map.put(command.getCommandName(), command);

        command = new PrintCommand(taskDao,errorHandler,taskPrinter);
        map.put(command.getCommandName(),command);

        command = new SearchCommand(taskDao,errorHandler,taskPrinter);
        map.put(command.getCommandName(), command);

        this.commands = Collections.unmodifiableMap(map);


    }
    @Override
    public Command getCommand(String command) {
        return commands.get(command);
    }
}
