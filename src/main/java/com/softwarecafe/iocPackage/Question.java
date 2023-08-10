package com.softwarecafe.iocPackage;

import java.util.List;
import java.util.PrimitiveIterator;
import java.util.stream.Stream;

public class Question {
    private int id;
    private String name;
    private List<String> answers;


    public Question(){}

    public Question(int id, String name, List<String> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public void displayInfo(){
        System.out.println(id+" "+name);
        System.out.println("answers are");
        Stream<String> stream = answers.stream();
        stream.forEach(ans-> System.out.println(ans));
    }
}
