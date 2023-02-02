package com.toDoList.core;

import java.io.BufferedReader;

public interface Command {
    String getCommandName();
    void process(BufferedReader reader);
}
