package com.toDoList.core;

import java.util.stream.Stream;

public interface TaskPrinter {

    void print(Stream<Tasks> task);
}
