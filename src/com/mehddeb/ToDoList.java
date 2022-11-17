package com.mehddeb;

import java.util.ArrayList;
import java.util.List;

public class ToDoList<T> {
    private T task;
    List<T> allTasks = new ArrayList<>(){};

    public T getTask(){
        return task;
    }

    public void setTask(T task){
        this.task = task;
    }

    public void addtask(T task){
        allTasks.add(task);
    }
}
