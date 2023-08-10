package com.softwarecafe.usingSpELGenericRepositiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExampleClient {
    @Autowired
    private AsyncTaskRepository repoAsync;
    @Autowired
    private SyncTaskRepository repoSync;

    public void run(){
        repoAsync.saveAll(Arrays.asList(AsyncTask.of("Scheduling"),
                AsyncTask.of("Cleaning")));
        repoSync.saveAll(Arrays.asList(SyncTask.of("Downloadin"),
                SyncTask.of("Reporting")));
        System.out.println("******** Finding Async Jobs *********");
        List<AsyncTask> list = repoAsync.findTaskByName("Cleaning");
        list.forEach(System.out::println);
        System.out.println("******** Finding Sync Jobs *********");
        List<SyncTask> list2 = repoSync.findTaskByName("Reporting");
        list2.forEach(System.out::println);

    }
}
