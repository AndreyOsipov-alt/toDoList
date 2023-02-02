package com.toDoList.core.impl;

import com.toDoList.core.ErrorHandler;

public class ErrorHandlerImpl implements ErrorHandler {
    @Override
    public void handle(String error) {
        System.err.println(error);
    }
}
