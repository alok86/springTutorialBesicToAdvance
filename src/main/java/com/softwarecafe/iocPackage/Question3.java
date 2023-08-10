package com.softwarecafe.iocPackage;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor

public class Question3 {
    private int id;
    private String name;
    private Map<Answer3 , User> answer;

    public void displayInfo()
    {
        System.out.println("Question id "+id);
        System.out.println("Question "+name);
        System.out.println("answers ...");
        Set<Map.Entry<Answer3,User>> set = answer.entrySet();
        Stream<Map.Entry<Answer3, User>> stream = set.stream();
        stream.forEach(ans-> {
            Map.Entry<Answer3,User> entry = ans;
            System.out.println("Answers .."+ entry.getKey()+"\nposted By"+entry.getValue());
        });
    }
}
