package com.softwarecafe.usingSpELGenericRepositiry;

import jakarta.persistence.Entity;

@Entity
public class SyncTask extends Task{
    @Override
    public void run() {

    }
    public static SyncTask of(String name){
        SyncTask task = new SyncTask();
        task.setName(name);
        return task;
    }

    @Override
    public String toString() {
        return "SyncTask{"+super.toString()+"}";
    }
}
