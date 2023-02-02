package com.toDoList.core;

public class Tasks {

    private static final long DEFAULT_ID = -1;

    private long id = DEFAULT_ID;
    private  String description;
    private boolean done;

    public Tasks(){
    }

    public static Tasks of(String description){
        Tasks task = new Tasks();
        task.setName(description);
        return task;
    }

    public boolean isDone(){return done;}

    public void setDone(boolean isDone){
        this.done = isDone;
    }

    public String getName() {
        return description;
    }

    public void setName(String name) {
        this.description = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
