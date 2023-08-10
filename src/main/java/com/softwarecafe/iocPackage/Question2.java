package com.softwarecafe.iocPackage;

import java.util.List;
import java.util.stream.Stream;

public class Question2 {
    private int id;
    private String name;
    private List<Answer> answers;

    public Question2(int id, String name, List<Answer> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public void displayInfo()
    {
        System.out.println("Question Id : "+this.id+"\n Question is :"+this.name+"\n");
        Stream<Answer> stream = answers.stream();
        stream.forEach(answer -> System.out.println(answer.toString()));
    }
}
