package com.toDoList.core;

public interface CommandFactory {

    Command getCommand(String command);
}
