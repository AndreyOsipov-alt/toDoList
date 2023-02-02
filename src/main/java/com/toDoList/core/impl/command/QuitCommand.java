package com.toDoList.core.impl.command;

import com.toDoList.core.Command;

import java.io.BufferedReader;

public class QuitCommand implements Command {

    @Override
    public String getCommandName() {
        return "quit";
    }

    @Override
    public void process(BufferedReader reader) { System.exit(0);

    }
}
