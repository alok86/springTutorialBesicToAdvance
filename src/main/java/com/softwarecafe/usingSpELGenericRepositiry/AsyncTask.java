package com.softwarecafe.usingSpELGenericRepositiry;

import jakarta.persistence.Entity;

@Entity
public class AsyncTask extends Task{
    @Override
    public void run() {

    }
    public static AsyncTask of(String name){
        AsyncTask task = new AsyncTask();
        task.setName(name);
        return task;
    }

    @Override
    public String toString() {
        return "AsyncTask{"+super.toString()+"}";
    }
}
